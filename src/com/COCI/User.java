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
	
	public User(String n, String p)
	{
		userName = n;
		password = p;
        ID = -1;
	}
	
	public boolean Register(String n, String p, String e,String t) throws ClassNotFoundException, SQLException
	{
		String dbName="coci";
	    String tableName="user";
	    
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		
		String sql="SELECT * FROM "+tableName;
	    ResultSet rs = statement1.executeQuery(sql);
	    
	    
	    while(rs.next()) {
	    	System.out.println(rs.getString("username"));
	    }
	    
	    rs = statement1.executeQuery(sql);
	    while(rs.next()) {
	    	if( rs.getString("username").equals(n) )
	    	{
                return false;
	    	}
	    }
       
	    sql = "INSERT INTO user(authority,username,passworld,email,telephone,create_date) VALUES(1,?,?,?,?,now())";
	    PreparedStatement Pstatement = connection.prepareStatement(sql);
	    Pstatement.setString(1,n);
	    Pstatement.setString(2,p);
	    Pstatement.setString(3,e);
	    Pstatement.setString(4,t);
	    Pstatement.executeUpdate();
	   
	    Pstatement.close();
        statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
        rs.close();
      
        return true;

	}
	
	
	public int Login() throws ClassNotFoundException, SQLException
	{
		String dbName="coci";
	    String tableName="user";
	    
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		
		String sql="SELECT * FROM USER WHERE username = '"+userName;
		sql += "' AND passworld ='";
		sql +=password;
		sql+="'";
	    ResultSet rs = statement1.executeQuery(sql);
	    
	    
	    if(rs.next()) {
	    	ID = rs.getInt("u_id");
	    	return rs.getInt("authority");
	    	
	    }
	    
        statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
        rs.close();
      
		return 0;
	}
	
	public String getName()
	{
		return userName;
	}
	
	public int getID() throws ClassNotFoundException, SQLException
	{
		if(this.ID!=-1)
			return this.ID;
		String dbName="coci";
	    String tableName="user";
	    
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		
		String sql="SELECT * FROM USER WHERE username = '"+userName;
		sql += "' AND passworld ='";
		sql +=password;
		sql+="'";
	    ResultSet rs = statement1.executeQuery(sql);
	    
	    
	    if(rs.next()) {
	    	ID = rs.getInt("u_id");
	    	
	    	
	    }
	    
        statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
        rs.close();
      
		return this.ID;
	}
	

	
	protected int ID;
	protected String userName;
	protected String password;

}
