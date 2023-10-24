package carProject;

import java.util.ArrayList;
import java.util.List;


public class User {
   static List<User> userList = new ArrayList<User>();
   private String name;
   private String email;
   private String password;
	private String type;
	private String age;
	public User(String name,String email, String password , String type,String age) {
       this.name=name;
   	this.email = email;
       this.password = password;
       this.type = type;
       this.age=age;
       
   }
   public String getName() {
       return name;
   }
  
   
   public String getEmail() {
       return email;
   }
   
   

	public static List<User> list(){
    	 userList.add(new User("Lama","example1@example.com", "password1" ,"customer", "18"));
         userList.add(new User("Ibtissam","example2@example.com", "password2" ,"installer", "27"));
         userList.add(new User("Sami","example3@example.com", "password3" ,"Admin"," 21"));
         
             return userList;
        }
	public String gettype() {
		return type;
	}
	public String getPassword() {
		return password;
	}

}

