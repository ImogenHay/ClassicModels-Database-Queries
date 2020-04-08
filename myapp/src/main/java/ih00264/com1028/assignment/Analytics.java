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
 * @author imoge
 *
 */
public class Analytics extends BaseQuery {

	/**
	 * @param uname
	 * @param pwd
	 */
	public Analytics(String uname, String pwd) {
		super(uname, pwd);
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
				Payment newRow = new Payment(list.get(row).getPaymentDate(), amount);
				list.set(row+1, newRow);
				list.remove(row);
				row--;
			}
		}
		return list;
	}
	
	
	public ArrayList<Order> innerJoin(ArrayList<ArrayList<Object>> list, ArrayList<OrderDetails> orderDetails, ArrayList<Customer> customers){
		ArrayList<Order> orders = new ArrayList<Order>();				
		for(ArrayList<Object> o_list : list) {
			Customer matchingCustomer = null;
			for(Customer customer : customers) {
				if(customer.getCustomerNumber() == (int)o_list.get(1)) {
					matchingCustomer = customer;
					OrderDetails matchingDetails = null;
					for(OrderDetails orderDetail : orderDetails) {
						if(orderDetail.getOrderNumber() == (int)o_list.get(0)) {
							matchingDetails = orderDetail;
							Order order = new Order((int)o_list.get(0), (int)o_list.get(1), matchingCustomer,  matchingDetails);
							orders.add(order);
						}
					}
				}
			}
		}
		return orders;
	}
	

	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
