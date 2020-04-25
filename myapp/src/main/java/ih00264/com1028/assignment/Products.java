/**
 * 
 */
package ih00264.com1028.assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author imogen
 * Creates list of product objects and displays them in formatted way
 *
 */
public class Products {


	private List<String> columns = null;
	private Analytics analytics = null;
	private ArrayList<Product> products = null;
	
	
	/**
	 * @param columns
	 * @param analytics
	 */
	public Products(List<String> columns, Analytics analytics) {
		super();
		this.columns = columns;
		this.analytics = analytics;
		this.products = new ArrayList<Product>();
	}



	/**
	 * @return the columns
	 */
	public List<String> getColumns() {
		return columns;
	}



	/**
	 * @param columns the columns to set
	 */
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}



	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}



	public void createList() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "products");		
		for(ArrayList<Object> p_list : list) {
			Product product = new Product((String) p_list.get(0), (String) p_list.get(1), (String) p_list.get(2));
			this.products.add(product);
		}
		Collections.sort(this.products);
	}
	
	

	@Override
	public String toString() {
			StringBuffer buffer = new StringBuffer("\n\n1. List the products in each product line:\n");
			buffer.append(String.format("%-31s %-21s %-51s", this.columns.get(0), this.columns.get(1), this.columns.get(2)));
			buffer.append("\n---------------------------------------------------------------------------------------------------------\n");
				for (Product product : this.products) {
					buffer.append(product.toString() + "\n");
				}
				buffer.append("---------------------------------------------------------------------------------------------------------\n");
				buffer.append("Number of Rows: " + this.products.size() + "\n");
		return buffer.toString();
	}
}
