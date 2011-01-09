package COCI.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.COCI.SqlString;

/**
 * JUnit test of DB connection
 * @author COCI group
 * @since 2011-1-1
 */
public class TestDBConnection {

	@Test(timeout = 1000)
	public void testConnectSql() throws SQLException {
		Connection connection = SqlString.connectSql();
		assertNotNull("DB connection fail",connection);	
		connection.close();
	}

}
