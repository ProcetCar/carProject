package carProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewOrderSteps {
Order order=new Order();
List<Order> request=new ArrayList<Order>();

@When("when chose view order")
public void when_chose_view_order() {
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
     request.add(order);
      
}

@Then("print  orders")
public void print_orders() {
OrderedMethods.vieworder(request);

  
}
}
