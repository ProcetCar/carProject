package carProject;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Addproductsteps {
	private static  List<Product> productlist=Mydata.listProduct();
	private static ProductMethods pc=new ProductMethods();
	  String productName;
	@Given("the admin is logged in and has access to the system")
	public void the_admin_is_logged_in_and_has_access_to_the_system() {
	    
	}

	@When("the admin adds a new product with the following information:")
	public void the_admin_adds_a_new_product_with_the_following_information(List<Map<String, String>> dataTable) {

		for (Map<String, String> row : dataTable) {
	             productName = row.get("Product Name");
	            String description = row.get("Description");
	            String price = row.get("Price");
	            String category = row.get("category");
	            String available = row.get("available");
	           int i= pc.countProducts(productlist);
	           String s="C:\\Users\\SYSCOM/Desktop/carImages/4.jpg";
         Product p=new Product(i,productName,description,Double.valueOf(price),category,available,s);
     		productlist.add(p);

	           
	        }
	}

	@Then("the product should be added")
	public void the_product_should_be_added() {
		boolean g=pc.isexsist(productlist,productName);
	     Assert.assertTrue(g);
	   pc.printproducts(productlist);
	}

}
