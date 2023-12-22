package carProject;

import java.util.List;
import java.util.logging.Logger;

public class UserMethods {
	private LOGIN lo=new LOGIN();
        private static final Logger LOGGER = Logger.getLogger(UserMethods.class.getName());

	
public List<User> add(String username, String password, String email, String age, List<User> userList) {
        int i = countUsers(userList);
        
        if (lo.ifvalid(email)) {
            if (lo.checkIfRegister(email, userList)) {
                LOGGER.info("You already registered");
            } else {
                LOGGER.info("You registered successfully");
                userList.add(new User(i, username, email, password, "customer", age, ""));
            }
        } else {
            LOGGER.warning("Invalid email. Please try again.");
        }
        return userList;
    }
	
	
	public boolean isexsist(List<User> userlist, String username) {
		for (User user : userlist) {
           if (user.getName().equals(username)) {
               return true;
           }
       }
       return false;	
	}
public List<User> updateUser(List<User> userList, int id, String username, String email, String password, String age, String type) {
        for (User user : userList) {
            if (user.getid() == id) {
                user.setName(username);
                user.setEmail(email);
                user.setAge(age);
                user.setType(type);
                user.setPassword(password);
            }
        }
        LOGGER.info("Updated successfully");
        return userList;
    }
	
	public boolean isexsist(List<User> userlist, int id) {
		for (User user : userlist) {
           if (user.getid()==id) {
               return true;
           }
       }
       return false;	
	}
	
	public int id_installer(List<User> userlist,String Time) {
		for (User user : userlist) {
           if (user.gettype().equals("installer")) {
        	   if(user.getTime().equals(Time)) {
               return user.getid();
           }
           }
       }
       return 0;	
	}
	

	
	
	
	public List<User> deleteuser(List<User> userList, int id) {
        int i = 1;
        for (User user : userList) {
            if (user.getid() == id) {
                userList.remove(user);
                LOGGER.info("Deleted successfully");
                break;
            }
        }
        for (User user : userList) {
            user.setid(i);
            i++;
        }
        return userList;
    }
  public void printUsers(List<User> userList) {
        LOGGER.info("==================================================================");
        for (User user : userList) {
            LOGGER.info("UserId: " + user.getid() + ", Username: " + user.getName() +
                        ", Email: " + user.getEmail() + ", Password: " + user.getPassword() +
                        ", Age: " + user.getAge());
        }
        LOGGER.info("==================================================================");
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
