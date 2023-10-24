package carProject;


import java.util.List;
import java.util.logging.Logger;



public class LOGIN {
	    private String enteredEmail;
	    private String enteredPassword;
	    private static String tyu = "";
		 static Logger logger =  Logger.getLogger(LOGIN.class.getName());
		   private  List<User> userlist=User.list();

	public boolean run(int p) {
        return p == 1;
    }

	public void navigateToLoginPage(String email, String password) {
		   enteredPassword=password;
      	  enteredEmail=email;
      	    if (performLogin(enteredEmail, enteredPassword)) {
      	        logger.info("Login successful.");
      	       logger.info("\n");
      	      logger.info("\n");
      	    } else {
      	    	logger.info("Invalid email or password. Please try again.");
      	    }
         
	}

	public boolean performLogin(String email, String password) {
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

		public boolean checkIfRegister(String email) {
			for (User userr : userlist) {
	            if (userr.getEmail().equals(email)) {
	                return true;
	            }
	        }
			return false;
			
			
		}
		

		public boolean ifvalid(String string) {
			if(string.equals("")){
				return false;
			}
			return true;
			
		}

	}



