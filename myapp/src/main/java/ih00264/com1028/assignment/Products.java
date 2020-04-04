/**
 * 
 */
package ih00264.com1028.assignment;

import java.sql.SQLException;
import java.util.ArrayList;
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



	public ArrayList<Object> createObjects() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "products");
		ArrayList<Object> products = new ArrayList<Object>();
		for(ArrayList<Object> p_list : list) {
			String productLine = (String) p_list.get(0);
			String productCode = (String) p_list.get(1);
			String productName = (String) p_list.get(2);
			Product product = new Product(productLine, productCode, productName);
			products.add(product);
		}
		return products;
	}



	@Override
	public String toString() {
			StringBuffer buffer = new StringBuffer("List the products in each product line:\n");
			try {
				ArrayList<Object> list = this.createObjects();
				for (Object product : list) {
					buffer.append(product + "\n");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}

		return buffer.toString();
	}
}
