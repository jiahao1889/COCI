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
	public Activity(int id)throws ClassNotFoundException, SQLException
	{
		    String dbName="coci";
		    String tableName="act";
		    Connection connection = SqlString.connectSql();
		    java.sql.Statement statement1=connection.createStatement();

	        String sql="SELECT * FROM "+ tableName+" WHERE a_id= " + id;
		    ResultSet rs = statement1.executeQuery(sql);
		   while(rs.next()) {
		    	String n = rs.getString(2);
		    	Timestamp cdate = rs.getTimestamp(4);
		    	actID = id;
				title = n;
				actDate = cdate;
		    }
		    
		    rs.close();
		    statement1.close();
		    connection.close();

	}
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
	
	private int actID;
	private String title;
	private Timestamp actDate;

}
