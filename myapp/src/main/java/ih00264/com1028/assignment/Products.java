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
 *
 */
public class Products {


	private List<String> columns = null;
	private Analytics analytics = null;
	
	
	/**
	 * @param columns
	 * @param analytics
	 */
	public Products(List<String> columns, Analytics analytics) {
		super();
		this.columns = columns;
		this.analytics = analytics;
	}



	public ArrayList<Product> createObjects() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "products");
		ArrayList<Product> products = new ArrayList<Product>();
		for(ArrayList<Object> p_list : list) {
			String productLine = (String) p_list.get(0);
			String productCode = (String) p_list.get(1);
			String productName = (String) p_list.get(2);
			Product product = new Product(productLine, productCode, productName);
			products.add(product);
		}
		Collections.sort(products);
		return products;
	}



	@Override
	public String toString() {
			StringBuffer buffer = new StringBuffer("1. List the products in each product line:\n");
			buffer.append(String.format("%-31s %-21s %-51s", this.columns.get(0), this.columns.get(1), this.columns.get(2)));
			buffer.append("\n---------------------------------------------------------------------------------------------------------\n");
			try {
				ArrayList<Product> list = this.createObjects();
				for (Product product : list) {
					buffer.append(product.toString() + "\n");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		buffer.append("---------------------------------------------------------------------------------------------------------\n");
		return buffer.toString();
	}
}