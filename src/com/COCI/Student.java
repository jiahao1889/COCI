package com.COCI;
import java.sql.*;
/**
 * The student user class.
 * @author COCI group
 * @since 2010-10-25
 */
public class Student extends User {
	public Student(String n,String p)
	{
		super(n, p);
	}
	public String judgeFocus(int id,int uid)throws ClassNotFoundException, SQLException{
		 String dbName="coci";
		 String tableName="care";
		 Connection connection = SqlString.connectSql();
		java.sql.Statement statement1=connection.createStatement();

		 String sql="SELECT * FROM "+ tableName+" WHERE a_id= "+id+" AND u_id= "+uid;
	     ResultSet rs = statement1.executeQuery(sql);
	     String s;
			   if(rs.next()) {
				   rs.close();
				     statement1.close();
				     connection.close();
			    	return s="delete the concern";
			    }
			    else{
			    	 rs.close();
				     statement1.close();
				     connection.close();
			       return  s="concern about it";
			    }
	}
	public void Focus(int use_id,int ac_id,String k)throws ClassNotFoundException, SQLException
	{
		
	    String dbName="coci";
		String tableName="care";
		Connection connection = SqlString.connectSql();
		java.sql.Statement statement1=connection.createStatement();

	   
	   if (k.equals("concern about it"))
	    {
	       
	        String  sql = "INSERT INTO care(u_id,a_id) VALUES(?,?)";
		    PreparedStatement Pstatement = connection.prepareStatement(sql);
		    Pstatement.setInt(1,use_id);
		    Pstatement.setInt(2,ac_id);
		    Pstatement.executeUpdate();
		    Pstatement.close();
	    }
	    if (k.equals("delete the concern")){
	       
	        String sql = "DELETE FROM care WHERE u_id= "+use_id+" AND a_id= "+ac_id; 
	     
		   statement1.execute(sql);
	    }
	   
	    statement1.close();
		connection.close();
		
	}
	
	public void Application()
	{
		
	}

}
