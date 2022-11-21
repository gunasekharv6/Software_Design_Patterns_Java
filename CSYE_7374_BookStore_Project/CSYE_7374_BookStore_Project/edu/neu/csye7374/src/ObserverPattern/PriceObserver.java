package neu.csye7374.src.ObserverPattern;

public class PriceObserver implements OrderObserver {

	@Override
	public void updated(Order order) {
		double total = order.getOrderCost();
		if(total>=500) {
			order.setDiscount(20);
		}else if(total>=200) {
			order.setDiscount(10);
		}
		
	}

}
