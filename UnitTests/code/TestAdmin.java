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

import com.COCI.Admin;
import com.COCI.SqlString;

/**
 * JUnit test of Admin class
 * @author COCI group
 * @since 2011-1-2
 */
public class TestAdmin {
    private static Admin admin;
	private static Connection connection;
	private Statement statement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		admin = new Admin("admin","admin");
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
	public void testPrivilege() throws SQLException, ClassNotFoundException {
		addUserForTest();
		admin.privilege("testu", 2);
		ResultSet resultSet=statement.executeQuery("SELECT * FROM user WHERE username = 'testu'");
		assertTrue("User not exist",resultSet.next());
		assertEquals("Set privilege fail",2,resultSet.getInt("authority"));
		deleteUser();
	}

	@Test(timeout = 1000)
	public void testDelActivity() throws SQLException, ClassNotFoundException {
		addActForTest();
		int delId=getMAXactID();
		admin.DelActivity(delId);
		ResultSet resultSet = statement.executeQuery("SELECT * FROM ACT WHERE a_id ="+delId);
		assertFalse("Del act uncorrectly", resultSet.next());
		resultSet.close();
	}

	public int getMAXactID() throws SQLException
	{
		ResultSet resultSet = statement.executeQuery("SELECT a_id FROM ACT ORDER BY a_id DESC limit 1");
		resultSet.next();
		int maxid=resultSet.getInt("a_id");
		resultSet.close();
		return maxid;
	}
	
	public void addUserForTest() throws SQLException{
		statement.executeUpdate("INSERT INTO user(authority,username,passworld,create_date) VALUES(1,'testu','testp',now())");
	}
	
	public void deleteUser() throws SQLException{
	    statement.executeUpdate("DELETE FROM user WHERE username = 'testu'");	
	}
	
	public void addActForTest() throws SQLException{
		statement.executeUpdate("INSERT INTO act(name,creator_id,create_date) VALUES('testa',1,now())");
	}
}
