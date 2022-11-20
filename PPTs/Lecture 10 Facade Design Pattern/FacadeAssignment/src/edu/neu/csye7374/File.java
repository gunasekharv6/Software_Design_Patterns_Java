package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class File implements FileIO {
	
	private List<String> list = new ArrayList<>();
	
	public File() {
		
	}

	public void readFile() {
		System.out.println(list); 
	}

	public void writeFile() {
		System.out.println("Writing File"); 
		list.add("IO File");
		list.add("JSON File");
		list.add(".docx File");
	}

	public void saveFile() {
		System.out.println("Saving File"); 
		
	}

	public void loadFile() {
		System.out.println("Loading File"); 
		
	}
	
	

}
