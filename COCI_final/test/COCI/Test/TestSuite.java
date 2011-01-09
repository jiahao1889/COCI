package COCI.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * JUnit suite test
 * 
 * @author COCI group
 * @since 2011-1-3
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { TestDBConnection.class, TestDBOperation.class,
		TestStudent.class, TestGroup.class, TestAdmin.class, TestUser.class,
		TestActivity.class, TestActList.class,

})
public class TestSuite {
}
