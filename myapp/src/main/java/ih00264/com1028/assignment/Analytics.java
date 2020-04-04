/**
 * 
 */
package ih00264.com1028.assignment;

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
		// TODO Auto-generated constructor stub
	}


	//Methods:
	//get list of columns (select)
	//order list by attribute (order by)
	
	
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
	
	
	//public ArrayList<ArrayList<Object>> orderBy(List<String> columns, String table) throws SQLException {
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
