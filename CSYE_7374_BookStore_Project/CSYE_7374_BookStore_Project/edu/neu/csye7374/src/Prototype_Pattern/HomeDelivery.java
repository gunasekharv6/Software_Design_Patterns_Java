package neu.csye7374.src.Prototype_Pattern;

public class HomeDelivery extends DeliveryType {

	public HomeDelivery(int deliveryId,String deliveryType, double deliveryCost) {
		super(deliveryId,deliveryType,deliveryCost);
		// TODO Auto-generated constructor stub
	}

	@Override
	String delivertDescription() {
		// TODO Auto-generated method stub
		return "Your order will be delivered to home";
	}

}
