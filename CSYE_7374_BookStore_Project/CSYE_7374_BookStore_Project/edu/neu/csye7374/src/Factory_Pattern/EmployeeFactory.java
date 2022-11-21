package neu.csye7374.src.Factory_Pattern;

import neu.csye7374.src.Employee;
import neu.csye7374.src.Builder.*;

public class EmployeeFactory extends AbstractFactory<Employee> {
	
	private static EmployeeFactory instance;  // Lazy Singleton Factory Class
	
	private  EmployeeFactory() {
		super();
		instance=null;
	}
	
	public static synchronized EmployeeFactory getInstance() {
		if (instance == null) {
			instance = new EmployeeFactory();
		}
		return instance;
	}

	@Override
	public Employee getObject(BuilderAPI<Employee> builder) {
		// TODO Auto-generated method stub
		EmployeeBuilder employeeBuilder=(EmployeeBuilder)builder;
		return new Employee(employeeBuilder);
	}

}
