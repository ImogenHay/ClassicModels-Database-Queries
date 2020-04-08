/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;

/**
 * @author imogen
 *
 */
public class OrderDetails {

	private int orderNumber = 0;
	private int quantityOrdered = 0;
	private BigDecimal priceEach = null;
	
	/**
	 * @param orderNumber
	 * @param quantityOrdered
	 * @param priceEach
	 */
	public OrderDetails(int orderNumber, int quantityOrdered, BigDecimal priceEach) {
		super();
		this.orderNumber = orderNumber;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
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
	 * @return the quantityOrdered
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * @return the priceEach
	 */
	public BigDecimal getPriceEach() {
		return priceEach;
	}

	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}
}
