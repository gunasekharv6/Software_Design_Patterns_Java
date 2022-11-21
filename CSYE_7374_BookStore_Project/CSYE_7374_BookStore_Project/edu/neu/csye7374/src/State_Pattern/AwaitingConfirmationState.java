package neu.csye7374.src.State_Pattern;

import neu.csye7374.src.ObserverPattern.Order;

public class AwaitingConfirmationState implements OrderStateAPI{
	
	private Order order;
	
	public AwaitingConfirmationState(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Error ... Already in Awaiting State");
	}

	@Override
	public void state_OrderConfirmed() {
		order.setState(order.getOrderConfirmed());
		System.out.println("SUCCESS!! Order moved to Confirmed State");		
	}

	@Override
	public void state_OrderDispatched() {
		System.out.println("Error ... Order not yet CONFIRMED");		
	}

	@Override
	public void state_OrderDelivered() {
		System.out.println("Error ... Order not yet CONFIRMED or DISPATCHED");
	}

}
