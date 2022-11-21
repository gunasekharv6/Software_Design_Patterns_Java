package neu.csye7374.src.Factory_Pattern;

import neu.csye7374.src.Book;
import neu.csye7374.src.Builder.BookBuilder;
import neu.csye7374.src.Builder.BuilderAPI;

public class BookFactory extends AbstractFactory<Book> {
	
	private static BookFactory instance=new BookFactory(); // Eager Singleton Factory Class
	
	private  BookFactory() {
		super();
	}
	
	public synchronized static BookFactory getInstance() {
		return instance;
	}

	@Override
	public Book getObject(BuilderAPI<Book> builder) {
		// TODO Auto-generated method stub
		BookBuilder bookBuilder=(BookBuilder)builder;
		return new Book(bookBuilder);
	}

}
