package edu.neu.csye7374;

public class FileFacade {
	
	private  FileIO myFile;
	
	
	
	public FileFacade(FileIO myFile) {
		this.myFile=myFile;
		
	}
	

	public FileFacade() {
		super();
	}


	public void save() {
		System.out.println("Saving File......"); 

		myFile.writeFile();
		myFile.saveFile();
		System.out.println();
	}
	
	
	public void load() {
		System.out.println("Loading File......"); 

		myFile.loadFile();
		myFile.readFile();
		System.out.println();

	}
	

}
