package com.COCI;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * The group user class.
 * @author COCI group
 * @since 2010-10-25
 */
public class Group extends User {
	
	/**
	 * The constructor of an Group class.
	 * This function can create an Group by  its name and password.
	 * @param int id
	 */
	public Group(String name,String password)
	{
		super(name, password);
	}
	public void AddAct(String title,String content,String place,String acturl,Timestamp actDate,
			Timestamp deadline,int classify,int maxnum,int uid) throws ClassNotFoundException, SQLException
			
	{
		ActList a=new ActList();
		a.AddAct(title, content, place,acturl,actDate,
				deadline,classify,maxnum,uid) ;
	}

	public void DelAct(int aID)throws ClassNotFoundException, SQLException
	{
		ActList a=new ActList();
		a.DelAct(aID);		
	}
	
	public void ModifyAct()
	{
		
	}
	
	public void CollectApp()
	{
		
	}

}
