package interfaces;

public class CustomerManager {
	
	private Logger[] loggers;	

	public CustomerManager(Logger[] loggers) {
	
		this.loggers = loggers;
	}
	public void add(Customer costomer) {
		System.out.println("Müşteri eklendi : " + costomer.getFirstName());
		Util.runLogers(loggers, costomer.getFirstName());
	}
	public void delete (Customer costomer) {
		System.out.println("Müşteri silindi : " + costomer.getFirstName());
		Util.runLogers(loggers, costomer.getFirstName());
	}

}
