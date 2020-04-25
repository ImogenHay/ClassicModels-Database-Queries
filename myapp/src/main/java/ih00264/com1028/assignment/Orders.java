/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author imogen
 * Creates list of order objects and displays them in formatted way
 */
public class Orders {
	
	private List<String> columns = null;
	private Analytics analytics = null;
	private ArrayList<Order> orders = null;
	
	/**
	 * @param columns
	 * @param analytics
	 */
	public Orders(List<String> columns, Analytics analytics) {
		super();
		this.columns = columns;
		this.analytics = analytics;
		this.orders = new ArrayList<Order>();
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
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}



	private ArrayList<Customer> createCustomers() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(Arrays.asList("CustomerNumber", "CustomerName"), "customers");
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for(ArrayList<Object> p_list : list) {
			Customer customer = new Customer((int) p_list.get(0), p_list.get(1).toString());
			customers.add(customer);
		}
		return customers;
	}
	
	
	
	private ArrayList<OrderDetails> createOrderDetails() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(Arrays.asList("OrderNumber", "QuantityOrdered", "PriceEach"), "orderdetails");
		ArrayList<OrderDetails> orderdetails = new ArrayList<OrderDetails>();
		for(ArrayList<Object> p_list : list) {
			BigDecimal priceEach = new BigDecimal(p_list.get(2).toString());
			OrderDetails orderdetail = new OrderDetails((int) p_list.get(0), (int)p_list.get(1), priceEach);
			orderdetails.add(orderdetail);
		}
		return orderdetails;
	}
	
	
	
	public void createList() throws SQLException{		
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "orders");
		ArrayList<Customer> customers = this.createCustomers();
		ArrayList<OrderDetails> orderDetails = this.createOrderDetails();
		this.orders = this.analytics.innerJoin(list, orderDetails, customers);
		Collections.sort(this.orders);
		this.orders = this.analytics.sumValue(this.orders);
		this.orders = this.analytics.where(this.orders, 25000);
	}
	

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("\n\n3. List names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000:\n");
		buffer.append(String.format("%-41s %-21s %-21s", "CustomerName", "OrderNumber", "Value"));
		buffer.append("\n------------------------------------------------------------------------------------\n");
		for (Order order : this.orders) {
			buffer.append(order.toString() + "\n");
		}
			buffer.append("------------------------------------------------------------------------------------\n");
			buffer.append("Number of Rows: " + this.orders.size() + "\n");
	return buffer.toString();
	}

}
