package neu.csye7374.src.Adapter_Pattern;

import neu.csye7374.src.BookAPI;

public class AuthorObjectAdapter implements BookAPI{
	
	private Author author;
	private BookAPI book;
	
	public AuthorObjectAdapter(BookAPI book, Author adaptee) {
		this.book = book;
		this.author=adaptee;
	}

	@Override
	public String bookDescription() {
		// TODO Auto-generated method stub
		return book.bookDescription();
	}

	@Override
	public int noOfBooksPublished() {
		// TODO Auto-generated method stub
		return author.getNoOfBooksPublished();
	}

	@Override
	public Object getBookAuthor() {
		// TODO Auto-generated method stub
		return Author.class.cast(author);
	}

	@Override
	public String toString() {
		return "[" + author + "], [book=" + book + "]";
	}

	@Override
	public double getBookPrice() {
		// TODO Auto-generated method stub
		return book.getBookPrice();
	}
	
	
}
