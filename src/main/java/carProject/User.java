package carProject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class User {
private LOGIN lo=new LOGIN();
	  private  List<User> userList=new ArrayList<User>();  

private String name;
private int id;
   private String email;
   private String password;
	private String type;
	private String age;
	public User(int id,String name,String email, String password , String type,String age) {
       this.id=id;
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

	public  List<User> getUserList() {
		return userList;
	}
	public  void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<User> add(String username,String password,String email,String age,List<User> userList) {
         int i=countUsers(userList);
         
		if(lo.ifvalid(email)) {
        	  if(lo.checkIfRegister(email,userList)) {
        		  System.out.println(" you  alredy registerd ");  
            }
        	  else {    	  
        		  System.out.println(" you  register successfully");
    		userList.add(new User(i,username,email,password,"customer",age));	
        	  }
        	  }
          else {
        	  System.out.println("Invalid email. Please try again.");
          }
          setUserList(userList);
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
	public List<User> updateUser(List<User> userList,int id,String username,String email,String password,String age,String type) {

		       for (User user : userList) {
		             if (user.getid()==id) {
		            	 user.setName(username);
		            	 user.setEmail(email);
		            	 user.setAge(age);
		            	 user.setType(type);
		            	 user.setPassword(password);
		             }
		         }
		          setUserList(userList);
System.out.println("=======================updated successfully============");
		          return userList;
	}
	
	public void setType(String type) {
     this.type=type;		
	}
	
	
	
	public List<User> deleteuser(List<User> userList, int id) {
		int i=1;
		for (User user : userList) {
             if (user.getid()==id) {
            	 userList.remove(user);
            	 System.out.println("=======================deleted successfully============");

            	 break;
             }
         }
		 for (User user : userList) {
            user.setid(i);
            i++;
         }
         setUserList(userList);

		
		 return userList;
				}
	public void printUsers(List<User> userList) {
      	 System.out.println("==================================================================");

	     for (User user : userList) {

       //  String s=String.valueOf(user.getid())+". "+user.getName()+","+user.getEmail()+","+user.getAge()+","+user.gettype();
           // 	 System.out.println(s);
	     	 System.out.println("userId: "+user.getid());
	     	 System.out.println("username: "+user.getName());
        	 System.out.println("email: "+user.getEmail());
        	 System.out.println("password: "+user.getPassword());
        	 System.out.println("Age: "+user.getAge());
           	 System.out.println("==================================================================");

         }
       	 System.out.println("==================================================================");

}

	public int countUsers(List<User> userList) {
		int i=0;
		for (User user : userList) {
           i++;       
        }
		i++;
		return i;
	}
	public User informationUser(List<User> userList,String email) {
		

		for (User user : userList) {
            if (user.getEmail().equals(email)) {
            return user;	  
            
            }
            
        }
		return null;
	
	}
	public void searchuser(List<User> userList, String name) {
     	 System.out.println("==================================================================");

		for (User user : userList) {
            if (user.getName().equalsIgnoreCase(name)) {
   	     	 System.out.println("Id: "+user.getName());
            	 System.out.println("username: "+user.getName());
            	 System.out.println("email: "+user.getEmail());
            	 System.out.println("password: "+user.getPassword());
            	 System.out.println("Age: "+user.getAge());
            	 //System.out.println("Type: "+user.gettype());
            }
            
        }
     	 System.out.println("==================================================================");

	}

}

