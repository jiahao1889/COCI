package com.COCI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 * The default user class.
 * @author COCI group
 * @since 2010-10-25
 */
public class User {
	
	public User()
	{

	}
	
	/**
	 * The constructor of a user class.
	 * This function can create an Group by  its name and password.
	 * a user initialized to have a negative id(-1).
	 * @param int id
	 */
	//modified by QJ 2010-10-28
	public User(String userName, String userPassword)
	{
		this.userName = userName;
		this.password = userPassword;
        ID = -1;
	}
	
	/**
	 * The constructor of a user class.
	 * This function can create an Group by  its name and password.
	 * a user initialized to have a negative id(-1).
	 * @param int id
	 */
	//modified by CDS 2010-11-1
	public boolean Register(String name, String password, String email,String telephone) 
	throws ClassNotFoundException, SQLException
	{
	    
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		String sql="SELECT * FROM "+tableName;
	    ResultSet resultSet = statement1.executeQuery(sql);
	    while(resultSet.next()) {
	    	System.out.println(resultSet.getString("username"));
	    }
	    
	    resultSet = statement1.executeQuery(sql);
	    while(resultSet.next()) {
	    	if( resultSet.getString("username").equals(name) )
	    	{
                return false;
	    	}
	    }
	    sql = "INSERT INTO user(authority,username,passworld,email,telephone,create_date) VALUES(1,?,?,?,?,now())";
	    PreparedStatement Pstatement = connection.prepareStatement(sql);
	    Pstatement.setString(1,name);
	    Pstatement.setString(2,password);
	    Pstatement.setString(3,email);
	    Pstatement.setString(4,telephone);
	    Pstatement.executeUpdate();
	    Pstatement.close();
        statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
        resultSet.close();
        return true;
	}
	
	/**
	 * This function is used for a user to log in.
	 * @return int.
	 */
	//modified by WQY 2010-11-1
	public int Login() throws ClassNotFoundException, SQLException
	{
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		String sql="SELECT * FROM USER WHERE username = '"+userName;
		sql += "' AND passworld ='";
		sql +=password;
		sql+="'";
	    ResultSet resultSet = statement1.executeQuery(sql);
	    if(resultSet.next()) {
	    	ID = resultSet.getInt("u_id");
	    	return resultSet.getInt("authority");
	    	
	    }
        statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
        resultSet.close();
      
		return 0;
	}
	
	public String getName()
	{
		return userName;
	}
	
	/**
	 * This function is used to find the user ID of a user.
	 * @return int.
	 */
	//modified by QJ 2010-11-4
	public int getID() throws ClassNotFoundException, SQLException
	{
		if(this.ID!=-1)
			return this.ID;
	    
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		String sql="SELECT * FROM USER WHERE username = '"+userName;
		sql += "' AND passworld ='";
		sql +=password;
		sql+="'";
	    ResultSet resultSet = statement1.executeQuery(sql);
	  
	    if(resultSet.next()) {
	    	ID = resultSet.getInt("u_id");
	    }
        statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
        resultSet.close();

		return this.ID;
	}
	
	protected int ID;
	protected String userName;
	protected String password;
	private String dbName="coci";
    private String tableName="user";

}
