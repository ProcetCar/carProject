package carProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SendEmailSteps {
	 Order order=new Order();

@When("order is complete")
public void order_is_complete() {
    List<Product> productlist=new ArrayList <Product>();

	 int customerid = 1;
     int orderid = 1;
     String email="sheehasamah6@gmail.com";
     String city="nablus";
     String street="rafidia";
     String r="C:\\Users\\SYSCOM/Desktop/carImages/4.jpg";
      productlist.add(new Product(2,"Car GPS Navigation System",
             "Advanced GPS navigation system for cars",
             199.99,
             "Electronics",
             "available",r));;
     Date currentDate = new Date();
       order=new Order(orderid,customerid,productlist,email,currentDate,city,street,"pending",2);
      
      

}

@Then("Send email")
public void send_email() {
boolean f=OrderedMethods.ifAvailable(order);
if(f) {
//SendMail.getSendEmail("order is complete", "sheehasamah6@gmail.com"); 

}
Assert.assertTrue(f);


}

@When("order isn't complete")
public void order_isn_t_complete() {
    List<Product> productlist=new ArrayList <Product>();

	 int customerid = 1;
     int orderid = 1;
     String email="sheehasamah6@gmail.com";
     String city="nablus";
     String street="rafidia";
String r="C:\\Users\\SYSCOM/Desktop/carImages/4.jpg";
     productlist.add(new Product(3,"Alloy Wheels",
             "Set of 4 stylish alloy wheels",
             249.99,
             "Exterior",
             "not available",r));
     Date currentDate = new Date();
      order=new Order(orderid,customerid,productlist,email,currentDate,city,street,"pending",2);
      
      

   
}

@Then("Send email order not complete")
public void send_email_order_not_complete() {
	boolean f=OrderedMethods.ifAvailable(order);
	if(!f) {
	//SendMail.getSendEmail("order not complete", "sheehasamah6@gmail.com"); 

	}
	Assert.assertFalse(f);
}



}
