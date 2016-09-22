package main;

import java.io.*;

public class Grade_scores {

	public static void main(String[] args) {
		//Take the file name passed as a parameter into a String
		String file_name = args[0];
		
		Grade_scores gs = new Grade_scores();
		Read_file ob= new Read_file(file_name);
		int i;
		
		try{
			//open the file and get the data
			String[] data = ob.openFile();	
			Record[] records = new Record[data.length];
			
			//put the data into records
			String[] temp;
			for(i=0 ; i<data.length ; i++){
				temp = data[i].split(",");
				records[i]=new Record();
				records[i].setValues(temp[0],temp[1],Integer.valueOf(temp[2]));	
			}
			
			//order the records by score 
			records= gs.sort_by_score(records);
			//For records with same scores, order by last name followed by first name
			records= gs.sort_by_name(records);		
			
			//Get data back from sorted records
			for(i=0 ; i<records.length ; i++){  
				data[i] = records[i].toString();
			}
			 
			//Display sorted data to console
			for(i=0 ; i<data.length ; i++){	
				System.out.println(data[i]);
			}
			 
			//Create a text file with the list of sorted data
			String result = gs.WriteToFile(file_name,data);
			System.out.println(result);
			
		}
		catch(IOException e){
			System.out.println(	e.getMessage());			
		}
	}
	
	
	//method to sort the records by score
	public Record[] sort_by_score(Record[] records){
		int i,j;
		Record recordToSort = new Record();	
		for (i = 1 ; i < records.length ; i++) {						
			recordToSort = records[i];					
			j = i;
			while (j > 0 && (records[j - 1].getScore() < recordToSort.getScore())) {
				records[j] = records[j - 1];
				j--;
			}
			records[j] = recordToSort;
		}
		return records;
	}
	 
	
	//method to sort the records by name
	public Record[] sort_by_name(Record[] records){
		int i,j;
		String a,b,c,d;
		Record recordToSort = new Record();	
		for (i = 1 ; i < records.length ; i++) {		
			recordToSort = records[i];					
			j = i;
			a = records[j - 1].getLastName();
			b = recordToSort.getLastName();	
			outerloop:
			while (j > 0 && (records[j - 1].getScore() == recordToSort.getScore())  
				&& (a.compareTo(b) >= 0)){  
				
					if(a.compareTo(b) > 0){ 
						//sort by last name		
						records[j] = records[j - 1];
						if((--j) == 0)
							break outerloop;
						a= records[j - 1].getLastName();
						}
					
					else{
						//a.compareTo(b) is 0
						//Both records have same last name
						//So, sort by first name						
						c= records[j - 1].getFirstName();
						d= recordToSort.getFirstName();
						if(c.compareTo(d) <= 0)
						{
							//already sorted, so don't do anything
							break outerloop;
						}
						while (j > 0 && (c.compareTo(d) > 0) && (a.compareTo(b) == 0)){						   					    
							records[j] = records[j - 1];
							if((--j) == 0)
								break outerloop;
							c= records[j - 1].getFirstName();
							a= records[j - 1].getLastName();
							}
					}
			}
		 	records[j] = recordToSort;		
		}
		return records;
	}
	
	
	//method to create a text file with the list of sorted data
	public String WriteToFile(String file_name,String[] data){
		
		String result=null;
		int i;
		
		//output file name should be <input-file-name>-graded.txt
		String [] parts = file_name.split("/");	
		int n = parts.length-1;
	 	String output_file_name = parts[n].replaceAll(".txt", "-graded.txt");
	 	
		//output file path should be the same as input file path
		StringBuilder strBuilder = new StringBuilder();
		for (i = 0 ; i < n ; i++) {
		   strBuilder.append(parts[i]+"/"); 
		}
		String output_file_path = strBuilder.toString();
		output_file_path = output_file_path.concat(output_file_name);
		
		try{
			File file = new File(output_file_path);
		
			// if file does not exist, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
		
			//write data to file
			for(i=0 ; i<data.length ; i++){	
	 			bw.write(data[i]);
				bw.newLine();
			}
		
			bw.close();
			result = "Finished: created "+ output_file_name;
		
		}
		catch(IOException o){
			System.out.println(	o.getMessage());			
		}
		return result;
	}
}
