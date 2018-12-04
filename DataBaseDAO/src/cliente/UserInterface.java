package cliente;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;

public class UserInterface extends JFrame implements ActionListener {
	
	public static ArrayList<String[]> al = new ArrayList<String[]>();
	public static final long serialVersionUID = 1L;
	public JComboBox<String> comboOperationCategory;
	public JComboBox<String> comboOperationProduct;
	public JComboBox<String> comboMethod;
	public JTextField idCategoryProductTextField;
	public JTextField nameCategoryTextField;
	public JTextField nameProductTextField;
	public JTextField descriptionTextField;
	public JTextField idCategoryTextField;
	public static JTextField idProductTextField;
	public JTextField priceTextField;
	public JLabel idCategoryProductLabel;
	public JLabel nameCategoryLabel;
	public JLabel nameProductLabel;
	public JLabel descriptionLabel;
	public JLabel idCategoryLabel;
	public JLabel idProductLabel;
	public JLabel priceLabel;
	public JScrollPane sp;
	public JTable t;
	public JButton b;
	public String query;
	public String auxQuery;
	public boolean flag;
	
	public UserInterface(){} // End constructor
	
	public void init(){
		initializeComponents();
		this.getContentPane().setBackground( Color.WHITE );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setResizable( false );
		setTitle( "Data Base Server II" );
		setSize( 900, 600 );
		setLayout( null );
		launchFrame();
	} // End method.
	
	public void initializeComponents(){
		// Combo box.
		String[] soProduct = { "Nuevo Producto", "Producto por categoria", "Producto por ID", "Todos los productos", "Actualizar producto", "Borrar Producto" };
		String[] soCategory = { "Crear categoria", "Categoria por ID", "Todas las categorias", "Actualizar categoria", "Borrar categoria" };
		String[] sm = { "PRODUCTO", "CATEGORIA" };
		comboOperationCategory = new JComboBox<String>( soCategory );
		comboOperationProduct = new JComboBox<String>( soProduct );
		comboMethod = new JComboBox<String>( sm );
		// Labels.
		idCategoryProductLabel = new JLabel( "Categoria del producto:" );
		nameCategoryLabel = new JLabel( "Nombre:" );
		nameProductLabel = new JLabel( "Nombre:" );
		descriptionLabel = new JLabel( "Descripcion:" );
		idCategoryLabel = new JLabel( "ID:" );
		idProductLabel = new JLabel( "ID:" );
		priceLabel = new JLabel( "Precio:" );
		// JTextFields.
		idCategoryProductTextField = new JTextField();
		nameCategoryTextField = new JTextField();
		nameProductTextField = new JTextField();
		descriptionTextField = new JTextField();
		idCategoryTextField = new JTextField();
		idProductTextField = new JTextField();
		priceTextField = new JTextField();
		// ScrollPanel and JTable.
		t = new JTable();
		sp = new JScrollPane( t );
		// Button.
		b = new JButton( "Enviar" );
		// Others.
		auxQuery = "";
		query = "";
	} // End method.
	
	public void launchFrame(){
		// Set sizes.
		comboOperationCategory.setBounds( 240, 20, 200, 20 );
		comboOperationProduct.setBounds( 460, 20, 200, 20 );
		comboMethod.setBounds( 20, 20, 200, 20 );
		idProductLabel.setBounds( 20, 60, 200, 20 );
		nameProductLabel.setBounds( 240, 60, 200, 20 );
		priceLabel.setBounds( 460, 60, 200, 20 );
		idCategoryProductLabel.setBounds( 680, 60, 200, 20 );
		idProductTextField.setBounds( 20, 100, 200, 20 );
		nameProductTextField.setBounds( 240, 100, 200, 20 );
		priceTextField.setBounds( 460, 100, 200, 20 );
		idCategoryProductTextField.setBounds( 680, 100, 200, 20 );
		
		idCategoryLabel.setBounds( 20, 140, 200, 20 );
		nameCategoryLabel.setBounds( 240, 140, 200, 20 );
		descriptionLabel.setBounds( 460, 140, 200, 20 );
		idCategoryTextField.setBounds( 20, 180, 200, 20 );
		nameCategoryTextField.setBounds( 240, 180, 200, 20 );
		descriptionTextField.setBounds( 460, 180, 200, 20 );
		b.setBounds( 680, 180, 200, 20 );
		sp.setBounds( 20, 220, 860, 340 );
		
		comboOperationCategory.setEnabled( false );
		comboOperationProduct.setEnabled( false );
		disableCategoryFields();
		disableProductFields();
		
		// Add to frame.
		add( comboOperationCategory );
		add( comboOperationProduct );
		add( comboMethod );
		add( idCategoryProductTextField );
		add( nameCategoryTextField );
		add( nameProductTextField );
		add( descriptionTextField );
		add( idCategoryTextField );
		add( idProductTextField );
		add( priceTextField );
		add( idCategoryProductLabel );
		add( nameCategoryLabel );
		add( nameProductLabel );
		add( descriptionLabel );
		add( idCategoryLabel );
		add( idProductLabel );
		add( priceLabel );
		add( sp );
		add( b );

		setVisible( true );
		
		comboOperationCategory.addActionListener( this );
		comboOperationProduct.addActionListener( this );
		comboMethod.addActionListener( this );
		b.addActionListener( this );
	} // End method.
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == comboMethod ){
			String item = ( String ) comboMethod.getSelectedItem();
			if( item.equalsIgnoreCase( "PRODUCTO" ) ){
				comboOperationCategory.setEnabled( false );
				comboOperationProduct.setEnabled( true );
				flag = true;
			}else{
				comboOperationCategory.setEnabled( true );
				comboOperationProduct.setEnabled( false );
				flag = false;
			} // End nested if-else.
			disableCategoryFields();
			disableProductFields();
		}else if( e.getSource() == comboOperationProduct ){
			String item = ( String ) comboOperationProduct.getSelectedItem();
			if( item.equalsIgnoreCase( "Nuevo Producto" ) ){
				createProduct();
			}else if( item.equalsIgnoreCase( "Producto por categoria" ) ){
				readProductByCategoryId();
			}else if( item.equalsIgnoreCase( "Producto por ID" ) ){
				readByProductId();
			}else if( item.equalsIgnoreCase( "Todos los productos" ) ){
				readAllProducts();
			}else if( item.equalsIgnoreCase( "Actualizar producto" ) ){
				updateProduct();
			}else{
				deleteProduct();
			} // End nested if-else-if.
		}else if( e.getSource() == comboOperationCategory ){
			String item = ( String ) comboOperationCategory.getSelectedItem();
			if( item.equalsIgnoreCase( "Crear categoria" ) ){
				createCategory();
			}else if( item.equalsIgnoreCase( "Categoria por ID" ) ){
				readByCategoryId();
			}else if( item.equalsIgnoreCase( "Todas las categorias" ) ){
				readAllCategories();
			}else if( item.equalsIgnoreCase( "Actualizar categoria" ) ){
				updateCategory();
			}else{
				deleteCategory();
			} // End nested if-else-if
		}else if( e.getSource() == b ){
			query = auxQuery;
			if( flag ){
				if( !idProductTextField.getText().equals( "" ) ){
					query += idProductTextField.getText() + ",";
				}else{
					query += "-1" + ",";
				} // End if-else.
				if( !nameProductTextField.getText().equals( "" ) ){
					query += nameProductTextField.getText() + ",";
				}else{
					query += "-1" + ",";
				} // End if-else.
				if( !priceTextField.getText().equals( "" ) ){
					query += priceTextField.getText() + ",";
				}else{
					query += "-1" + ",";
				} // End if-else.
				if( !idCategoryProductTextField.getText().equals( "" ) ){
					query += idCategoryProductTextField.getText();
				}else{
					query += "-1";
				} // End if-else.
				clearProductFields();
			}else{
				if( !idCategoryTextField.getText().equals( "" ) ){
					query += idCategoryTextField.getText() + ",";
				}else{
					query += "-1" + ",";
				} // End if-else.
				if( !nameCategoryTextField.getText().equals( "" ) ){
					query += nameCategoryTextField.getText() + ",";
				}else{
					query += "-1" + ",";
				} // End if-else.
				if( !descriptionTextField.getText().equals( "" ) ){
					query += descriptionTextField.getText();
				}else{
					query += "-1";
				} // End if-else.
				clearCategoryFields();
			} // End nested if-else.
			try {
				PrintStream output = new PrintStream( Cliente.client.getOutputStream() );
				output.println( query );
			} catch (IOException ee) {
				ee.printStackTrace();
			} // End try-catch.
			if( query.split( ":" )[ 1 ].split( " " )[ 0 ].equalsIgnoreCase( "READ" ) ){
				getRawData();
				String[] header = getHeader();
				String[][] data = getData();
				sp = new JScrollPane( new JTable( data, header ) );
				sp.setBounds( 20, 220, 860, 340 );
				add( sp );
				setVisible( true );
				al.clear();
			}
			query = "";
		} // End if-else-if.
	} // End actionPerformed.
	
	// The following methods will help to keep the stability of our GUI.
	public void getRawData(){
		try {
			BufferedReader input = new BufferedReader( new InputStreamReader( Cliente.client.getInputStream() ) );
			String tuple = "";
			while( !tuple.equals( "-1" ) ){
				tuple = input.readLine();
				if( !tuple.equals( "-1" ) ){
					System.out.println( tuple );
					al.add( tuple.split( "," ) );
				} // End if.
			} // End while.
			//input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // End method.
	
	public static String[] getHeader(){
		return al.remove( 0 );
	} // End method.
	
	public static String[][] getData(){
		String[][] data = new String[ al.size() ][];
		for( int i = 0 ; i < al.size() ; i++ ){
			data[ i ] = al.get( i );
		} // End for.
		return data;
	} // End method.
	
	public void disableCategoryFields(){
		idCategoryTextField.setEnabled( false );
		nameCategoryTextField.setEnabled( false );
		descriptionTextField.setEnabled( false );
	} // End method.
	
	public void clearCategoryFields(){
		idCategoryTextField.setText( "" );
		nameCategoryTextField.setText( "" );
		descriptionTextField.setText( "" );
	} // End method.
	
	public void disableProductFields(){
		idProductTextField.setEnabled( false );
		nameProductTextField.setEnabled( false );
		priceTextField.setEnabled( false );
		idCategoryProductTextField.setEnabled( false );
	} // End method.
	
	public void clearProductFields(){
		idProductTextField.setText( "" );
		nameProductTextField.setText( "" );
		priceTextField.setText( "" );
		idCategoryProductTextField.setText( "" );
	} // End method.
	
	public void createProduct(){
		idProductTextField.setEnabled( false );
		nameProductTextField.setEnabled( true );
		priceTextField.setEnabled( true );
		idCategoryProductTextField.setEnabled( true );
		disableCategoryFields();
		auxQuery = "PRODUCT:CREATE PRODUCT:";
	} // End method.
	
	public void readProductByCategoryId(){
		idProductTextField.setEnabled( false );
		nameProductTextField.setEnabled( false );
		priceTextField.setEnabled( false );
		idCategoryProductTextField.setEnabled( true );
		disableCategoryFields();
		auxQuery = "PRODUCT:READ PRODUCT BY CATEGORY ID:";
	} // End method.
	
	public void readByProductId(){
		idProductTextField.setEnabled( true );
		nameProductTextField.setEnabled( false );
		priceTextField.setEnabled( false );
		idCategoryProductTextField.setEnabled( false );
		disableCategoryFields();
		auxQuery = "PRODUCT:READ PRODUCT BY ID:";
	} // End method.
	
	public void readAllProducts(){
		idProductTextField.setEnabled( false );
		nameProductTextField.setEnabled( false );
		priceTextField.setEnabled( false );
		idCategoryProductTextField.setEnabled( false );
		disableCategoryFields();
		auxQuery = "PRODUCT:READ ALL PRODUCTS:";
	} // End method.
	
	public void updateProduct(){
		idProductTextField.setEnabled( true );
		nameProductTextField.setEnabled( true );
		priceTextField.setEnabled( true );
		idCategoryProductTextField.setEnabled( true );
		disableCategoryFields();
		auxQuery = "PRODUCT:UPDATE PRODUCT:";
	} // End method.
	
	public void deleteProduct(){
		idProductTextField.setEnabled( true );
		nameProductTextField.setEnabled( false );
		priceTextField.setEnabled( false );
		idCategoryProductTextField.setEnabled( false );
		disableCategoryFields();
		auxQuery = "PRODUCT:DELETE PRODUCT:";
	} // End method.
	
	public void createCategory(){
		idCategoryTextField.setEnabled( false );
		nameCategoryTextField.setEnabled( true );
		descriptionTextField.setEnabled( true );
		disableProductFields();
		auxQuery = "CATEGORY:CREATE CATEGORY:";
	} // End method.
	
	public void readByCategoryId(){
		idCategoryTextField.setEnabled( true );
		nameCategoryTextField.setEnabled( false );
		descriptionTextField.setEnabled( false );
		disableProductFields();
		auxQuery = "CATEGORY:READ BY CATEGORY ID:";
	} // End method.
	
	public void readAllCategories(){
		idCategoryTextField.setEnabled( false );
		nameCategoryTextField.setEnabled( false );
		descriptionTextField.setEnabled( false );
		disableProductFields();
		auxQuery = "CATEGORY:READ ALL CATEGORIES:";
	} // End method.
	
	public void updateCategory(){
		idCategoryTextField.setEnabled( true );
		nameCategoryTextField.setEnabled( true );
		descriptionTextField.setEnabled( true );
		disableProductFields();
		auxQuery = "CATEGORY:UPDATE CATEGORY:";
	} // End method.
	
	public void deleteCategory(){
		idCategoryTextField.setEnabled( true );
		nameCategoryTextField.setEnabled( false );
		descriptionTextField.setEnabled( false );
		disableProductFields();
		auxQuery = "CATEGORY:DELETE CATEGORY:";
	} // End method.
	
} // End class.
