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
public class Requirement3Test {
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue( true );
	}
	
	
	
	@Test
	public void testCustomer() {
		Customer customer = new Customer(1, "Alpha Cognac");
		//System.out.println(customer);	
		assertEquals("Alpha Cognac" ,customer.toString());
	}
	
	
	
	@Test
	public void testOrder() {
		Customer customer = new Customer(1, "Alpha Cognac");
		OrderDetails orderDetails = new OrderDetails(10178,3, new BigDecimal("12.0"));
		Order order = new Order(10178,1,customer,orderDetails, new BigDecimal("33818.34"));
		//System.out.println(order);	
		assertEquals("|Alpha Cognac                            | 10178               |33818.34            |" ,order.toString());
	}
	
	
	
	@Test
	public void testGetOrderNumber() {
		Customer customer = new Customer(1, "Alpha Cognac");
		OrderDetails orderDetails = new OrderDetails(10178,3, new BigDecimal("12.0"));
		Order order = new Order(10178,1,customer,orderDetails, new BigDecimal("33818.34"));
		assertTrue(order.getOrderNumber() == 10178 && orderDetails.getOrderNumber() == 10178);
	}
	
	
	
	@Test
	public void testGetCustomerNumber() {
		Customer customer = new Customer(1, "Alpha Cognac");
		OrderDetails orderDetails = new OrderDetails(10178,3, new BigDecimal("12.0"));
		Order order = new Order(10178,1,customer,orderDetails, new BigDecimal("33818.34"));
		assertTrue(order.getCustomerNumber() == 1 && customer.getCustomerNumber() == 1);
	}
	
	
	
	@Test
	public void testGetCustomer() {
		Customer customer = new Customer(1, "Alpha Cognac");
		OrderDetails orderDetails = new OrderDetails(10178,3, new BigDecimal("12.0"));
		Order order = new Order(10178,1,customer,orderDetails, new BigDecimal("33818.34"));
		assertEquals(customer , order.getCustomer());
	}
	
	
	
	@Test
	public void testGetOrderDetails() {
		Customer customer = new Customer(1, "Alpha Cognac");
		OrderDetails orderDetails = new OrderDetails(10178,3, new BigDecimal("12.0"));
		Order order = new Order(10178,1,customer,orderDetails, new BigDecimal("33818.34"));
		assertEquals(orderDetails , order.getOrderDetails());
	}
	
	
	
	@Test
	public void testGetTotalPrice() {
		Customer customer = new Customer(1, "Alpha Cognac");
		OrderDetails orderDetails = new OrderDetails(10178,3, new BigDecimal("12.0"));
		Order order = new Order(10178,1,customer,orderDetails, new BigDecimal("33818.34"));
		assertEquals("33818.34" , order.getTotalPrice().toString());
	}
	
	

	@Test
	public void testLength() throws SQLException { //compare SQL queries to results from code
		Analytics connection = new Analytics("root","password");
		List<String> columns = Arrays.asList("OrderNumber", "CustomerNumber");
		Orders orders = new Orders(columns, connection);
		
		ArrayList<Order> createdList = orders.createList();
		
		columns = Arrays.asList("CustomerName", "OrderNumber","SUM(orderdetails.quantityOrdered * orderdetails.priceEach)");
		ArrayList<ArrayList<Object>> sqlData = connection.sqlTest("SELECT customers.customerName, orders.orderNumber, SUM(orderdetails.quantityOrdered * orderdetails.priceEach) FROM orders INNER JOIN customers ON customers.customerNumber=orders.customerNumber INNER JOIN orderdetails ON orderdetails.orderNumber=orders.orderNumber GROUP BY orders.orderNumber HAVING SUM(orderdetails.quantityOrdered * orderdetails.priceEach) > 25000 ORDER BY upper(customers.customerName)",columns);

		//System.out.println(createdList.size());
		//System.out.println(sqlData.size());		
		assertTrue(createdList.size()==sqlData.size());
	}
	
	
	@Test
	public void testData() throws SQLException { //compare SQL queries to results from code
		Analytics connection = new Analytics("root","password");
		List<String> columns = Arrays.asList("OrderNumber", "CustomerNumber");
		Orders orders = new Orders(columns, connection);
		
		ArrayList<Order> createdObjects = orders.createList();
		ArrayList<ArrayList<Object>> createdList = new ArrayList<>();
		for (Order order : createdObjects) {
			ArrayList<Object> orderList = new ArrayList<>();
			orderList.add(order.getCustomer().getCustomerName());
			orderList.add(order.getOrderNumber());
			orderList.add(order.getTotalPrice());
			createdList.add(orderList);
		}
		
		columns = Arrays.asList("CustomerName", "OrderNumber","SUM(orderdetails.quantityOrdered * orderdetails.priceEach)");
		ArrayList<ArrayList<Object>> sqlList = connection.sqlTest("SELECT customers.customerName, orders.orderNumber, SUM(orderdetails.quantityOrdered * orderdetails.priceEach) FROM orders INNER JOIN customers ON customers.customerNumber=orders.customerNumber INNER JOIN orderdetails ON orderdetails.orderNumber=orders.orderNumber GROUP BY orders.orderNumber HAVING SUM(orderdetails.quantityOrdered * orderdetails.priceEach) > 25000 ORDER BY upper(customers.customerName)",columns);	

		//System.out.println(createdList);
		//System.out.println(sqlList);
		assertArrayEquals(sqlList.toArray(),createdList.toArray()); 
	}
}
