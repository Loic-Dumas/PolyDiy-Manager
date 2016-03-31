package test;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import persistent.jdbc.JDBCAccount;
import persistent.jdbc.JDBCTask;

/**
 * @author Faustine
 * JUnit Class to Test getters and setters of Account
 *
 */

public class JDBCAccount_Test extends TestCase {
	private JDBCAccount account;
	
	public JDBCAccount_Test(String name) {
		super(name);
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		account = new JDBCAccount();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		account = null;
	}

	//to test the setters and getters of account class
	@Test
	public void testJDBCAccount() {
		assertNotNull("Not yet implemented", this.account);
	}
	

	@Test
	public void testGetLogin() {
		account.setLogin("fofokilleuz");
		assertEquals("fofokilleuz", account.getLogin());
	}
		
	@Test
	public void testGetPassword() {
		account.setPassword("yolo");
		assertEquals("yolo", account.getPassword());
	}

	@Test
	public void testGetSetID() {
		account.setID(4);
		assertEquals(4, account.getID());
	}

	@Test
	public void testGetSetEmail() {
		account.setEmail("hotmail");
		assertEquals("hotmail", account.getEmail());
	}

	@Test
	public void testGetSetFirstName() {
		account.setFirstName("TESTES");
		assertEquals("TESTES", account.getFirstName());
	}

	@Test
	public void testGetSetLastName() {
		account.setLastName("Valentin");
		assertEquals("Valentin", account.getLastName());
	}

	@Test
	public void testGetSetAddressCity() {
		account.setCity("Béziers");
		assertEquals("Béziers", account.getAddressCity());
	}

	@Test
	public void testGetSetAddressRoad() {
		account.setRoad("6 rue des lilas");
		assertEquals("6 rue des lilas", account.getAddressRoad());
	}

	@Test
	public void testGetSetAddressPostal() {
		account.setPostalCode("34500");
		assertEquals("34500", account.getAddressPostal());
	}

}
