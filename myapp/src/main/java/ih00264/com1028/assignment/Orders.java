/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author imoge
 *
 */
public class Orders {
	
	private List<String> columns = null;
	private Analytics analytics = null;
	
	/**
	 * @param columns
	 * @param analytics
	 */
	public Orders(List<String> columns, Analytics analytics) {
		super();
		this.columns = columns;
		this.analytics = analytics;
	}
	
	public ArrayList<Customer> createCustomers() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(Arrays.asList("CustomerNumber", "CustomerName"), "customers");
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for(ArrayList<Object> p_list : list) {
			Customer customer = new Customer((int) p_list.get(0), p_list.get(1).toString());
			customers.add(customer);
		}
		return customers;
	}
	
	
	
	public ArrayList<OrderDetails> createOrderDetails() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(Arrays.asList("OrderNumber", "QuantityOrdered", "PriceEach"), "orderdetails");
		ArrayList<OrderDetails> orderdetails = new ArrayList<OrderDetails>();
		for(ArrayList<Object> p_list : list) {
			BigDecimal priceEach = new BigDecimal(p_list.get(2).toString());
			OrderDetails orderdetail = new OrderDetails((int) p_list.get(0), (int)p_list.get(1), priceEach);
			orderdetails.add(orderdetail);
		}
		return orderdetails;
	}
	
	
	
	public ArrayList<Order> createList() throws SQLException{		
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "orders");
		ArrayList<Customer> customers = this.createCustomers();
		ArrayList<OrderDetails> orderDetails = this.createOrderDetails();
		System.out.println("HH");
		ArrayList<Order> orders = this.analytics.innerJoin(list, orderDetails, customers);

		//Collections.sort(orders);
		return orders;
	}

	@Override
	public String toString() {
		System.out.println("Z");
		StringBuffer buffer = new StringBuffer("\n\n3. List names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000:\n");
		buffer.append(String.format("%-21s %-21s", this.columns.get(0), this.columns.get(1)));
		buffer.append("\n-------------------------------------------\n");
		try {
			ArrayList<Order> list = this.createList();
			for (Order order : list) {
				buffer.append(order.toString() + "\n");
			}
			buffer.append("-------------------------------------------\n");
			buffer.append("Number of Rows: " + list.size() + "\n");
		} catch (SQLException e) {
			System.out.println(e);
		}

	return buffer.toString();
	}
}
