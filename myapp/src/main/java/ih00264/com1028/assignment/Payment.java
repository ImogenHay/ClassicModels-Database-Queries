/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;

/**
 * @author imogen
 * Creates payment objects using payment table
 */
public class Payment implements Comparable<Payment>{
	
	private String paymentDate = null;
	private BigDecimal amount = null;
	
	/**
	 * @param paymentDate
	 * @param amount
	 */
	public Payment(String paymentDate, BigDecimal amount) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	

	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}

	
	
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	
	

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	@Override
	public boolean equals(Object obj) { //used in testing to check if two objects in list of lists have the same attributes
	    if(this == obj) 
	    	return true;
	    
	    if(obj == null || obj.getClass()!= this.getClass()) 
	    	return false;
	    
	    Payment payment = (Payment) obj;
	    if(payment.getPaymentDate().equals(this.paymentDate) && payment.getAmount().equals(this.amount)) 
	    	return true;
	    
	    return false;
	}

	
	
	@Override
	public int compareTo(Payment p) { //used to sort list of payments in order of their date
		if (getPaymentDate() == null || p.getPaymentDate() == null) {
		      return 0;
		}
		return getPaymentDate().compareTo(p.getPaymentDate());
	}

	
	
	@Override
	public String toString() {
		return String.format("|%-20s| %-20s|", this.paymentDate, this.amount);
	}
	
	

}
