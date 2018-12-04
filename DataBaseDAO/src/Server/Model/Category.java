package Server.Model;

public class Category{
	
	private Integer idCategory;
	private String name;
	private String description;
	
	public Category( String idCategory, String name, String description ){
		this.idCategory = Integer.parseInt( idCategory );
		this.name = name;
		this.description = description;
	} // End constructor.

	public int getIdCategory() {
		return idCategory;
	} // End getter.
	
	public void setIdCategory( Integer idCategory ) {
		this.idCategory = idCategory;
	} // End setter.

	public String getName() {
		return name;
	} // End getter.

	public void setName( String name ) {
		this.name = name;
	} // End setter.

	public String getDescription() {
		return description;
	} // End getter.

	public void setDescription( String description ) {
		this.description = description;
	} // End setter.

} // End class.
