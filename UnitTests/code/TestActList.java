package COCI.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.COCI.ActList;
import com.COCI.Activity;
import com.COCI.SqlString;

/**
 * JUnit test of ActList class
 * 
 * @author COCI group
 * @since 2011-1-2
 */
public class TestActList {

	private static ActList actList;
	private static Connection connection;
	private Statement statement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		actList = new ActList();
		connection = SqlString.connectSql();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connection.close();

	}

	@Before
	public void setUp() throws Exception {
		statement = connection.createStatement();
	}

	@After
	public void tearDown() throws Exception {
		statement.close();
	}

	@Test(timeout = 1000)
	public void testAllActs() throws ClassNotFoundException, SQLException {
		ArrayList<Activity> allActs = actList.AllActs();
		assertEquals("test AllActs fail",2,allActs.size());
	}

	@Test(timeout = 1000)
	public void testTopTenActs() throws ClassNotFoundException, SQLException {
		ArrayList<Activity> topTenActs = actList.TopTenActs();
		assertTrue("test topTenActs fail",topTenActs.size()<=10);
	}

	@Test(timeout = 1000)
	public void testSearchByFocus() throws ClassNotFoundException, SQLException {
		ArrayList<Activity> actsByFocus = actList.SearchByFocus(2);
		assertEquals("test search by focus fail",1,actsByFocus.size());
	}

	@Test(timeout = 1000)
	public void testAddAct() throws ClassNotFoundException, SQLException {
		actList.AddAct("testact", "test", null, null, null, null, 0, 100, 2);
		String sql = "SELECT * FROM ACT WHERE name = 'testact'";
		int resultCount = countOfQuery(sql);
		assertEquals("Add act uncorrectly", 1, resultCount);
	}

	@Test(timeout = 1000)
	public void testDelAct() throws SQLException, ClassNotFoundException {
		int delId=getMAXactID();
		actList.DelAct(delId);
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
