package neu.csye7374.src.Decorator_Pattern;

import neu.csye7374.src.*;

public abstract class BookDecorator implements BookAPI {
	
	protected BookAPI decoratedBook;
	
	public BookDecorator(BookAPI decoratedBook){
	      this.decoratedBook = decoratedBook;
	}
	 
	@Override
	public String bookDescription() {
		// TODO Auto-generated method stub
		return decoratedBook.bookDescription();
	}

	@Override
	public int noOfBooksPublished() {
		// TODO Auto-generated method stub
		return decoratedBook.noOfBooksPublished();
	}
	
	public BookAPI getDecoratedBook() {
		return this.decoratedBook;
	}

	@Override
	public String toString() {
		return "BookDecorator [bookDescription()=" + bookDescription() + ", noOfBooksPublished()="
				+ noOfBooksPublished() + ", getDecoratedBook()=" + getDecoratedBook() + "]";
	}
	
	

}
