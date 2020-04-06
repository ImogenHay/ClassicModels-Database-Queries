/**
 * 
 */
package ih00264.com1028.assignment;

/**
 * @author imogen
 *
 */
public class Payment implements Comparable<Payment>{
	
	//private int customerNumber = 0;
	//private String checkNumber = null;
	private String paymentDate = null;
	private String amount = null;
	
	/**
	 * @param paymentDate
	 * @param amount
	 */
	public Payment(String paymentDate, String amount) {
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
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(Payment p) {
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
