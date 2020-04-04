package ih00264.com1028.assignment;



import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) throws SQLException {
	    
	    //Output all requirements info:   
	    //1. List the products in each product line (Products)
	    //2. Report the total payments by date (Payments)
	    //3.  List names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000? 
	    //    (Customers, Orders, OrderDetails) order value = priceEach * quantityOrdered
	    
	    //SQL for testing:
	    //1. SELECT productLine, productCode, productName FROM products ORDER BY productLine
	    //2. SELECT paymentDate, amount FROM payments ORDER BY paymentDate
	    //3.
	    
		Analytics connection = new Analytics("root","password");
		
		//1.
		List<String> columns = Arrays.asList("productLine", "productCode", "productName");
		Products products = new Products(columns, connection);
		System.out.println(products.toString());
		

		
		

	    
	}

}
