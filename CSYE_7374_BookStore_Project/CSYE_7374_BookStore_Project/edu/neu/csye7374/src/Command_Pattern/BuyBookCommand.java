package neu.csye7374.src.Command_Pattern;

import neu.csye7374.src.*;

public class BuyBookCommand implements CommandAPI{

	private static BuyBookCommand instance;  // Lazy Singleton Factory Class
	private Book book;
	
	
	private BuyBookCommand() {
		super();
	}
	
	public static synchronized BuyBookCommand getInstance() {
		if (instance == null) {
			instance = new BuyBookCommand();
		}
		return instance;
	}

	@Override
	public String execute() {
		return book.buyBook();
	}

	public Book getBook() {
		return book;
	}

	public BuyBookCommand setBook(Book book) {
		this.book = book;
		return this;
	}
}
