package test;

import org.junit.Test;


import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import junit.framework.TestCase;
import persistent.jdbc.JDBCTask;

/**
 * Test for the task
 * @author loicd_000
 *
 */
public class JDBCTask_Test extends TestCase {
	private JDBCTask task;
	
	public JDBCTask_Test(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		task = new JDBCTask();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	@Test
	public void testTask() throws ErrorConnectionException, AlertDriver {
		assertNotNull("Not yet implemented", this.task);
	}
	
	@Test
	public void testTitle() {
		task.setTitle("coucou");
		assertEquals("coucou", task.getTitle());
	}

}
