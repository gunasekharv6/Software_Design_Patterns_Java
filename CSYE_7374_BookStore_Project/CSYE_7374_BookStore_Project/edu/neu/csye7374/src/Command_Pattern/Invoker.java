package neu.csye7374.src.Command_Pattern;
import java.util.*;

import neu.csye7374.src.Book;

public class Invoker {
	private List<Book> orderList = new ArrayList<>(); 

	public void takeOrder(Book order){
		orderList.add(order);		
	}

   public void placeOrders(){
	   BuyBookCommand buyBookCommand = BuyBookCommand.getInstance();
      for (Book order : orderList) {
    	  System.out.println(buyBookCommand.setBook(order)
         .execute());
      }
      orderList.clear();
   }
   
   public void placeOrders(List<Book> bookList){
	      for (Book b : bookList) {
	    	  orderList.add(b);
	      }
	      placeOrders();
   }
   
   
   public void rentOrders(){
	   RentBookCommand rentBookCommand = RentBookCommand.getInstance();
      for (Book order : orderList) {
    	  System.out.println(rentBookCommand.setBook(order)
         .execute());
      }
      orderList.clear();
   }
   
   public void rentOrders(List<Book> bookList){
	      for (Book b : bookList) {
	    	  orderList.add(b);
	      }
	      rentOrders();
   }
   
   
   
   

	public List<Book> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Book> orderList) {
		this.orderList = orderList;
	}
   
   
   
   
   
   
   
}


//public class CommandPatternDemo {
//	   public static void main(String[] args) {
//	      Stock abcStock = new Stock();
//
//	      BuyStock buyStockOrder = new BuyStock(abcStock);
//	      SellStock sellStockOrder = new SellStock(abcStock);
//
//	      Broker broker = new Broker();
//	      broker.takeOrder(buyStockOrder);
//	      broker.takeOrder(sellStockOrder);
//
//	      broker.placeOrders();
//	   }
//	}
