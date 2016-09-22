package tests;

import main.*;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;


public class Read_fileTest {
	Read_file file;
	String[] data;
	
	
	@Before
	public void setUp() throws Exception {
		file = new Read_file("D:/names.txt");
		data = null;
	}


	@Test
	public void testOpenFile() {
		try{
			data = file.openFile();
		}
		catch(IOException e){
			System.out.println(	e.getMessage());			
		}
		assertNotNull(data);
	}

}
