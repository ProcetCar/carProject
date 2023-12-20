package carProject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class User {
private  List<Product> orderedProducts=new ArrayList<Product>();
private String name;
private int id;
   private String email;
   private String password;
	private String type;
	private String age;
	private String Time;
	
	
	public User() {
	}
	
	public User(int id,String name,String email, String password , String type,String age,String Time) {
       this.id=id;
		this.name=name;
   	this.email = email;
       this.password = password;
       this.type = type;
       this.age=age;
this.Time=Time;
   }
	public String getTime() {

	       return Time;
	   }
public String getName() {

       return name;
   }
public void setType(String type) {
    this.type=type;		
	}
public int getid() {
    return id;
}
   
   public String getEmail() {
       return email;
   }
   
   
   public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setid(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Product> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List<Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	public String gettype() {
		return type;
	}
	public String getPassword() {
		return password;
	}


}

