package neu.csye7374.src.Strategy_Pattern;

import neu.csye7374.src.Book;

public interface DiscountStrategyAPI {
	double discountPrice(Book book);
	String discountDescription(Book book);
}
