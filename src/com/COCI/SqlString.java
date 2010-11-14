package com.COCI;
import java.sql.*;

public class SqlString {

	        public final static String url="jdbc:mysql://localhost:3306/coci";
	        public final static String usrname="root";
	        public final static String password = null;
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
