package carProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOrdersteps {
Order order=new Order();
List<Order> request=new ArrayList<Order>();

	@When("order is available")
	public void order_is_available() {
		request=new ArrayList<Order>();
		 List<Product> productlist=new ArrayList <Product>();

		 int customerid = 1;
	     int orderid = 1;
	     String email="sheehasamah6@gmail.com";
	     String city="nablus";
	     String street="rafidia";
         String s="C:\\Users\\SYSCOM/Desktop/carImages/4.jpg";

	      productlist.add(new Product(2,"Car GPS Navigation System",
	             "Advanced GPS navigation system for cars",
	             199.99,
	             "Electronics",
	             "available",s));;
	     Date currentDate = new Date();
	       order=new Order(orderid,customerid,productlist,email,currentDate,city,street,"pending",2);
         request.add(order);	      
	}

	@Then("change state {string}")
	public void change_state(String string) {

  order=OrderedMethods.changeStatus(order,true); 
  Assert.assertEquals(order.getOrderStatus(), string);
	OrderedMethods.vieworder(request);

	}

	@When("order not available")
	public void order_not_available() {
		List<Product> productlist=new ArrayList <Product>();
		request=new ArrayList<Order>();
		 int customerid = 1;
	     int orderid = 2;
	     String email="sheehasamah6@gmail.com";
	     String city="nablus";
	     String street="rafidia";
         String s="C:\\Users\\SYSCOM/Desktop/carImages/4.jpg";

	     productlist.add(new Product(3,"Alloy Wheels",
	             "Set of 4 stylish alloy wheels",
	             249.99,
	             "Exterior",
	             "not available",s));
	     Date currentDate = new Date();
	      order=new Order(orderid,customerid,productlist,email,currentDate,city,street,"pending",2);
	      request.add(order);

	}
	@Then("change state order {string}")
	public void change_state_order(String string) {
		
		order=OrderedMethods.changeStatus(order,false); 
		  Assert.assertEquals(order.getOrderStatus(), string);
			OrderedMethods.vieworder(request);

	}
}
