package Server.Model;

public class Product{
	
	private Integer idProduct;
	private String name;
	private Double price;
	private Integer idCategory;
	
	public Product( String idProduct, String name, String price, String idCategory ){
		this.idProduct = Integer.parseInt( idProduct );
		this.name = name.toString();
		this.price = Double.parseDouble( price );
		this.idCategory = Integer.parseInt( idCategory );
	} // End constructor.
	
	public Product(){}

	public Integer getIdProduct() {
		return idProduct;
	} // End getter.

	public void setIdProduct( Integer idProduct ) {
		this.idProduct = idProduct;
	} // End setter.

	public String getName() {
		return name;
	} // End getter.

	public void setName( String name ) {
		this.name = name;
	} // End setter.

	public Double getPrice() {
		return price;
	} // End getter.

	public void setPrice( Double price ) {
		this.price = price;
	} // End setter.

	public Integer getIdCategory() {
		return idCategory;
	} // End getter.

	public void setIdCategort( Integer idCategory ) {
		this.idCategory = idCategory;
	} // End setter.
	
} // End class.
