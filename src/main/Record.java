package main;

public class Record {

	private String lastName;
	private String firstName;
	private int score;
	
	
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getScore() {
		return score;
	} 
	
	//set values of data members
	public void setValues(String lastName, String firstName, int score){
		this.lastName=lastName;
		this.firstName=firstName;
		this.score=score;
	}
 	
	//convert a Record into a String
	public String toString()
	{  
		// Format of String is "LastName,FirstName,Score"
		return lastName.concat(",").concat(firstName).concat(",").concat(Integer.toString(score));		
	}

}
