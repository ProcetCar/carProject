package carProject;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerRolesteps {
    private List<Product> orderedProducts=new ArrayList<Product>();
	private static UserMethods um=new UserMethods();
	  private static  List<User> userList=Mydata.listUser();
	  private static  ProductMethods pc=new ProductMethods() ;
	private static  List<Product> productlist=Mydata.listProduct();
	List<Product> productlist2,productlist3;
	private static User user=new User();

	private static Order order=new Order();

	String s1,s2,add,buy,productpurchase;
	String email1,email2;
String type;
@Given("the user is on the homepage")
public void the_user_is_on_the_homepage() {
	
}

@Given("the user is logged in as a customer")
public void the_user_is_logged_in_as_a_customer() {
	type= "customer";
    }

@When("they click on the {string} option")
public void they_click_on_the_option(String string) {
   
}

@Then("they should see a list of product categories")
public void they_should_see_a_list_of_product_categories() {
	String[] cate = new String[3];

	cate=pc.printcategory(productlist);
	String []cate2= {"Electronics","Interior","Exterior"};
	Assert.assertArrayEquals(cate, cate2);

  
}


@Then("they can click on a category to view products within that category {string}")
public void they_can_click_on_a_category_to_view_products_within_that_category(String string) {

	pc.viewproductCategory(productlist,string);
    
}

@Given("the user is browsing product categories")
public void the_user_is_browsing_product_categories() {
  
}

@When("they click on a product to view its details")
public void they_click_on_a_product_to_view_its_details() {
 
}

@Then("they should see detailed product information")
public void they_should_see_detailed_product_information() {
	pc.printproducts(productlist);
	List<Product> productlist5=new ArrayList<Product>();
productlist=Mydata.listProduct();
productlist5=Mydata.listProduct();

      boolean areEqual =true;
      if (productlist.size() != productlist5.size()) {
    	    areEqual = true;
    	} else {
    	    for (int i = 0; i < productlist.size(); i++) {
    	        if (!productlist.get(i).equals(productlist5.get(i))) {
    	            areEqual = false;
    	            break;  
    	        }
    	    }
    	}
      Assert.assertTrue(areEqual);
pc.printproducts(productlist5);
}

@When("they use the search and filter options {string}")
public void they_use_the_search_and_filter_options(String string) {
     productlist2=new ArrayList<Product>();

	productlist2=pc.searchcategory(productlist,string);
	for (Product product : productlist2) {
        if(product.getCategory().equals(string)) {
          s1=product.getName();
}
  
}
}

@When("the following details:")
public void the_following_details(List<Map<String, String>> dataTable) {
	 for (Map<String, String> row : dataTable) {
           String productName = row.get("Product Name");
         String description = row.get("Description");
         String price = row.get("Price");
         String category = row.get("category");
         String available = row.get("available");
         s2=productName;
         String r="C:\\Users\\SYSCOM/Desktop/carImages/4.jpg";
         Product e=new Product(1,productName,description,Double.valueOf(price),category,available,r);
         productlist3=new ArrayList<Product>();

         productlist3.add(e);

	 } 
}

@Then("they should be able to find products matching their ctegory")
public void they_should_be_able_to_find_products_matching_their_ctegory() {
   Assert.assertEquals(s1,s2);
}

@Given("the user is viewing product details {string}")
public void the_user_is_viewing_product_details(String name) {
	productpurchase=name;
   
}


@When("they click on the {string} or {string} button")
public void they_click_on_the_or_button(String string, String string2) {
	add=string;
	buy=string2;
    
}

@Then("they should be able to make a purchase")
public void they_should_be_able_to_make_a_purchase() {

	
	int i=OrderedMethods.countorder(orderedProducts);
	Product e =new Product() ;
	e=pc.informationProduct(productlist, 1);
		orderedProducts.add(e);
               

		double price=OrderedMethods.searchorder(productpurchase,orderedProducts);
		String s=String.valueOf(price);
	Assert.assertEquals(s,"49.99");
		
	
   
}

@Then("they should receive an order confirmation")
public void they_should_receive_an_order_confirmation() {
   
}

@Given("the user has made a purchase")
public void the_user_has_made_a_purchase() {
  
}


@When("they navigate to their profile and click on Ordr History")
public void they_navigate_to_their_profile_and_click_on_ordr_history() {
    
}



@Then("they should see a list of their past orders")
public void they_should_see_a_list_of_their_past_orders() {
    
}
@Given("the user is viewing product details")
public void the_user_is_viewing_product_details() {
    
}
@When("they click on the {string} button")
public void they_click_on_the_button(String string) {
  
}

@When("they provide installation details {string} and {string}")
public void they_provide_installation_details_and(String string, String string2) {
  
}

@Then("they should be able to submit an installation request")
public void they_should_be_able_to_submit_an_installation_request() {
   
}

@Then("they should receive a confirmation of their request")
public void they_should_receive_a_confirmation_of_their_request() {
    
}

@When("they navigate to their profile {string}")
public void they_navigate_to_their_profile(String string) {
    email1=string;
    
}

@When("they make changes email {string}")
public void they_make_changes_email(String string) {
    email2=string;
    
}

@When("click {string}")
public void click(String string) {
	user=um.informationUser(userList, email1);

	userList=um.updateUser(userList,1, user.getName(),email2, user.getPassword(), user.getAge(), user.gettype());
}

@Then("their profile information should be updated successfully")
public void their_profile_information_should_be_updated_successfully() {
	user=um.informationUser(userList, email2);
	um.searchuser(userList, user.getName());
	Assert.assertEquals(user.getEmail(), email2);
    
}

}
