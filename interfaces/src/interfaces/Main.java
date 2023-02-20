package interfaces;

public class Main {

	public static void main(String[] args) {
		Logger [] loggers = {new DatabaseLogger(),new EmailLogger(), new SmsLogger()};
		CustomerManager customerManager = new CustomerManager(loggers);
		
		Customer customer = new Customer(0, "kamil", "bahram");
		
		customerManager.add(customer);
		customerManager.delete(customer);
		

	}

}
