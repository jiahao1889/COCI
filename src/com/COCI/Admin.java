package com.COCI;

import java.sql.SQLException;

/**
 * The administrator user class.
 * @author COCI group
 * @since 2010-10-25
 */
public class Admin extends User {
	
	public Admin(String n,String p)
	{
		super(n, p);
	}
	
	public void privilege(int aID,int pri)
	{
		//Ȩ�� 1ѧ�� 2���� 3����
		
	}
	
	public void DelActivity(int aID)throws ClassNotFoundException, SQLException
	{
		ActList a=new ActList();
		a.DelAct(aID);
		
	}
	
	public void DelUser()
	{
		
	}	

}
