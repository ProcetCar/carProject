 package carProject;

import java.util.ArrayList;
import java.util.List;

public class Mydata {
	public static   List<User> userList=new ArrayList<User>();
	 public static List<Product> products = new ArrayList<Product>();

 	public  List<User> getUserList() {
		return userList;
	}

	public  void setUserList(List<User> userList) {
		Mydata.userList = userList;
	}





	
	public static   List<User> listUser(){
		
	    userList.add(new User(1,"Lama","sheehasamah6@gmail.com", "password1" ,"customer", "18",""));
	    userList.add(new User(7,"Lama","example1@gmail.com", "password1" ,"customer", "18",""));
        userList.add(new User(2,"Ibtissam","example2@gmail.com", "password2" ,"installer", "27","1-2"));
        userList.add(new User(3,"Sami","example3@gmail.com", "password3" ,"Admin"," 21",""));
        userList.add(new User(4,"Sami","sheehasamah6@gmail.com", "password4" ,"customer"," 21",""));
        userList.add(new User(5,"ala","example5@gmail.com", "password5" ,"installer", "27","2-3"));
        userList.add(new User(6,"eba","example6@gmail.com", "password6" ,"installer", "27","3-4"));


            return userList;
       }


	
	public static   List<Product> listProduct(){

	        products.add(new Product(1,"Car Seat Cover",
	                "High-quality seat cover for cars",
	                49.99,
	                "Interior",
	                "available",
	                "C:\\Users\\SYSCOM/Desktop/carImages/1.png"));

	        products.add(new Product(2,"Car GPS Navigation System",
	                "Advanced GPS navigation system for cars",
	                199.99,
	                "Electronics",
	                "available",
	                "C:\\Users\\SYSCOM/Desktop/carImages/2.jpg"));

	        products.add(new Product(3,"Alloy Wheels",
	                "Set of 4 stylish alloy wheels",
	                249.99,
	                "Exterior",
	                "not available",
	                "C:\\Users\\SYSCOM/Desktop/carImages/3.png"));	        

	        products.add(new Product(4,"Car Audio System",
	                "Premium car audio system with Bluetooth connectivity",
	                299.99,
	                "Electronics",
	                "available",
	                "C:\\Users\\SYSCOM/Desktop/carImages/4.jpg"));

	        return products;
	    }







}
