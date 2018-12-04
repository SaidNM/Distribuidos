package Server.DataAccessObject;

import Server.Model.Product;
import java.util.List;

public interface ProductDao{
	
	void createProduct( Product p );
	
	void updateProduct( Product p );
	
	void deleteProduct( Integer idProduct );
	
	Product findByIdProduct( Integer idProduct );
	
	List<Product> findProductByCategory( Integer idCategory );
	
	List<Product> findAllProducts();

} // End interface
