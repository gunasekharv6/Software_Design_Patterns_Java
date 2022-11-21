package neu.csye7374.src.State_Pattern;

import neu.csye7374.src.BookStore;

public class CloseState implements BookStoreStateAPI {
	
	private static BookStore bookStore;
	
	public  CloseState(BookStore store) {
		super();
		CloseState.bookStore=store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		bookStore.setState(bookStore.getOpenState());
		System.out.println("Transition from Close State to Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		bookStore.setState(bookStore.getStockState());
		System.out.println("Transition from Close State to Stock State");
		
	}

}
