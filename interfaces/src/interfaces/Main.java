package interfaces;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Logger [] loggers = {new DatabaseLogger(),new EmailLogger(), new SmsLogger()};
		CustomerManager customerManager = new CustomerManager(loggers);
		
		Customer customer = new Customer(0, "kamil", "bahram");
		
		customerManager.add(customer);
		customerManager.delete(customer);
		
		// veriler hafızada nasıl kaydedilir çalışması.
		String a= "kamil";
		String b = "ahmet";
		System.out.println();
		int [] list = {1,2,3};
		System.out.println(list[0]);
		String []  ac= {"sdc"};
		String []  ab= {"as"};
		ac=ab;
		a=b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(ac[0]);
		System.out.println(ab[0]);

	}

}
