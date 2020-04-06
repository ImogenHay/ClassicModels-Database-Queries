/**
 * 
 */
package ih00264.com1028.assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author imogen
 *
 */
public class Payments {
	
	private List<String> columns = null;
	private Analytics analytics = null;
	
	/**
	 * @param columns
	 * @param analytics
	 */
	public Payments(List<String> columns, Analytics analytics) {
		super();
		this.columns = columns;
		this.analytics = analytics;
	}



	public ArrayList<Payment> createObjects() throws SQLException{
		ArrayList<ArrayList<Object>> list = this.analytics.select(this.columns, "payments");
		ArrayList<Payment> payments = new ArrayList<Payment>();
		for(ArrayList<Object> p_list : list) {
			Payment payment = new Payment(p_list.get(0).toString(), p_list.get(1).toString());
			payments.add(payment);
		}
		Collections.sort(payments);
		return payments;
	}
	
	

	@Override
	public String toString() {
			StringBuffer buffer = new StringBuffer("\n\n2. Report the total payments by date:\n");
			buffer.append(String.format("%-21s %-21s", this.columns.get(0), this.columns.get(1)));
			buffer.append("\n-------------------------------------------\n");
			try {
				ArrayList<Payment> list = this.createObjects();
				for (Payment payment : list) {
					buffer.append(payment.toString() + "\n");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		buffer.append("-------------------------------------------\n");
		return buffer.toString();
	}
}
