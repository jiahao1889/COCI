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
import com.COCI.Student;
/**
 * JUnit test of Student class
 * @author COCI group
 * @since 2011-1-2
 */
public class TestStudent {
	private static Student student;
	private static Connection connection;
	private Statement statement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		student = new Student("student","student");
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
	public void testJudgeFocusSuccess() throws ClassNotFoundException, SQLException {
		String judgeFocusResult=student.judgeFocus(1, 2);
		assertEquals("Judge Concern fail","delete the concern",judgeFocusResult);
	}
	
	@Test(timeout = 1000)
	public void testJudgeFocusFail() throws ClassNotFoundException, SQLException {
		String judgeFocusResult=student.judgeFocus(2, 2);
		assertEquals("Judge unConcern fail","concern about it",judgeFocusResult);
	}

	@Test(timeout = 1000)
	public void testFocusConcern() throws ClassNotFoundException, SQLException {
		student.Focus(2, 2, "concern about it");
		ResultSet resultSet=statement.executeQuery("SELECT * FROM care WHERE u_id=2 AND a_id=2");
		assertTrue("Focus Concern fail",resultSet.next());
		resultSet.close();
		statement.executeUpdate("DELETE FROM care WHERE u_id=2 AND a_id=2");
	}

	@Test(timeout = 1000)
	public void testFocusUnConcern() throws ClassNotFoundException, SQLException{
		student.Focus(2, 1, "delete the concern");
		ResultSet resultSet=statement.executeQuery("SELECT * FROM care WHERE u_id=2 AND a_id=1");
		assertFalse("Focus unConcern fail",resultSet.next());
		resultSet.close();
		statement.executeUpdate("INSERT INTO care(u_id,a_id) VALUES(2,1)");
	}
	
	
	 
}
