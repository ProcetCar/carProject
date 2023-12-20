package carProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstallationRequestsSteps {

	private Order order=new Order();
	private static  UserMethods um=new UserMethods() ;
    private List<Product> productlist=Mydata.listProduct();
    List<Order> request=new ArrayList<Order>();
    private List<Product> ProductsInchart=new ArrayList<Product>();
    private List<Order>  orderdproduct=new ArrayList<Order>();
	private static  ProductMethods pm=new ProductMethods() ;
    Product product=new Product();
    boolean available=false;
	@Given("the customer wants to request installation services")
	public void the_customer_wants_to_request_installation_services() {
	   
	}

	@When("they fill out the installation request form")
	public void they_fill_out_the_installation_request_form(List<Map<String, String>> dataTable) {
		for (Map<String, String> row : dataTable) {
           int productid = Integer.valueOf(row.get("Productid"));
           int customerid = Integer.valueOf(row.get("customerid"));
           int orderid = Integer.valueOf(row.get("orderid"));
           String email=row.get("email");
           String city=row.get("city");
           String street=row.get("street");
           product = pm.informationProduct(productlist, productid);
           ProductsInchart.add(product); 
           Date currentDate = new Date();
           order=new Order(orderid,customerid,ProductsInchart,email,currentDate,city,street,"PENDING",2);
            request.add(order);
       }	

	    
	}

	@Then("the request should be submitted successfully")
	public void the_request_should_be_submitted_successfully() {
		orderdproduct.add(order);
		OrderedMethods.vieworder(request);

	   
	}

	@Given("the installer is available for appointments")
	public void the_installer_is_available_for_appointments() {
	   
	}

	@When("they review the installation requests")
	public void they_review_the_installation_requests() {
	    available=OrderedMethods.ifAvailable(order);
	    order=OrderedMethods.changeStatus(order,available);
	    
		
	}

	@When("they schedule an appointment for the customer")
	public void they_schedule_an_appointment_for_the_customer() {
		
	   
	}

	@Then("the appointment should be confirmed")
	public void the_appointment_should_be_confirmed() {
		Assert.assertEquals(order.getOrderStatus(),"coniformed" );
	    
	}

	@Given("the installer is not available for appointments")
	public void the_installer_is_not_available_for_appointments() {
	   
	}
	@When("they fill out the installation requests form")
	public void they_fill_out_the_installation_requests_form(List<Map<String, String>> dataTable) {
		for (Map<String, String> row : dataTable) {
	           int productid = Integer.valueOf(row.get("Productid"));
	           int customerid = Integer.valueOf(row.get("customerid"));
	           int orderid = Integer.valueOf(row.get("orderid"));
	           String email=row.get("email");
	           String city=row.get("city");
	           String street=row.get("street");
	           product = pm.informationProduct(productlist, productid);
	           ProductsInchart.add(product); 
	           Date currentDate = new Date();
	           order=new Order(orderid,customerid,ProductsInchart,email,currentDate,city,street,"PENDING",2);
	           available=OrderedMethods.ifAvailable(order);
	   	      order=OrderedMethods.changeStatus(order,available);
	       }
	}

	@Then("the appointment should be canceled")
	public void the_appointment_should_be_canceled() {
		Assert.assertEquals(order.getOrderStatus(),"canceled" );

	}
	}

