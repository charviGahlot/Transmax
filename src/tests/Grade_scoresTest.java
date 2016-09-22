package tests; 

import main.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class Grade_scoresTest {
	Grade_scores grade = new Grade_scores();
	Record[] test_records = new Record[4];
	
	@Before
	public void setUp() throws Exception {
		test_records[0]=new Record();
		test_records[1]=new Record();
		test_records[2]=new Record();
		test_records[3]=new Record();
		test_records[0].setValues("King","Madison",88);
		test_records[1].setValues("Smith","Allan",70);
		test_records[2].setValues("Bundy","Teressa",88);			
		test_records[3].setValues("Smith","Francis",85);					
	}


	@Test
	public void testWriteToFile() {
		String[] data= {"Line1","Line2","Line3"};
		String result = grade.WriteToFile("D:/names.txt", data);
		assertNotNull(result);
	}

	
	@Test
	public void testSort_by_score() {
		assertNotNull(test_records);
		Record[] result = grade.sort_by_score(test_records);
		test_records[0].setValues("King","Madison",88);
		test_records[1].setValues("Bundy","Teressa",88);
		test_records[2].setValues("Smith","Francis",85);
		test_records[3].setValues("Smith","Allan",70);						
		assertEquals(result, test_records);
	}

	@Test
	public void testSort_by_name() {
		testSort_by_score();
		Record[] result = grade.sort_by_name(test_records);
		test_records[0].setValues("Bundy","Teressa",88);
		test_records[1].setValues("King","Madison",88);	
		test_records[2].setValues("Smith","Francis",85);
		test_records[3].setValues("Smith","Allan",70);						
		assertEquals(result, test_records);
	}

}
