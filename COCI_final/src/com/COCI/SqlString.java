package com.COCI;
import java.sql.*;


/**
 * The sqlString class .
 * This class is used to connect with the database.
 */
//created by WQY,QJ 2010-11-4
public class SqlString {
	        public final static String url="jdbc:mysql://localhost:3306/coci";
	        public final static String usrname="root";
	        public final static String password = "91002100";
	        public final static String dll = "com.mysql.jdbc.Driver";
		    public final static Connection connectSql()
		    {
		    	java.sql.Connection connection = null;
		    try {
				Class.forName(dll);
			    connection = java.sql.DriverManager.getConnection( 
					    url, usrname, password);
			    
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    return connection;
		    }

}
