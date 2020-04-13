/**
 * 
 */
package ih00264.com1028.assignment;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author imogen
 *
 */
public class Requirement1Test {

	@Test
	public void shouldAnswerWithTrue() {
		assertTrue( true );
	}
	
	
	
	@Test
	public void shouldBeEqual() {
		assertEquals("true" ,"true");
	}
	
	
	
	@Test
	public void testProduct() {
		Product product = new Product("Classic Cars", "S10_1949", "1952 Alpine Renault 1300");
		//System.out.println(product);	
		assertEquals("|Classic Cars                  | S10_1949            | 1952 Alpine Renault 1300                          |" ,product.toString());
	}
	
	
	
	@Test
	public void testGetProductLine() {
		Product product = new Product("Classic Cars", "S10_1949", "1952 Alpine Renault 1300");
		assertEquals("Classic Cars" ,product.getProductLine());
	}
	
	
	
	@Test
	public void testGetProductCode() {
		Product product = new Product("Classic Cars", "S10_1949", "1952 Alpine Renault 1300");
		assertEquals("S10_1949" ,product.getProductCode());
	}
	
	
	
	@Test
	public void testGetProductName() {
		Product product = new Product("Classic Cars", "S10_1949", "1952 Alpine Renault 1300");
		assertEquals("1952 Alpine Renault 1300" ,product.getProductName());
	}
	


	@Test
	public void testLength() throws SQLException { //compare SQL queries to results from code
		Analytics connection = new Analytics();
		List<String> columns = Arrays.asList("ProductLine", "ProductCode", "ProductName");
		Products products = new Products(columns, connection);
		
		ArrayList<Product> createdList = products.createList();
		
		ArrayList<ArrayList<Object>> sqlData = connection.sqlTest("SELECT productLine, productCode, productName FROM products ORDER BY productLine",columns);

		//System.out.println(createdList.size());
		//System.out.println(sqlData.size());		
		assertTrue(createdList.size()==sqlData.size());
	}
	
	
	
	@Test
	public void testData() throws SQLException { //compare SQL queries to results from code
		Analytics connection = new Analytics();
		List<String> columns = Arrays.asList("ProductLine", "ProductCode", "ProductName");
		Products products = new Products(columns, connection);
		
		ArrayList<Product> createdList = products.createList();
		
		ArrayList<ArrayList<Object>> sqlData = connection.sqlTest("SELECT productLine, productCode, productName FROM products ORDER BY productLine",columns);
		ArrayList<Product> sqlList = new ArrayList<Product>();
		for(ArrayList<Object> p_list : sqlData) {
			Product product = new Product((String) p_list.get(0), (String) p_list.get(1), (String) p_list.get(2));
			sqlList.add(product);
		}

		//System.out.println(createdList);
		//System.out.println(sqlList);
		assertArrayEquals(sqlList.toArray(),createdList.toArray()); 
		

	}
	
	

	
	

	

}
