package com.COCI;

import java.sql.*;

/**
 * The activity class.
 * @author COCI group
 * @since 2010-10-25
 */
public class Activity {
	public Activity()
	{

	}
	
	//modified by QJ 2010-11-19
	/**
	 * The constructor of an activity class.
	 * This function can create an activity by searching its activity id from the database.
	 * @param int id
	 */
	public Activity(int id)throws ClassNotFoundException, SQLException
	{
		  
		  Connection connection = SqlString.connectSql();
		  java.sql.Statement statement1=connection.createStatement();

	      String sql="SELECT * FROM "+ tableName+" WHERE a_id= " + id;
		  ResultSet resultSet = statement1.executeQuery(sql);
		  while(resultSet.next()) {
		      String n = resultSet.getString(2);
		      Timestamp cdate = resultSet.getTimestamp(4);
		      actID = id;
			  title = n;
			  actDate = cdate;
			  actContent = resultSet.getString(7);
		  }
		    
		  resultSet.close();
		  statement1.close();
		  connection.close();
	}
	
	/**
	 * The constructor of an activity class.
	 * This function can create an activity by a activity name, an activity id and an created date.
	 * @param String name, int a_id, Timestamp adate
	 */
	public Activity(String name, int a_id, Timestamp adate)
	{
		actID = a_id;
		title = name;
		actDate = adate;
	}
	
	
	public int getID()
	{
		return actID;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public Timestamp getDate()
	{
	    return actDate;	
	}
	
	public void Modify()
	{
		
	}
	
	public String getContent()
	{
	    return actContent;
	}
	
	private int actID;
	private String title;
	private Timestamp actDate;
	private String actContent = null;
	private String dbName="coci";
	private String tableName="act";

}
