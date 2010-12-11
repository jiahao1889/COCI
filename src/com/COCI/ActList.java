package com.COCI;

import java.sql.*;
import java.util.ArrayList;

/**
 * The list of activities class.
 * @author COCI group
 * @since 2010-10-25
 */
public class ActList {
	
	public ArrayList<Activity> AllActs() throws ClassNotFoundException, SQLException
	{
ArrayList<Activity> all = new ArrayList<Activity>();
		

	    Connection connection = SqlString.connectSql();
	    Statement statement1=connection.createStatement();
        
	    /*statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('2act',1,now())");
	    statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('1act',2,now())");
	    statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('3act',3,now())");
	    statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('4act',4,now())");*/

        String sql="SELECT * FROM "+tableName;
	    ResultSet rs = statement1.executeQuery(sql);
	    
	    
	    while(rs.next()) {
	    	String n = rs.getString(2);
	    	int actid = rs.getInt(1);
	    	Timestamp cdate = rs.getTimestamp(4);
	    	Activity tmp = new Activity(n,actid,cdate);
	    	all.add(tmp);
	    }
	    
	    rs.close();
	    statement1.close();
	    connection.close();
		return all;
		
	}
	
	public void SearchByDate()
	{
		
	}
	
	public void SearchByFocus()
	{
		
	}
	
	public void SearchByGroup()
	{
		
	}
	
	public void DelAct(int aID)throws ClassNotFoundException, SQLException
	{

	    
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		
		String sql="DELETE FROM "+tableName + " WHERE a_id = " + aID;
	    statement1.executeUpdate(sql);
	    statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
		
	}
	
	public void AddAct(String title,String content,String place,String acturl,Timestamp actDate,
			Timestamp deadline,int classify,int maxnum,int uid) throws ClassNotFoundException, SQLException
	{

	    Connection connection = SqlString.connectSql();
	    Statement statement1=connection.createStatement();
        
	    /*statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('2act',1,now())");
	    statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('1act',2,now())");
	    statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('3act',3,now())");
	    statement1.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('4act',4,now())");*/

        String sql="INSERT INTO act(name,creator_id,create_date,act_date,act_place,act_describe,act_url,deadline_date,classify,maxnum) VALUES(?,?,now(),?,?,?,?,?,?,?)";
        
        PreparedStatement Pstatement = connection.prepareStatement(sql);
	    Pstatement.setString(1,title);
	    Pstatement.setInt(2, uid);
	    Pstatement.setTimestamp(3, actDate);
	    Pstatement.setString(4,place);
	    Pstatement.setString(5,content);
	    Pstatement.setString(6,acturl);
	    Pstatement.setTimestamp(7, deadline);
	    Pstatement.setInt(8, classify);
	    Pstatement.setInt(9, maxnum);

	    Pstatement.executeUpdate();

	    statement1.close();
	    connection.close();
		
	}
    private String dbName="coci";
    private String tableName="act";
	//modified by WQY QJ
	//private ArrayList<Activity> aList;

}
