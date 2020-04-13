/**
 * 
 */
package ih00264.com1028.assignment;

/**
 * @author imogen
 * Creates customer objects from customer table 
 */
public class Customer {
	
	private int customerNumber = 0;
	private String customerName = null;
	
	/**
	 * @param customerNumber
	 * @param customerName
	 */
	public Customer(int customerNumber, String customerName) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return customerName;
	}
}
