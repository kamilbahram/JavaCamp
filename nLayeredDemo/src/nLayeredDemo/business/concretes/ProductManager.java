package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductServices;
import nLayeredDemo.core.JLogerService;
import nLayeredDemo.dataAccess.absracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;
import nLayeredDemo.jLoger.JLogerManeger;

public class ProductManager implements ProductServices {
	
	private ProductDao productDao;
	private JLogerService logerService;

	public ProductManager(ProductDao productDao, JLogerService logerService) {
		super();
		this.productDao = productDao;
		this.logerService = logerService;
	}

	@Override
	public void add(Product product) {
		if (product.getCategoryId() == 1) {
		System.out.println(" Bu kategoryde ürün kabul edilmiyor. : ");
		//JLogerManeger.log(product.getName());  BU YAKLAŞİM SORULACAK (STATİK)
		return;
		}
		
		this.productDao.add(product);
		this.logerService.logToSystem("loglama gerçelleşti : " + product.getName());
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
