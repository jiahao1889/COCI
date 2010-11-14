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
