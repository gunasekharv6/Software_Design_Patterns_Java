package neu.csye7374.src.Strategy_Pattern;

import neu.csye7374.src.Book;

public class StudentDiscount implements DiscountStrategyAPI {

	@Override
	public double discountPrice(Book book) {
		// TODO Auto-generated method stub
		double discountedPrice=book.getBookPrice() - book.getBookPrice()*0.25;
		return discountedPrice;				
	}

	@Override
	public String discountDescription(Book book) {
		// TODO Auto-generated method stub
		return "Student Discount Applied : 25% OFF";
	}

}
