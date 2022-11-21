package neu.csye7374.src.Facade;

import neu.csye7374.src.BookAPI;
import neu.csye7374.src.Decorator_Pattern.BookDecorator;
import neu.csye7374.src.Decorator_Pattern.GiftDecorator;
import neu.csye7374.src.ObserverPattern.Order;

public class OrderFacade {
	private BookAPI book;

	public OrderFacade() {
		super();
	}
	
	public OrderFacade(BookAPI book) {
		super();
		this.book = book;
	}
	
	public Order order() {
		Order order = new Order();
		BookDecorator giftdecBook = new GiftDecorator(book);
		System.out.println(giftdecBook);
		order.addBook(giftdecBook);
		return order;
	}
	
	public OrderFacade setBook(BookAPI book) {
		this.book = book;
		return this;
	}	
}
