package DAO;

import java.util.ArrayList;
import java.util.List;
import Domain.Product;

public interface ProductDao {
	
	public List<Product> findAll();
	public Product findByProductNummer(int productNummer);
	public Product save(Product product);
	public Product update(Product reiziger);
	public boolean delete(Product reiziger);
	public void closeConnection();
	public ArrayList<Product> findProductByOvkaart(int ovkaart);
}
