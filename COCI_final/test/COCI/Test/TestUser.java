package COCI.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.COCI.SqlString;
import com.COCI.User;

/**
 * JUnit test of User class
 * @author COCI group
 * @since 2011-1-2
 */
public class TestUser {

	private static User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new User("admin","admin");
	}

	@Test(timeout = 1000)
	public void testRegisterSuccess() throws ClassNotFoundException, SQLException {
		boolean registerResult = user.Register("testu", "testp", null, null);
		assertTrue("RegisterSuccess fail",registerResult);

	}
	
	@Test(timeout = 1000)
	public void testRegisterFail() throws ClassNotFoundException, SQLException {
		boolean registerResult = user.Register("admin", "admin", null, null);
		assertFalse("RegisterFail fail",registerResult);

	}

	@Test(timeout = 1000)
	public void testLoginSuccess() throws ClassNotFoundException, SQLException {
		int loginResult = user.Login();
		assertEquals("Login result", 3, loginResult);
	}
	
	@Test(timeout = 1000)
	public void testLoginWithErrorPassword() throws ClassNotFoundException, SQLException {
		User userWithErrorPassword = new User("admin","testp");
		int loginResult = userWithErrorPassword.Login();
		assertEquals("Login with error password result", 0, loginResult);
	}
	
	@Test(timeout = 1000)
	public void testLoginWithNotExistUser() throws ClassNotFoundException, SQLException {
		User userNotExist = new User("NotExist","testp");
		int loginResult = userNotExist.Login();
		assertEquals("Login with not exist user", 0, loginResult);
	}

	@Test(timeout = 1000)
	public void testGetID() throws ClassNotFoundException, SQLException {
		int u_id = user.getID();
		assertEquals("User ID", 1, u_id);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Connection connection = SqlString.connectSql();
		Statement statement = connection.createStatement();
		statement.executeUpdate("DELETE FROM USER WHERE username = 'testu'");
		statement.close();
		connection.close();
	}

}
