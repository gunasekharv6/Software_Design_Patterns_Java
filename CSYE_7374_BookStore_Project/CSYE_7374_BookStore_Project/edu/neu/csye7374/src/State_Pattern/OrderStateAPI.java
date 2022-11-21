package neu.csye7374.src.State_Pattern;

public interface OrderStateAPI {
	void state_Awaiting_OrderConfirmation();
	void state_OrderConfirmed();
	void state_OrderDispatched();
	void state_OrderDelivered();
}
