/**
 * 
 */
package ih00264.com1028.assignment;

/**
 * @author imogen
 *
 */
public class Order {
	
	private int orderNumber = 0;
	private int customerNumber = 0;
	private Customer customer = null;
	private OrderDetails orderDetails = null;
	
	/**
	 * @param orderNumber
	 * @param customerNumber
	 * @param customer
	 * @param orderDetails
	 */
	public Order(int orderNumber, int customerNumber, Customer customer, OrderDetails orderDetails) {
		super();
		this.orderNumber = orderNumber;
		this.customerNumber = customerNumber;
		this.customer = customer;
		this.orderDetails = orderDetails;
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

	@Override
	public String toString() {
		return customer.toString() + "    " + this.orderNumber + "     " +  orderDetails.toString();
	}


	
	

	
	

}
