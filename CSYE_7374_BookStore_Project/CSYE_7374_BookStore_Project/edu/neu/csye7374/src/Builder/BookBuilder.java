package neu.csye7374.src.Builder;

import neu.csye7374.src.Book;
import neu.csye7374.src.BookCategory;
import neu.csye7374.src.ConvertUtility;
import neu.csye7374.src.Factory_Pattern.*;

public class BookBuilder implements BuilderAPI<Book>{
	
	private int bookId;
	private String bookName;
	private double bookPrice;
	private BookCategory bookCategory; 
	private String bookAuthor;
	
	
	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BookBuilder(int bookId, String bookName, double bookPrice, BookCategory bookCategory,String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookCategory = bookCategory;
		this.bookAuthor=bookAuthor;
	}
	
	public BookBuilder(String s) {
		String[] tokens=s.split(",");
		this.bookId=ConvertUtility.StringToInt(tokens[0]);
		this.bookName=tokens[1];
		this.bookPrice=ConvertUtility.StringToDouble(tokens[2]);	
		this.bookCategory=BookCategory.getBookCategory(tokens[3]);
		this.bookAuthor=tokens[4];
	}


	@Override
	public Book build() {
		// TODO Auto-generated method stub
		return BookFactory.getInstance().getObject(this);
	}
}
