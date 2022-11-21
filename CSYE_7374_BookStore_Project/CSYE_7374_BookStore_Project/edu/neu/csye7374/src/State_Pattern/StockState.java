package neu.csye7374.src.State_Pattern;

import neu.csye7374.src.BookStore;

public class StockState implements BookStoreStateAPI  {
	
	private static BookStore bookStore;
	
	public  StockState(BookStore store) {
		super();
		StockState.bookStore=store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		bookStore.setState(bookStore.getOpenState());
		System.out.println("Transition from Stock State to Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		bookStore.setState(bookStore.getCloseState());
		System.out.println("Transition from Stock State to Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Stock State");
		
	}
}
