package neu.csye7374.src.Command_Pattern;

import neu.csye7374.src.Book;

public class RentBookCommand implements CommandAPI {

	private static RentBookCommand instance;  // Lazy Singleton Factory Class
	private Book book;
	
	
	private RentBookCommand() {
		super();
	}
	
	public static synchronized RentBookCommand getInstance() {
		if (instance == null) {
			instance = new RentBookCommand();
		}
		return instance;
	}

	@Override
	public String execute() {
		return book.rentBook();
	}

	public Book getBook() {
		return book;
	}

	public RentBookCommand setBook(Book book) {
		this.book = book;
		return this;
	}
	
}
