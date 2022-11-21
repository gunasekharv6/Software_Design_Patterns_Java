package neu.csye7374.src;

import java.util.*;

import neu.csye7374.src.Adapter_Pattern.Author;

import neu.csye7374.src.Adapter_Pattern.AuthorObjectAdapter;
import neu.csye7374.src.Builder.BookBuilder;
import neu.csye7374.src.Builder.EmployeeBuilder;
import neu.csye7374.src.Command_Pattern.CommandAPI;
import neu.csye7374.src.Command_Pattern.Invoker;
import neu.csye7374.src.Facade.DeliveryType;
import neu.csye7374.src.Facade.OrderFacade;
import neu.csye7374.src.Factory_Pattern.BookFactory;
import neu.csye7374.src.Factory_Pattern.EmployeeFactory;
import neu.csye7374.src.ObserverPattern.Order;
import neu.csye7374.src.Strategy_Pattern.DiscountStrategy;

public class Driver {
	public static void main(String[] args) {
		BookStore.demo();
	}
}