/**
 * 
 */
package ih00264.com1028.assignment;

/**
 * @author imogen
 * Creates product object using product table
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
	public boolean equals(Object obj) { //used in testing to check if two objects in list of lists have the same attributes
	    if(this == obj) 
	    	return true;
	    
	    if(obj == null || obj.getClass()!= this.getClass()) 
	    	return false;
	    
	    Product product = (Product) obj;
	    if(product.getProductLine().equals(this.productLine) && product.getProductCode().equals(this.productCode) && product.getProductName().equals(this.productName)) 
	    	return true;
	    
	    return false;
	}
	

	
	@Override
	public int compareTo(Product p) { //used to sort list of payments in order of their product line
		if (getProductLine() == null || p.getProductLine() == null) {
		      return 0;
		}
		return getProductLine().compareTo(p.getProductLine());
	}
	
	

	@Override
	public String toString() {
		return String.format("|%-30s| %-20s| %-50s|", this.productLine, this.productCode, this.productName);

	}

}
