package Server.DataAccessObject;

import Server.Model.Category;
import java.util.List;

public interface CategoryDao{
	
	void createCategory( Category c );
	
	void updateCategory( Category c );
	
	void deleteCategory( Integer idCategory );
	
	Category findByIdCategory( Integer idCategory );
	
	List<Category> findAllCategories();
	
} // End interface.
