package carProject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class User {
private LOGIN lo=new LOGIN();
   private static Mydata data=new Mydata();
	  private static  List<User> userList=Mydata.listUser();  
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
   public User() {
	}
public String getName() {
       return name;
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
	public void setPassword(String password) {
		this.password = password;
	}


	public List<User> add(String username,String password,String email,String age) {
        Logger logger =  Logger.getLogger(User.class.getName());
          if(lo.ifvalid(email)) {
        	  if(lo.checkIfRegister(email)) {
              logger.info(" you  alredy registerd ");  
            }
        	  else {    	  
            logger.info(" you  register successfully");
    		userList.add(new User(username,email,password,"customer",age));	
        	  }
        	  }
          else {
          	logger.info("Invalid email. Please try again.");
          }
         data.setUserList(userList);
	      return userList;

}
	
	public String gettype() {
		return type;
	}
	public String getPassword() {
		return password;
	}
	public boolean isexsist(List<User> userlist, String username) {
		for (User user : userlist) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;	
	}
	public List<User> updateUser(List<User> userlist,String username,String email,String password,String age,String type) {

		       for (User user : userlist) {
		             if (user.getName().equals(username)) {
		            	 user.setName(username);
		            	 user.setEmail(email);
		            	 user.setAge(age);
		            	 user.setType(type);
		            	 user.setPassword(password);
		             }
		         }
		          return userlist;
	}
	
	public void setType(String type) {
     this.type=type;		
	}
	public List<User> deleteuser(List<User> userlist, String string) {
		 for (User user : userlist) {
             if (user.getName().equals(string)) {
            	 userlist.remove(user);
            	 break;
             }
         }
				return userlist;
				}
	public void printUsers(List<User> userlist) {
	     for (User user : userlist) {

         String s=user.getName()+","+user.getEmail()+","+user.getAge()+","+user.gettype();
            	 System.out.println(s);
             
         }
}
	
	
	}



