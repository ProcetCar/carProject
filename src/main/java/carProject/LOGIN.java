package carProject;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class LOGIN {
	    private String enteredEmail;
	    private String enteredPassword;
	    private static String tyu = "";
		 private static Mydata data=new Mydata();
		  private static  List<User> userlist=new ArrayList<User>();

	public boolean run(int p) {
        return p == 1;
    }

	public void navigateToLoginPage(String email, String password,List<User> userlist) {
		   enteredPassword=password;
      	  enteredEmail=email;
      	  
      		 
      	    if (performLogin(enteredEmail, enteredPassword,userlist)) {
      	    	System.out.println("Login successful.");
      	    	System.out.println("\n");
      	    	System.out.println("\n");
      	    }
      	    else {
      	    	System.out.println("Invalid email or password. Please try again.");
      	    
      	    }
      	  
         
	}

	public boolean performLogin(String email, String password,List<User> userlist) {
		
		  for (User userr : userlist) {
	            if (userr.getEmail().equals(email) && userr.getPassword().equals(password)  ) {
	                tyu = userr.gettype();
	                return true;
	               
	            }
	        }
	        return false;
	}

	  public boolean getA() {
	        return tyu.equals("Admin");
	    }

	    
	    public boolean geti() {
	        return tyu.equals("installer");
	    }

	    
	    public boolean getc() {
	        return tyu.equals("customer");
	    }

		public boolean checkIfRegister(String email,List<User> userlist) {
			for (User userr : userlist) {
	            if (userr.getEmail().equals(email)) {
	                return true;
	            }
	        }
			return false;
			
			
		}
		

		public boolean ifvalid(String string) {
			if(string.equals("") || !string.contains("@gmail.com") ){
				System.out.println("invalid email please try again...");
				return false;
			}
			return true;
			
		}

	}



