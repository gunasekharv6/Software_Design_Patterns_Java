package neu.csye7374.src.Strategy_Pattern;

import neu.csye7374.src.Book;

public class FacultyDiscount implements DiscountStrategyAPI {
	
	@Override
	public double discountPrice(Book book) {
		// TODO Auto-generated method stub
		double discountedPrice=book.getBookPrice() - book.getBookPrice()*0.20;
		return discountedPrice;	
	}

	@Override
	public String discountDescription(Book book) {
		// TODO Auto-generated method stub
		return "Faculty Discount Applied : 20% OFF";
	}

}
