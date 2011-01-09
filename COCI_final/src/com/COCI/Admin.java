package com.COCI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The administrator user class.
 * @author COCI group
 * @since 2010-10-25
 */
public class Admin extends User {
	
	
	/**
	 * The constructor of an Admin class.
	 * This function can create an administrator by its name and password.
	 * @param String name,String password.
	 */
	public Admin(String name,String password)
	{
		super(name, password);
	}
	
	/**
	 * The function is to modify the privilege of a user.
	 * 1 for the student ,2 for the group, 3 for the administrator.
	 * @param String uName,int pri.
	 */
	//modified by YXY,WHD 2010-11-25
	public void privilege(String uName,int pri)throws ClassNotFoundException, SQLException
	{
		String dbName="coci";
		String tableName="user";
		Connection connection = SqlString.connectSql();
		java.sql.Statement statement1=connection.createStatement();
		String sql = "SELECT * from "+tableName+" where username= '"+uName+"'";
		ResultSet resultSet = statement1.executeQuery(sql);
		 
		int uID = -1;
	    while(resultSet.next()) {
	    	 uID = resultSet.getInt(1);
	    }
	    
		 String sql1="UPDATE "+tableName+" SET authority="+pri+" WHERE u_id= "+uID;
	     statement1.execute(sql1);
		 statement1.close();
	     connection.close();


	}
	
	/**
	 * The function is to delete an activity by the administrator.
	 * 1 for the student ,2 for the group, 3 for the administrator.
	 * @param int aID
	 */
	//modified by CDS, 2010-11-9
	public void DelActivity(int aID)throws ClassNotFoundException, SQLException
	{
		ActList a=new ActList();
		a.DelAct(aID);
		
	}
	
	public void DelUser()
	{
		
	}	

}
