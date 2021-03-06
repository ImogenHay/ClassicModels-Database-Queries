package ih00264.com1028.assignment;

/**
 * @author imogen
 * Displays appropriate information in console
 */

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;




public class App {

	public static void main(String[] args) throws SQLException {
	    
	    //Output all requirements info:   
	    //1. List the products in each product line (Product, Products)
	    //2. Report the total payments by date (Payment, Payments)
	    //3.  List names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000
	    //    (Customer, OrderDetails, Order,  Orders) order value = priceEach * quantityOrdered
	    
	    //SQL for testing:
	    //1. SELECT productLine, productCode, productName FROM products ORDER BY productLine
	    //2. SELECT paymentDate, SUM(amount) FROM payments GROUP BY paymentDate ORDER BY paymentDate
	    //3. SELECT customers.customerName, orders.orderNumber, SUM(orderdetails.quantityOrdered * orderdetails.priceEach) FROM orders INNER JOIN customers ON customers.customerNumber=orders.customerNumber INNER JOIN orderdetails ON orderdetails.orderNumber=orders.orderNumber GROUP BY orders.orderNumber HAVING SUM(orderdetails.quantityOrdered * orderdetails.priceEach) > 25000 ORDER BY upper(customers.customerName)

		
		
		Analytics connection = new Analytics(); //CAN CHANGE USER NAME AND PASSWORD IN ANALYTICS CLASS 
	
				
		//1.
		List<String> columns = Arrays.asList("ProductLine", "ProductCode", "ProductName");
		Products products = new Products(columns, connection);
		products.createList();
		System.out.println(products.toString());
		
		//2.
		columns = Arrays.asList("PaymentDate", "Amount");
		Payments payments = new Payments(columns, connection);
		payments.createList();
		System.out.println(payments.toString());
		
		//3.
		columns = Arrays.asList("OrderNumber", "CustomerNumber");
		Orders orders = new Orders(columns, connection);
		orders.createList();
		System.out.println(orders.toString());
		
		
		    
	}

}
