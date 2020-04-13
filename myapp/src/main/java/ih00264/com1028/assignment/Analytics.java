/**
 * 
 */
package ih00264.com1028.assignment;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author imogen
 * Class to connect to database and provide methods of java code to act as SQL statements
 *
 */
public class Analytics extends BaseQuery {

	private final static String USERNAME = "root";
	private final static String PASSWORD = " ";  // TODO CHNAGE TO YOUR ROOT YOUR ROOT PASSWORD
	

	public Analytics() {
		super(USERNAME, PASSWORD);
	}

	
	
	public ArrayList<ArrayList<Object>> select(List<String> columns, String table) throws SQLException {
		ArrayList<ArrayList<Object>> data = new ArrayList<>();
		ArrayList<Object> rowData;
		ResultSet rs = null;
		
		try {
			rs = useTable(table);
			while(rs.next()) {
				rowData = new ArrayList<Object>();
				for(String c:columns) {
					rowData.add(rs.getObject(c));
				}
				data.add(rowData);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
			
		}
		finally {
			if(rs!=null)
				rs.close();
		}
		return data;
		
	}
	
	

	public ArrayList<Payment> sumAmount(ArrayList<Payment> list){
		for(int row =0; row < list.size()-1; row++) {
			if(list.get(row).getPaymentDate().equals(list.get(row+1).getPaymentDate())) { //check if same date (GROUP BY)
				BigDecimal amount = list.get(row).getAmount().add(list.get(row+1).getAmount()); 
				Payment newRow = new Payment(list.get(row).getPaymentDate(), amount); //makes new object with sum of amount column for same date (SUM)
				list.set(row+1, newRow); //new row replaces combined ones
				list.remove(row);
				row--;
			}
		}
		return list;
	}
	
	
	
	public ArrayList<Order> innerJoin(ArrayList<ArrayList<Object>> list, ArrayList<OrderDetails> orderDetails, ArrayList<Customer> customers){
		ArrayList<Order> orders = new ArrayList<Order>();				
		for(ArrayList<Object> o_list : list) { //Goes through each order
			Customer matchingCustomer = null;
			for(Customer customer : customers) { //Goes through each customer
				if(customer.getCustomerNumber() == (int)o_list.get(1)) { //Comparing to orders to join tables where same CustomerNumber (INNER JOIN)
					matchingCustomer = customer;
					OrderDetails matchingDetails = null;
					for(OrderDetails orderDetail : orderDetails) { //Goes through each order details for each customer
						if(orderDetail.getOrderNumber() == (int)o_list.get(0)) { //Comparing to orders to join tables where same OrderNumber (INNER JOIN)
							matchingDetails = orderDetail;
							BigDecimal totalPrice = matchingDetails.getPriceEach().multiply(new BigDecimal(matchingDetails.getQuantityOrdered())); //finds total price of order of one product
							Order order = new Order((int)o_list.get(0), (int)o_list.get(1), matchingCustomer,  matchingDetails, totalPrice);
							orders.add(order); //adds joined tables to new list of values
						}
					}
				}
			}
		}
		return orders;
	}
	
	
	
	public ArrayList<Order> sumValue(ArrayList<Order> list){
		for(int row =0; row < list.size()-1; row++) {
			if(list.get(row).getOrderNumber() == list.get(row+1).getOrderNumber()) { //check if same order number (GROUP BY)				
				BigDecimal value = list.get(row).getTotalPrice().add(list.get(row+1).getTotalPrice()); 		
					Order newRow = new Order(list.get(row).getOrderNumber(), list.get(row).getCustomerNumber(), list.get(row).getCustomer(), list.get(row).getOrderDetails(), value);//makes new object with sum of totelPrice column for same orderNumber (SUM)				
					list.set(row+1, newRow); //new row replaces combined ones
					list.remove(row);
					row--;
			}
		}
		return list;
	}
	
	
	
	public ArrayList<Order> where(ArrayList<Order> list, int max){
		for(int row =0; row < list.size(); row++) {
			if (list.get(row).getTotalPrice().compareTo(new BigDecimal(max)) <= 0) { //compareTo returns 1 if greater than (WHERE > max)
				list.remove(list.get(row)); //removes rows < max
				row--;
			}
		}
		return list;
	}
	

	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
