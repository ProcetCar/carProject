package carProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private int orderId;
    private List<Product> orderedProducts=new ArrayList<Product>();
    private OrderStatus orderStatus;
    private Date orderDate;
    private String customerName;
    private double totalAmount;
    
    
    
    
    public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List<Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int countorder(List<Product> orderedProducts) {
		int i=0;
		for(Product prduct: orderedProducts) {
			i++;
		}
		return i+1;
	}
	public double searchorder(String productpurchase, List<Product> orderedProducts) {
            for (Product product:orderedProducts) {
	             if(product.getName().equals(productpurchase)) {
	            	 return product.getPrice();
	            	 }
                      }
		return 0;
	}
}