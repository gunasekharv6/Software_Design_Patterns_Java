package neu.csye7374.src.State_Pattern;

import neu.csye7374.src.BookStore;

public class OpenState implements BookStoreStateAPI {
	
	private static BookStore bookStore;
	
	public  OpenState(BookStore store) {
		super();
		OpenState.bookStore=store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		bookStore.setState(bookStore.getCloseState());
		System.out.println("Currently in Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		bookStore.setState(bookStore.getStockState());
		System.out.println("Currently in Stock State");
		
	}

}
