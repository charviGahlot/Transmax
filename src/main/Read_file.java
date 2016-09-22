package main;

import java.io.*;


public class Read_file {
	
	private String path;

	//constructor 
	public Read_file(String file_path){
		path=file_path;
	}

	//method to open a file
	public String[] openFile() throws IOException{
		int Number_of_lines=countLines();
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		//Create an array to store the lines of text
		String[] data = new String[Number_of_lines];	
		for(int i=0 ; i<Number_of_lines ; i++){
			data[i]= br.readLine();
		}
		br.close();
		return data;
	}

	//method to count the number of lines of text in a file
	private int countLines() throws IOException{
		int Number_of_lines=0;
		BufferedReader br = new BufferedReader(new FileReader(path));
		while(br.readLine() != null){
			Number_of_lines++;
		}
		br.close();
		return Number_of_lines;
	}
}
