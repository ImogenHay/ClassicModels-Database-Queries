package ih00264.com1028.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseQuery {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels?&serverTimezone=UTC";

	public BaseQuery(String uname, String pwd){
		try {
		    //Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			con = DriverManager.getConnection( db, uname, pwd);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected ResultSet useTable(String tableName) throws SQLException{
		String query = "select * from " + tableName; 
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);	
		return rs;
	}
	
	protected ArrayList<ArrayList<Object>> sqlTest(String query, List<String> columns) throws SQLException{
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		ArrayList<ArrayList<Object>> data = new ArrayList<>();
		ArrayList<Object> rowData;
		while(rs.next()) {
			rowData = new ArrayList<Object>();
			for(String c:columns) {
				rowData.add(rs.getObject(c));
			}
			data.add(rowData);
		}
		return data;
	}
	


}
