package COCI.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.COCI.Activity;
import com.COCI.SqlString;
import com.COCI.Student;

/**
 * JUnit test of Activity class
 * 
 * @author COCI group
 * @since 2011-1-2
 */
public class TestActivity {

	private static Activity activity;
	private static Connection connection;
	private Statement statement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		activity = new Activity();
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
	public void testActivityInt() throws ClassNotFoundException, SQLException {
		Activity activityForTest = new Activity(1);
		assertEquals("Create Activity By ID fail", "Act1", activityForTest
				.getTitle());
	}

}
