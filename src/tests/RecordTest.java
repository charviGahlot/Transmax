package tests;

import main.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class RecordTest {

	Record r; 
	
	@Before
	public void setUp() throws Exception {
		r = new Record();
		r.setValues("Smith", "Allan", 60);
	}


	@Test
	public void testGetLastName() {
		String lastName = r.getLastName();
		assertEquals(lastName, "Smith");
	}

	@Test
	public void testGetFirstName() {
		String firstName = r.getFirstName();
		assertEquals(firstName,"Allan");
	}

	@Test
	public void testGetScore() {
		int score = r.getScore();
		assertEquals(score, 60);
	}

	@Test
	public void testToString() {
		String result = r.toString();
		assertEquals(result, "Smith,Allan,60");
	}

}
