package carProject;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;




public class Main {
	 static Logger logger =  Logger.getLogger(Main.class.getName());
	  static LOGIN login=new LOGIN();
	  private static Mydata data=new Mydata();
	  private static  List<User> userList=Mydata.listUser();
	  private static User user=new User();

	public static void main(String[] args) {
		logger.info("Welcome to the Application!");
	    logger.info("Please select an option:");
	    logger.info("1. Login");
	    logger.info("2. Logout");
	    logger.info("3. signup");
		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		if(p==1) {
			logger.info("Navigating to the login page...");
			logger.info("            === Login Page ===");
			logger.info("- Please enter your email and password:");
			logger.info("Email: ");
	 	    String m=scanner.nextLine();
	          m=scanner.nextLine();
	     logger.info("Password: ");
		    String z=scanner.nextLine();
			login.navigateToLoginPage(m,z);
		}
		if(p==2) {
			logger.info("you logout successfully");
			logger.info("Navigating to the login page...");
			logger.info("            === Login Page ===");
			logger.info("- Please enter your email and password:");
			logger.info("Email: ");
	 	    String m=scanner.nextLine();
	          m=scanner.nextLine();
	     logger.info("Password: ");
		    String z=scanner.nextLine();
			login.navigateToLoginPage(m,z);

		}
		if(p==3) {
			logger.info("Navigating to the signup page...");
			logger.info("            === signup Page ===");
			logger.info("- Please enter your username and email and password and age :");
			logger.info("username: ");
	 	    String username=scanner.nextLine();
	          username=scanner.nextLine();
	     logger.info("email: ");
		    String email=scanner.nextLine();
		    logger.info("password: ");
		    String password=scanner.nextLine();
		    logger.info("age: ");
		    String age=scanner.nextLine();
	  userList= user.add(username, password, email, age);	    
	}

}

	
}
