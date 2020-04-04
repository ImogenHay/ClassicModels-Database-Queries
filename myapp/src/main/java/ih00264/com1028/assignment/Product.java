/**
 * 
 */
package ih00264.com1028.assignment;

/**
 * @author imogen
 *
 */
public class Product implements Comparable<Product>{

	private String productLine;
	private String productCode;
	private String productName;
	
	
	/**
	 * @param productLine
	 * @param productCode
	 * @param productName
	 */
	public Product(String productLine, String productCode, String productName) {
		super();
		this.productLine = productLine;
		this.productCode = productCode;
		this.productName = productName;
	}

	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}


	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}


	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}


	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Override
	public int compareTo(Product arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "productLine=" + productLine + ", productCode=" + productCode + ", productName=" + productName;
	}

}
