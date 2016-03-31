package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import junit.framework.TestCase;
import persistent.jdbc.JDBCProduct;

public class JDBCProduct_Test extends TestCase {
	private JDBCProduct product;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJDBCProductCompleteConstructor() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertNotNull("Not yet implemented", this.product);
	}

	@Test
	public void testJDBCProductConstructor() throws ErrorConnectionException, AlertDriver {
		product = new JDBCProduct(1);
		assertNotNull("Not yet implemented", this.product);
	}

	@Test
	public void testGetIDProduct() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals(15, product.getIDProduct());
	}

	@Test
	public void testSetIDProduct() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setIDProduct(12);
		assertEquals(12, product.getIDProduct());
	}

	@Test
	public void testGetName() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals("Lama", product.getName());
	}

	@Test
	public void testSetName() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setName("lama2");
		assertEquals("lama2", product.getName());
	}

	@Test
	public void testGetDescription() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals("description", product.getDescription());
	}

	@Test
	public void testSetDescription() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setDescription("lama2");
		assertEquals("lama2", product.getDescription());
	}

	@Test
	public void testGetUnitPrice() {
		product = new JDBCProduct(15, "Lama", "description", (float) 1.2, 15, 15, 15, "peluche");
		assertEquals((float) 1.2, product.getUnitPrice());
	}

	@Test
	public void testSetUnitPrice() {
		product = new JDBCProduct(15, "Lama", "description", (float) 1.2, 15, 15, 15, "peluche");
		product.setUnitPrice((float) 15.2);
		assertEquals((float) 15.2, product.getUnitPrice());
	}

	@Test
	public void testGetStockQuantity() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals(15, product.getStockQuantity());
	}

	@Test
	public void testSetStockQuantity() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setStockQuantity(1);
		assertEquals(1, product.getStockQuantity());
	}

	@Test
	public void testGetIDSeller() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals(15, product.getIDSeller());
	}

	@Test
	public void testSetIDSeller() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setIDSeller(26);
		assertEquals(26, product.getIDSeller());
	}

	@Test
	public void testGetIDCategory() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals(15, product.getIDCategory());
	}

	@Test
	public void testSetIDCategory() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setIDCategory(26);
		assertEquals(26, product.getIDCategory());
	}

	@Test
	public void testGetCategoryName() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		assertEquals("peluche", product.getCategoryName());
	}

	@Test
	public void testSetCategoryName() {
		product = new JDBCProduct(15, "Lama", "description", (float) 15.2, 15, 15, 15, "peluche");
		product.setCategoryName("lama2");
		assertEquals("lama2", product.getCategoryName());
	}

}
