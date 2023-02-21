package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductServices;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLogerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductServices productServices = new ProductManager(new AbcProductDao(),new JLogerManagerAdapter());
		
		Product product = new Product(1, 13, "kamil", 23, 61);
		productServices.add(product);
	}
	
}
