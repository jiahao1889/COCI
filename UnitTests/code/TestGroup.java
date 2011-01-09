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

import com.COCI.Group;
import com.COCI.SqlString;

/**
 * JUnit test of Group class
 * @author COCI group
 * @since 2011-1-2
 */

public class TestGroup {

	private static Group group;
	private static Connection connection;
	private Statement statement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		group = new Group("group","group");
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
	public void testAddAct() throws ClassNotFoundException, SQLException {
		group.AddAct("testact", "test", null, null, null, null, 0, 100, group.getID());
		String sql = "SELECT * FROM ACT WHERE name = 'testact'";
		int resultCount = countOfQuery(sql);
		assertEquals("Add act uncorrectly", 1, resultCount);
	}

	@Test(timeout = 1000)
	public void testDelAct() throws SQLException, ClassNotFoundException {
		int delId=getMAXactID();
		group.DelAct(delId);
		int resultCount = countOfQuery("SELECT * FROM ACT WHERE a_id ="+delId);
		assertEquals("Del act uncorrectly", 0, resultCount);
	}
	
	public int getMAXactID() throws SQLException
	{
		ResultSet resultSet = statement.executeQuery("SELECT a_id FROM ACT ORDER BY a_id DESC limit 1");
		resultSet.next();
		int maxid=resultSet.getInt("a_id");
		resultSet.close();
		return maxid;
	}
    
	public int countOfQuery(String sql) throws SQLException{
		ResultSet resultSet= statement.executeQuery(sql);
		resultSet.last();
		int count = resultSet.getRow();
		resultSet.close(); 
		return count;
	}
}
