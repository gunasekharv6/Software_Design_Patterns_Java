package edu.neu.csye7374;

public class Driver {

	public static void main(String[] args) {
      FileFacade fileFacade = new FileFacade(new File());
      
      fileFacade.save();
      fileFacade.load();
		
	}

}
