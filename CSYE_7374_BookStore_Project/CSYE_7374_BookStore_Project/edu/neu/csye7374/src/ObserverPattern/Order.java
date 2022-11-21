package neu.csye7374.src.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

import neu.csye7374.src.Book;
import neu.csye7374.src.BookAPI;
import neu.csye7374.src.Facade.DeliveryType;
import neu.csye7374.src.State_Pattern.*;

public class Order implements OrderStateAPI{
	 
	private int id;
	
	private double orderCost=0;
	
	private int count=0;
	
	private double discount=0;
	
	private double shippingCost;
	private List<BookAPI> bookList = new ArrayList<>();
	private DeliveryType deliveryType;
	private static int counter=0;
	private List<OrderObserver> observers = new ArrayList<>();
	{
		observers.add(new PriceObserver());
		observers.add(new QuantityObserver());
	}
	
	private OrderStateAPI awaitingConfirmationState = new AwaitingConfirmationState(this);
	private OrderStateAPI orderConfirmed = new OrderConfirmed(this);
	private OrderStateAPI orderDispatched = new OrderDispatched(this);
	private OrderStateAPI orderDelivered = new OrderDelivered(this);
	private OrderStateAPI state;
	
	
	
	public Order() {
		super();
		this.id = ++counter;
		this.deliveryType = DeliveryType.Pickup;
		this.state = getAwaitingConfirmationState();
	}


	public Order(double orderCost, int count, double shippingCost, DeliveryType deliveryType) {
		super();
		this.id = ++counter;
		this.orderCost = orderCost;
		this.count = count;		
		this.deliveryType = deliveryType;
		
		if(deliveryType==DeliveryType.Pickup) {
			this.shippingCost = 0;
		}else {
			this.shippingCost = shippingCost;
		}
		this.state = getAwaitingConfirmationState();
	}
	
	
	public void addBook(BookAPI book) {
		bookList.add(book);
		orderCost+=book.getBookPrice();
		count++;
		observers.forEach(o->o.updated(this));
	}
	
	public boolean removeBook(BookAPI book) {
		if(bookList.remove(book)) {
			return true;
		}
		return false;
	}
	
	
	

	public OrderStateAPI getAwaitingConfirmationState() {
		return awaitingConfirmationState;
	}


	public void setAwaitingConfirmationState(OrderStateAPI awaitingConfirmationState) {
		awaitingConfirmationState = awaitingConfirmationState;
	}


	public OrderStateAPI getOrderConfirmed() {
		return orderConfirmed;
	}


	public void setOrderConfirmed(OrderStateAPI orderConfirmed) {
		orderConfirmed = orderConfirmed;
	}


	public OrderStateAPI getOrderDelivered() {
		return orderDelivered;
	}


	public void setOrderDelivered(OrderStateAPI orderDelivered) {
		orderDelivered = orderDelivered;
	}


	public OrderStateAPI getOrderDispatched() {
		return orderDispatched;
	}


	public void setOrderDispatched(OrderStateAPI orderDispatched) {
		orderDispatched = orderDispatched;
	}


	public OrderStateAPI getState() {
		return state;
	}


	public void setState(OrderStateAPI state) {
		this.state = state;
	}


	public List<BookAPI> getBookList() {
		return bookList;
	}


	public void setBookList(List<BookAPI> bookList) {
		this.bookList = bookList;
	}
	
	
	public String getBookListString() {
		StringBuilder sb = new StringBuilder();
		for(BookAPI b : bookList) {
			sb.append(b);
			sb.append("; ");
		}
		return sb.toString();
	}


	public DeliveryType getDeliveryType() {
		return deliveryType;
	}


	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}


	public static int getCounter() {
		return counter;
	}


	public static void setCounter(int counter) {
		Order.counter = counter;
	}


	public List<OrderObserver> getObservers() {
		return observers;
	}


	public void setObservers(List<OrderObserver> observers) {
		this.observers = observers;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public double getOrderCost() {
		return orderCost;
	}

	public void attach(OrderObserver observer) {
		observers.add(observer);
	}
	
	public void detach(OrderObserver observer) {
		observers.remove(observer);
	}
	
	public Order(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 

	public double getTotal() {
		return orderCost - discount + shippingCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	
//	public void addItem(double price) {
//		orderCost+=price;
//		count++;
//		observers.forEach(o->o.updated(this));
//	}
	
	public int getCount() {
		return bookList.size();
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", itemCost=" + orderCost + ", count=" + count + ", discount=" + discount
				+ ", shippingCost=" + shippingCost+ "]";
	}


	@Override
	public void state_Awaiting_OrderConfirmation() {
		this.state.state_Awaiting_OrderConfirmation();		
	}


	@Override
	public void state_OrderConfirmed() {
		this.state.state_OrderConfirmed();		
	}


	@Override
	public void state_OrderDispatched() {
		this.state.state_OrderDispatched();
	}


	@Override
	public void state_OrderDelivered() {
		this.state.state_OrderDelivered();
	}	
}
