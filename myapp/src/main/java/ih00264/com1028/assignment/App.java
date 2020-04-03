package ih00264.com1028.assignment;

public class App {

	public static void main(String[] args) {
	    BaseQuery dao = new BaseQuery("user","password");
	    
	    //Output all requirements info:   
	    //1. List the products in each product line (Products)
	    //2. Report the total payments by date (Payments)
	    //3.  List names of customers and their corresponding order number where a particular order from that customer has a value greater than $25,000? 
	    //    (Customers, Orders, OrderDetails) order value = priceEach * quantityOrdered
	    
	    //SQL for testing:
	    //1. SELECT productLine, productCode, productName FROM products ORDER BY productLine
	    //2. 
	    //3.
	    
	}

}
