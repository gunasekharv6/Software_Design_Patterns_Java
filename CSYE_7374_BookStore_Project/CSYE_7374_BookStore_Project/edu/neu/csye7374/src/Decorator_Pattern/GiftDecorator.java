package neu.csye7374.src.Decorator_Pattern;

import neu.csye7374.src.*;

public class GiftDecorator extends BookDecorator {

	public GiftDecorator(BookAPI decoratedBook) {
		super(decoratedBook);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String bookDescription() {
		// TODO Auto-generated method stub
		return decoratedBook.bookDescription()+ "..Wrapped for gift along with a pen";
	}

	@Override
	public Object getBookAuthor() {
		// TODO Auto-generated method stub
		return decoratedBook.getBookAuthor();
	}
	
	public double getBookPrice() {
		Book b = Book.class.cast(decoratedBook);
		return b.getBookPrice()+10;
	}
	
}
