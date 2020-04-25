/**
 * 
 */
package ih00264.com1028.assignment;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author imogen
 *
 */
public class Requirement2Test {
	
	
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue( true );
	}
	
	
	
	@Test
	public void shouldBeEqual() {
		assertEquals("true" ,"true");
	}
	
	
	
	@Test
	public void testPayment() {
		Payment payment = new Payment("2003-01-16", new BigDecimal("10223.83"));
		//System.out.println(payment);	
		assertEquals("|2003-01-16          | 10223.83            |" ,payment.toString());
	}
	
	
	
	@Test
	public void testGetPaymentDate() {
		Payment payment = new Payment("2003-01-16", new BigDecimal("10223.83"));
		assertEquals("2003-01-16" ,payment.getPaymentDate());
	}
	
	
	
	@Test
	public void testGetAmount() {
		Payment payment = new Payment("2003-01-16", new BigDecimal("10223.83"));
		assertEquals("10223.83" ,payment.getAmount().toString());
	}
	
	

	@Test
	public void testLength() throws SQLException { //compare SQL queries to results from code
		Analytics connection = new Analytics();
		List<String> columns = Arrays.asList("PaymentDate", "amount");
		Payments payments = new Payments(columns, connection);
		
		payments.createList();
		ArrayList<Payment> createdList = payments.getPayments();
		
		columns = Arrays.asList("PaymentDate", "SUM(amount)");
		ArrayList<ArrayList<Object>> sqlData = connection.sqlTest("SELECT paymentDate, SUM(amount) FROM payments GROUP BY paymentDate ORDER BY paymentDate",columns);

		//System.out.println(createdList.size());
		//System.out.println(sqlData.size());		
		assertTrue(createdList.size()==sqlData.size());
	}
	
	
	
	@Test
	public void testData() throws SQLException { //compare SQL queries to results from code
		Analytics connection = new Analytics();
		List<String> columns = Arrays.asList("PaymentDate", "Amount");
		Payments payments = new Payments(columns, connection);
		
		payments.createList();
		ArrayList<Payment> createdList = payments.getPayments();
		
		columns = Arrays.asList("PaymentDate", "SUM(amount)");
		ArrayList<ArrayList<Object>> sqlData = connection.sqlTest("SELECT paymentDate, SUM(amount) FROM payments GROUP BY paymentDate ORDER BY paymentDate",columns);
		ArrayList<Payment> sqlList = new ArrayList<Payment>();
		for(ArrayList<Object> p_list : sqlData) {
			Payment payment = new Payment(p_list.get(0).toString(), new BigDecimal(p_list.get(1).toString()));
			sqlList.add(payment);
		}

		//System.out.println(createdList);
		//System.out.println(sqlList);
		assertArrayEquals(sqlList.toArray(),createdList.toArray()); 
	}
		
}
