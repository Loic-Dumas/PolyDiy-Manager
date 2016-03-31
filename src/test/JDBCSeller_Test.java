package test;
/**
 * test of method of JDBCSeller
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import persistent.jdbc.JDBCSeller;

public class JDBCSeller_Test extends TestCase {
	private JDBCSeller seller;

	
	public void setUp() throws Exception {
			super.setUp();
			seller = new JDBCSeller();
	}
	
	

	public void tearDown() throws Exception {
		super.tearDown();
		seller = null;
		
	}
	
	@Test
	public void testSeller() {
		assertNotNull("Not yet implemented", this.seller);
	}
	@Test
	public void testnameShop(){
		seller.setNameShop("coucou");
		assertEquals("coucou", seller.getNameShop());
		
	}
	@Test
	public void testdescription(){
		seller.setDescription("seller");
		assertEquals("seller", seller.getDescription());
		
	}
	@Test
	public void testSiret(){
		seller.setSiret("ammm11");
		assertNotEquals("nass", seller.getSiret());
		
	}
	
	
}
