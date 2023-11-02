package carProject;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class AdminRoleSteps {
	
	private static  List<User> userlist=Mydata.listUser();
	private static  List<Product> productlist=Mydata.listProduct();
	private static ProductCatalog pc=new ProductCatalog();
	private static User user=new User();
	String manageProducts,managecategory,mangeuser;
	String productname="Product A";
    String description="This is Product A";
    double price=50.0;
    String category="Interior";
    String available="available";
String email,username,password,age,type;
Product product=new Product();
	@When("the admin selects the {string} option")
	public void the_admin_selects_the_option(String string) {
		manageProducts=string;
	}

	@When("the admin adds a new product with the following details:")
	public void the_admin_adds_a_new_product_with_the_following_details(List<Map<String, String>> dataTable) {

		for (Map<String, String> row : dataTable) {
	            String productName = row.get("Product Name");
	            String description = row.get("Description");
	            String price = row.get("Price");
	            String category = row.get("category");
	            String available = row.get("available");
	           int i= pc.countProducts(productlist);
         Product p=new Product(i,productName,description,Double.valueOf(price),category,available);
     		productlist.add(p);

	           
	        }

		
	}

	@Then("the product should be added successfully")
	public void the_product_should_be_added_successfully() {
	boolean g=pc.isexsist(productlist,productname);
     Assert.assertTrue(g);
	}

	@Then("the admin updates the product {string} with the following details:")
	public void the_admin_updates_the_product_with_the_following_details(String string, List<Map<String, String>> dataTable) {
	
		 for (Map<String, String> row : dataTable) {
	             description = row.get("Description");
	             price = Double.valueOf(row.get("Price"));
 
      }
		 productlist=pc.updateproducts(productlist,5,string,description,price,category,available);
		 String description2 ="";
		  String price2 ="";
		   for (Product product : productlist) {
	           if (product.getName().equalsIgnoreCase(productname)) {
	        	   description2 = product.getDescription();
	        	   price2=  String.valueOf(product.getPrice());
	        	   }
	       }

		  Assert.assertEquals(description2,"Updated Description");
		 Assert.assertEquals(price2,"60.0");

	           
	        }
	   

	@Then("the product should be updated successfully")
	public void the_product_should_be_updated_successfully() {
	System.out.println("updated successfully");
	}

	@Then("the admin deletes the product {string}")
	public void the_admin_deletes_the_product(String string) {
	productlist=pc.deleteproducts(productlist,5);   
	}

	@Then("the product {string} should be deleted successfully")
	public void the_product_should_be_deleted_successfully(String string) {
		Assert.assertFalse(pc.isexsist(productlist, string));
	
	}

	@When("the admin deletes the category {string}")
	public void the_admin_deletes_the_category(String string) {

	productlist=pc.deletecategory(productlist,string);

	}

	@Then("the category should be deleted successfully")
	public void the_category_should_be_deleted_successfully() {
	Assert.assertFalse(pc.isexsist(productlist,"Exterior"));
	}

	@When("the admin adds a new user account with the following details:")
	public void the_admin_adds_a_new_user_account_with_the_following_details(List<Map<String, String>> dataTable) {
		 for (Map<String, String> row : dataTable) {
             username=  row.get("Username");
              email=row.get("Email");
             password = row.get("password");
            type=row.get("type");
            age=row.get("age");
	}
		int i= user.countUsers(userlist);
		 User e=new User(i,username,email,password,type,age);
		userlist.add(e);
		
	}

	@Then("the user account should be added successfully")
	public void the_user_account_should_be_added_successfully() {
	  Assert.assertTrue(user.isexsist(userlist,username));
	}

	@Then("the admin updates the user account {string} with the following details:")
	public void the_admin_updates_the_user_account_with_the_following_details(String string, List<Map<String, String>> dataTable) {
		for (Map<String, String> row : dataTable) {
             email=row.get("Email");
	}
		userlist=user.updateUser(userlist,4,string,email,password,age,type);
		
	
	}

	@Then("the user account should be updated successfully")
	public void the_user_account_should_be_updated_successfully() {
		
		String updateEmail ="";
		   for (User user : userlist) {
	           if (user.getName().equals(username)) {
	        	   updateEmail = user.getEmail();
	        	   }
	       }
		  
    Assert.assertEquals(updateEmail,"updated@example.com");	
	         
	       
    }

	@Then("the admin deletes the user account {string}")
	public void the_admin_deletes_the_user_account(String string) {
		userlist=user.deleteuser(userlist,4);
	}

	@Then("the user account should be deleted successfully")
	public void the_user_account_should_be_deleted_successfully() {	
		Assert.assertFalse(user.isexsist(userlist, username));
	}
	
}
