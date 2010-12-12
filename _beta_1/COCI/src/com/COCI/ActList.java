package com.COCI;

import java.sql.*;
import java.util.ArrayList;

/**
 * The list of activities class.
 * @author COCI group
 * @since 2010-10-25
 */
public class ActList {
	
	
	//modified by QJ 2010-11-19
	/**
	 * The function is to find all the activities from the database;
	 * @return  ArrayList<Activity>.
	 */
	public ArrayList<Activity> AllActs() throws ClassNotFoundException, SQLException
	{
        ArrayList<Activity> all = new ArrayList<Activity>();
	    Connection connection = SqlString.connectSql();
	    Statement statement1=connection.createStatement();
        String sql="SELECT * FROM "+tableName;
	    ResultSet resultSet = statement1.executeQuery(sql);
	    
	    while(resultSet.next()) {
	    	String n = resultSet.getString(2);
	    	int actid = resultSet.getInt(1);
	    	Timestamp cdate = resultSet.getTimestamp(4);
	    	Activity tmp = new Activity(n,actid,cdate);
	    	all.add(tmp);
	    }
	    
	    resultSet.close();
	    statement1.close();
	    connection.close();
		return all;
		
	}
	
	/**
	 * The function is to find the latest 10 item of activities from the database;
	 * @return  ArrayList<Activity>.
	 */
	public ArrayList<Activity> TopTenActs() throws ClassNotFoundException, SQLException
	{
        ArrayList<Activity> topTenActs = new ArrayList<Activity>();
	
	    Connection connection = SqlString.connectSql();
	    Statement statement1=connection.createStatement();
        String sql="SELECT * FROM "+tableName +" order by a_id DESC limit 10";
	    ResultSet rs = statement1.executeQuery(sql);
	    
	    while(rs.next()) {
	    	String n = rs.getString(2);
	    	int actid = rs.getInt(1);
	    	Timestamp cdate = rs.getTimestamp(4);
	    	Activity tmp = new Activity(n,actid,cdate);
	    	topTenActs.add(tmp);
	    }
	    
	    rs.close();
	    statement1.close();
	    connection.close();
		return topTenActs;
	}
	
	public void SearchByDate()
	{
		
	}
	
	//modified by YXY,WHD 2010-11-25
	/**
	 * The function is to find the focused activities of a user from the database;
	 * @param int uID.
	 * @return  ArrayList<Activity>.
	 */
	public ArrayList<Activity> SearchByFocus(int uID)throws ClassNotFoundException, SQLException
	{
		ArrayList<Activity> personActivityList = new ArrayList<Activity>();

	    Connection connection = SqlString.connectSql();
	    Statement statement1=connection.createStatement();
        String sql="SELECT * FROM "+tableName+",care WHERE care.u_id="+uID+" AND "+tableName+".a_id=care.a_id";
	    ResultSet resultSet = statement1.executeQuery(sql);
	    
	    while(resultSet.next()) {
	    	String name = resultSet.getString(2);
	    	int actid = resultSet.getInt(1);
	    	Timestamp cdate = resultSet.getTimestamp(4);
	    	Activity focusActivity = new Activity(name,actid,cdate);
	    	personActivityList.add(focusActivity);
	    }
	    
	    resultSet.close();
	    statement1.close();
	    connection.close();
		return personActivityList;

	}
	
	public void SearchByGroup()
	{
		
	}
	
	//modified by YXY,WHD 2010-11-19
	/**
	 * The function is to delete an activity  from the database;
	 * @param int uID.
	 */
	public void DelAct(int aID)throws ClassNotFoundException, SQLException
	{
	    Connection connection = SqlString.connectSql();
	    java.sql.Statement statement1=connection.createStatement();
		
		String sql="DELETE FROM "+tableName + " WHERE a_id = " + aID;
	    statement1.executeUpdate(sql);
	    statement1.close();     // 释放Statement对象
	    connection.close();   // 关闭到MySQL服务器的连接
		
	}
	
	//modified by WQY,WHD 2010-11-25
	/**
	 * The function is to add an activity to the database;
	 * @param String title,String content,String place,String acturl,Timestamp actDate,
			Timestamp deadline,int classify,int maxnum,int uid.
	 */
	public void AddAct(String title,String content,String place,String acturl,Timestamp actDate,
			Timestamp deadline,int classify,int maxnum,int uid) throws ClassNotFoundException, SQLException
	{

	    Connection connection = SqlString.connectSql();
	    Statement statement1=connection.createStatement();
      
        String sql="INSERT INTO act(name,creator_id,create_date,act_date,act_place,act_describe,act_url,deadline_date,classify,maxnum)" +
        		" VALUES(?,?,now(),?,?,?,?,?,?,?)";
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
