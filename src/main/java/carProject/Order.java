package carProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {
	private int orderid;
    private List<Product> orderedProducts=new ArrayList<Product>();
    private String orderStatus;
    private Date date;
    private int customerid;
    private String city ;
    private String street ;
    private String email;
    private int installer;

	public int getOrderid() {
		return orderid;
	}
	
	
	public int getCustomerid() {
		return customerid;
	}
		public String getCity() {
		return city;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getEmail() {
		return email;
	}
	
	
	public void setInstaller(int installer) {
		this.installer = installer;
	}
	public Date getOrderDate() {
		return date;
	}
		public int getCustomerId() {
		return customerid;
	}
	
	

    
    
    
    public Order(int orderid, int customerid, List<Product> orderedProducts, String email, Date date, String city,
			String street, String orderStatus,int installer ) {
    	
    	this.orderid=orderid;
    	this.customerid=customerid;
    	this.orderedProducts=orderedProducts;
    	this.date=date;
    	this.city=city;
    	this.street=street;
    	this.orderStatus=orderStatus;
    	this.email=email;
    	this.installer=installer;
	}
	public Order() {
	}
	
	public List<Product> getOrderedProducts() {
		return orderedProducts;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public void setDate(Date date) {
     this.date=date;		
	}



	
	
	
	}
