/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;

/**
 * @author imogen
 *
 */
public class Order implements Comparable<Order>{
	
	private int orderNumber = 0;
	private int customerNumber = 0;
	private Customer customer = null;
	private OrderDetails orderDetails = null;
	private BigDecimal totalPrice = null;
	
	/**
	 * @param orderNumber
	 * @param customerNumber
	 * @param customer
	 * @param orderDetails
	 * @param totalPrice
	 */
	public Order(int orderNumber, int customerNumber, Customer customer, OrderDetails orderDetails, BigDecimal totalPrice) {
		super();
		this.orderNumber = orderNumber;
		this.customerNumber = customerNumber;
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the orderDetails
	 */
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public int compareTo(Order o) {
		if (getCustomer().getCustomerName().toUpperCase() == null || o.getCustomer().getCustomerName().toUpperCase() == null) {
		      return 0;
		}
		return getCustomer().getCustomerName().toUpperCase().compareTo(o.getCustomer().getCustomerName().toUpperCase());
	}

	@Override
	public String toString() {
		return String.format("|%-40s| %-20s|%-20s|", customer.toString(), this.orderNumber, this.totalPrice);
	}




	
	

	
	

}
