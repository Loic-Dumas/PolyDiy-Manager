package test;

import org.junit.Test;

import junit.framework.TestCase;
import persistent.jdbc.JDBCTask;

public class JDBCTask_Test extends TestCase {
	private JDBCTask task;
	
	protected void setUp() throws Exception {
		super.setUp();
		task = new JDBCTask();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		task = null;
	}

	@Test
	public void testTask(){
		assertNotNull("Not yet implemented", this.task);
	}
	
	@Test
	public void testTitle() {
		task.setTitle("coucou");
		assertEquals("coucou", task.getTitle());
	}

}
