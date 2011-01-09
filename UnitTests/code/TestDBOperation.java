package COCI.Test;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.COCI.SqlString;

/**
 * JUnit test of DB operation
 * @author COCI group
 * @since 2011-1-1
 */
public class TestDBOperation {

	private static Connection connection;
	private Statement statement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connection = SqlString.connectSql();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection.close();
	}

	@Before
	public void setUp() throws Exception {
	    statement=connection.createStatement();
	}

	@After
	public void tearDown() throws Exception {
		statement.close();
	}
	
	@Test(timeout = 1000)
	public void TestInsert() throws SQLException {
		String sql = "INSERT INTO user(authority,username,passworld,create_date) VALUES(1,'testu','testp',now())";
		int affectedRows = statement.executeUpdate(sql);
		assertEquals("Affected rows number of insert", 1, affectedRows);
	}
	
	@Test(timeout = 1000)
	public void TestQuery() throws SQLException {
		String sql = "SELECT * FROM USER WHERE username = 'testu'";
		ResultSet resultSet = statement.executeQuery(sql);
		assertTrue("Query fail",resultSet.next());
		resultSet.close();
	}
	
	@Test(timeout = 1000)
	public void TestDelete() throws SQLException {
		String sql = "DELETE FROM USER WHERE username = 'testu'";
		int affectedRows = statement.executeUpdate(sql);
		assertEquals("Affected rows number of delete", 1, affectedRows);
	}

}
