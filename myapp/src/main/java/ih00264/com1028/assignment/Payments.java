/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author imogen
 * Creates list of payment objects and displays them in formatted way
 *
 */
public class Payments {
	
	private List<String> columns = null;
	private Analytics analytics = null;
	private ArrayList<Payment> payments = null;
	
	/**
	 * @param columns
	 * @param analytics
	 */
	public Payments(List<String> columns, Analytics analytics) {
		super();
		this.columns = columns;
		this.analytics = analytics;
		this.payments = new ArrayList<Payment>();
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
	 * @return the payments
	 */
	public ArrayList<Payment> getPayments() {
		return payments;
	}



	public void createList() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "payments");
		for(ArrayList<Object> p_list : list) {
			BigDecimal amount = new BigDecimal(p_list.get(1).toString());
			Payment payment = new Payment(p_list.get(0).toString(), amount);
			this.payments.add(payment);
		}
		Collections.sort(this.payments);
		this.payments = this.analytics.sumAmount(this.payments);
	}
	
	

	@Override
	public String toString() {
			StringBuffer buffer = new StringBuffer("\n\n2. Report the total payments by date:\n");
			buffer.append(String.format("%-21s %-21s", this.columns.get(0), this.columns.get(1)));
			buffer.append("\n-------------------------------------------\n");
			for (Payment payment : this.payments) {
				buffer.append(payment.toString() + "\n");
			}
				buffer.append("-------------------------------------------\n");
				buffer.append("Number of Rows: " + this.payments.size() + "\n");

		return buffer.toString();
	}

}
