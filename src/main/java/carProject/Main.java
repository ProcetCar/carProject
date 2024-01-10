package carProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;





public class Main {


	
	  static LOGIN login=new LOGIN();
	  private static  List<User> userList=Mydata.listUser();
	  private static  ProductMethods pm=new ProductMethods() ;
	  private static  UserMethods um=new UserMethods() ;
	  private static  OrderedMethods om=new OrderedMethods();
	private static  List<Product> productlist=Mydata.listProduct();
    private static List<Product> orderedProducts=new ArrayList<>();
    private static List<Order> request=new ArrayList<>();

	private static User user=new User();
     private static Product product =new Product ();
	 static Logger logger =  LogManager.getLogger(Main.class);
	 
private static final String SEPARATOR = "===============================================================";


public static void print1(int flag){
    
  			
                    logger.info("Navigating to the product page...");
					logger.info("            === product page ===");
					if(flag==1) {
					pm.printproducts(productlist);
					}
					logger.info(" select an option:");
					logger.info("1. To view a specific product");
					logger.info("2. Go to Home Page");
    				logger.info(SEPARATOR);

              Scanner scanner = new Scanner(System.in);
				     int k=scanner.nextInt();
                          if(k==1) {
          					logger.info("enter the product number");
          					scanner=new Scanner(System.in);
       				         int y=scanner.nextInt();
            				logger.info(SEPARATOR);
                          
      logger.info("- select an option:-");
					logger.info("1. add to my chart");
					logger.info("2. Back to Home page");
                                            logger.info(SEPARATOR);
     					scanner=new Scanner(System.in);
  				        int b =scanner.nextInt();
  				         if(b==1) {
  				        	 
  				        	logger.info("Navigating to the add to chart page...");
  							logger.info("            === add to chart page ===");
  		    				logger.info(SEPARATOR);
                             
  				        	product=pm.informationProduct(productlist,y );
  				        	orderedProducts.add(product);
  				        	user.setOrderedProducts(orderedProducts);
  				        	pm.countProducts(orderedProducts);
  				        	double total=pm.totalprice(orderedProducts);
  				        	  
				        	print2(product.getPrice(),total);
				        	logger.info(SEPARATOR);
				        	logger.info(SEPARATOR);
				        	 logger.info("Please select an option:");
								logger.info("1. make purchase");
								logger.info("2. go to home page");
			   				logger.info(SEPARATOR);

								scanner=new Scanner(System.in);
							        int u =scanner.nextInt();
							        if(u==1) {
							        	logger.info(SEPARATOR);

					  				     logger.info("Please enter you email ,city ,street");
							        	logger.info(" email : ");
									   String Email4=getNextLine(scanner);
									    Email4=getNextLine(scanner);
									    while(!login.ifvalid(Email4)) {
							 		    	 logger.info("Email : ");
							 		    	Email4=getNextLine(scanner); 
							 		     }
									   logger.info("city: ");
									   String city=getNextLine(scanner);
									   logger.info("street: ");
									   String street=getNextLine(scanner);
									   Date date=new Date();
									   int id2= om.count(request);
					  				  logger.info("chose time: 1-2 , 2-3 , 3-4");
					  				logger.info("Time: ");
									   String Time1=getNextLine(scanner);
									   int installer=um.id_installer(userList,Time1);
									  Order order=new Order(id2,user.getid(),orderedProducts,Email4,date,city,street,"pending",installer);
									  
									  request.add(order);
									 
									  String status="order is "+order.getOrderStatus();
									  SendMail.getSendEmail(status, Email4); 
							        	logger.info(SEPARATOR);
										orderedProducts=new ArrayList<>();

							        } 
  				         }
                          }
					


}
	public static void main(String[] args) {

    
		String name,email,password,age;
       boolean islogin=false;
      boolean notexit=true;
       
    
       
       

       while(notexit) {
       logger.info(SEPARATOR);

		logger.info("Welcome to the Application!");
		logger.info("Please select an option:");
		logger.info("1. Login");
		logger.info("2. signup");
	       	logger.info("3. exit");

		logger.info(SEPARATOR);

		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		if(p==1) {
			logger.info(SEPARATOR);

			logger.info("Navigating to the login page...");
			logger.info("            === Login Page ===");
			logger.info("- Please enter your email and password:");
			logger.info(SEPARATOR);
			
			logger.info("Email: ");
	 	    email=getNextLine(scanner);
	          email=getNextLine(scanner);
	          while(!login.ifvalid(email)) {
	 		    	 logger.info("email: ");
	 			     email=getNextLine(scanner); 
	 		     }
	          logger.info("Password: ");
		     password=getNextLine(scanner);
			login.navigateToLoginPage(email,password,userList);
			while(!login.performLogin(email, password,userList)) {
				logger.info("Email: ");
		 	    email=getNextLine(scanner);
		          logger.info("Password: ");
			     password=getNextLine(scanner);
			}
			islogin=true;
			user=um.informationUser(userList, email) ;
			orderedProducts=new ArrayList<>();
			
			if(user.gettype().equals("customer")) {
			while(login.performLogin(email, password,userList)&&islogin) {
		logger.info(SEPARATOR);
				logger.info("you login as customer");
		logger.info(SEPARATOR);

				logger.info("Navigating to the home page...");
				logger.info("            === Home page ===");
				logger.info("Please select an option:");
				logger.info("1. view all products");
				logger.info("2. view products category");
				logger.info("3. search about product you want");
				logger.info("4. view your profile");
				logger.info("5. view your request orders");
				logger.info("6. logout");

				logger.info(SEPARATOR);

				 scanner=new Scanner(System.in);
			     int d=scanner.nextInt();
				if(d==1) {
				
                               print1(1);
					
				}
				if(d==2){
			  logger.info(SEPARATOR);
				String[] cate = pm.printcategory(productlist);
				logger.info("Please select an option:");
					logger.info("1. view product in specific catogery");
					logger.info("2. go to home page");
				logger.info(SEPARATOR);
				scanner=new Scanner(System.in);
		        int a1 =scanner.nextInt();
		        if(a1==1) {
					logger.info("enter category number");
							        
				scanner=new Scanner(System.in);
				        int b =scanner.nextInt();
				        
				        if(b==1) {
				        	pm.viewproductCategory(productlist, "Electronics");
				        	
				        }
				        if(b==2) {
				        	pm.viewproductCategory(productlist, "Interior");
				        }
				        if(b==3) {
				        	pm.viewproductCategory(productlist, "Exterior");

				        }
			             print1(2);
		        }

				        


				}
				if(d==3) {
	    				logger.info(SEPARATOR);

				logger.info("enter the product name: ");

					
					scanner=new Scanner(System.in);
					 String nameproduct=getNextLine(scanner);	
					 if(pm.isexsist(productlist, nameproduct)) {
					int id= pm.searchproductname(productlist,nameproduct);
    				logger.info(SEPARATOR);

                                 logger.info("Please select an option:");
					logger.info("1. add to my chart");
					logger.info("2. go to home page");
                                            logger.info(SEPARATOR);
     	
					scanner=new Scanner(System.in);
				        int b2 =scanner.nextInt();
				         if(b2==1) {
				        	 
				        	logger.info("Navigating to the add to chart page...");
							logger.info("            === add to chart page ===");
		    				logger.info(SEPARATOR);

				        	product=pm.informationProduct(productlist,id );
				        	orderedProducts.add(product);
				        	pm.countProducts(orderedProducts);
				        	double total=pm.totalprice(orderedProducts);
				        	print2(product.getPrice(),total);

		    				logger.info(SEPARATOR);
				        			logger.info(SEPARATOR);

				  				     logger.info("Please select an option:");
									logger.info("1. make purchase");
									logger.info("2. go to home page");
				   				logger.info(SEPARATOR);

									scanner=new Scanner(System.in);
								        int u =scanner.nextInt();
								        if(u==1) {
								        	logger.info(SEPARATOR);

						  				     logger.info("Please enter you email ,city ,street");
								        	logger.info("email: ");
										   String Email=getNextLine(scanner);
										    Email=getNextLine(scanner);
										    while(!login.ifvalid(Email)) {
								 		    	 logger.info("email: ");
								 		    	Email=getNextLine(scanner); 
								 		     }
										   logger.info("city: ");
										   String city=getNextLine(scanner);
										   logger.info("street: ");
										   String street=getNextLine(scanner);
										   Date date=new Date();
										   int id2= om.count(request) ;
										   logger.info("chose time: 1-2 , 2-3 , 3-4");
							  				logger.info("Time: ");
											   String Time=getNextLine(scanner);
											   int installer=um.id_installer(userList,Time);
											   Order order=new Order(id2,user.getid(),orderedProducts,Email,date,city,street,"pending",installer);
										  request.add(order);
										 
										  String status="order is "+order.getOrderStatus();
										  SendMail.getSendEmail(status, Email); 
								        	logger.info(SEPARATOR);
											orderedProducts=new ArrayList<>();

								        }
								        	
								       
								        	
								        
				        	 }
					
					 
					 }
					 else {
						 logger.info("the product doesn't exsist..");

					 }
	    		logger.info(SEPARATOR);

					}
				
				
                if(d==4) {
                	boolean edit=true;
                	while(edit) {
                	user=um.informationUser(userList, email);
                	um.searchuser(userList, user.getName());
                	logger.info("Navigating to the profile page...");
    				logger.info("            === profile edit page ===");
    				
    				logger.info("Please select an option:");
    				logger.info("1. edit name");
    				logger.info("2. edit password");
    				logger.info("3. edit email");
    				logger.info("4. edit age");
    				logger.info("5. logout");
    				logger.info("6. go to homepage");


    				logger.info(SEPARATOR);
                	

    				 scanner=new Scanner(System.in);
    				int c=scanner.nextInt();
                       if(c==1) {
           		       logger.info("new name: ");
           		      name=getNextLine(scanner);
      	              name=getNextLine(scanner);
                       user=um.informationUser(userList, email) ;  
                      userList= um.updateUser(userList,user.getid(),name,user.getEmail(), user.getPassword(), user.getAge(), user.gettype());

                       }
                       if(c==2) {
                    	   
               		       logger.info("new password: ");
               		      password=getNextLine(scanner);
          	              password=getNextLine(scanner);
          	             
                           user=um.informationUser(userList, email) ;  
                          userList= um.updateUser(userList,user.getid(),user.getName(),user.getEmail(), password, user.getAge(), user.gettype());
                           }
                       if(c==3) {
                    	   logger.info("new email: ");
                 		     String  email2=getNextLine(scanner);
            	              email2=getNextLine(scanner);
            	              if(login.ifvalid(email2)) {
                             user=um.informationUser(userList, email) ;  
                              email=email2;
                              
                            userList= um.updateUser(userList,user.getid(),user.getName(),email, user.getPassword(), user.getAge(), user.gettype());
            	              }
                       }
                       if(c==4) {
                    	   logger.info("new age: ");
                 		     String age2=getNextLine(scanner);
            	              age2=getNextLine(scanner);
                             user=um.informationUser(userList, email) ;  
                            userList= um.updateUser(userList,user.getid(),user.getName(),user.getEmail(), user.getPassword(),age2, user.gettype());

                       }
                       if(c==5) {
		logger.info(SEPARATOR);
                    	   logger.info( " Logout Successfully");
		logger.info(SEPARATOR);
 	                     edit=false;
                         islogin=false;
                	
                }
                       if(c==6) {
                    	   edit=false;
                       }
                	}
                       


			}
               if(d==5) {
            	   om.vieworder(request,user.getid());
               }
               if( d==6){
		logger.info(SEPARATOR);
            	   logger.info( "you logout successfully");
		logger.info(SEPARATOR);
                 islogin=false; 
               }
                
			}
		}
			else if(user.gettype().equals("Admin")) {
				boolean t=true;
				while(t) {
		logger.info(SEPARATOR);

				logger.info("Navigating to the Admin page...");
				logger.info("            === home page ===");
				logger.info("Please select an option:");
				logger.info("1. Manage Products");
				logger.info("2. Manage Users");
				logger.info("3. Manage orders ");
				logger.info("4. log out");

		logger.info(SEPARATOR);

		  List<User> userList2 = new ArrayList<>();
		  boolean flag=false;
		  			  for(User user : userList) {
		  				  if(!userList2.isEmpty()) {
		  				  for(User user2 : userList2) {
		  					  if(user2.getid()==user.getid()) {
		  						  flag=true;
		  						  break;
		  					  }
		  					  
		  				  }
		  				  if(!flag) {
		  					userList2.add(user) ;
		  				  }
		  					flag=false;

		  				  }
		  				  else {
		  					 userList2.add(user) ;
		  				  }
		  				  
		  			  }
		  			userList=userList2;
				 scanner=new Scanner(System.in);
 				int c=scanner.nextInt();
 				if(c==1) {
 					boolean products=true;
 					while(products) {
 					pm.printproducts(productlist);
		logger.info(SEPARATOR);
 					logger.info("Navigating to the product page...");
 					logger.info("            === product page ===");

 					logger.info("Please select an option:");
 					logger.info("1. Add product");
 					logger.info("2. delete product");
 					logger.info("3. search product");
 					logger.info("4. update product");
 					logger.info("5.view details about specific product");
 					logger.info("6. go to home page");
		logger.info(SEPARATOR);

 					 scanner=new Scanner(System.in);
 	 				int k=scanner.nextInt();
                       if (k==1) {
		logger.info(SEPARATOR);

           				logger.info("enter Product Name , description ,price , category , available about product");
           				logger.info("Product Name: ");
           		 	    String productname=getNextLine(scanner);
           		 	     productname=getNextLine(scanner);

           		 	     logger.info("description: ");
        	 	          String description=getNextLine(scanner);
        	 	         logger.info("price: ");
        	 	 	    String price=getNextLine(scanner);
        	 	 	    double price2=Double.valueOf(price);
        	 	 	  logger.info("choose category: ");
         				logger.info("1. Exterior");
         				logger.info("2. Interior");
         				logger.info("3. Electronics");
    	 				int v=scanner.nextInt(); 
        		 	    String category="";

       if(v==1) {
    	   category= "Exterior";
       }
       else if(v==2) {
    	   category= "Interior";

       }
       else if(v==3) {
    	   category= "Electronics";

       }
        		 	    String available="available";
        		 	  int id=  pm.countProducts(productlist);
        		 	   productlist=pm.addproducts(productlist,productname,description,price2,category,available);

                       }
                       else if(k==2) {
              				logger.info("enter you product number: ");
                    	   scanner=new Scanner(System.in);
        	 				int l=scanner.nextInt(); 
        	 				productlist=pm.deleteproducts(productlist, l);	
                       }
                       else if(k==3) {
                    	   logger.info("enter product name: ");
         	 	          String productname=getNextLine(scanner);
         	 	        productname=getNextLine(scanner);
         	 	          pm.searchproductname(productlist, productname);
         	 	       
                       }
                       else if(k==4) {
                    	   pm.printproducts(productlist);
                    	   logger.info("enter you product number you would to update: ");
                     	   scanner=new Scanner(System.in);
         	 				int o=scanner.nextInt();
                    	   logger.info("Please select an option:");
           				logger.info("1. edit name");
           				logger.info("2. edit description");
           				logger.info("3. edit price");
           				logger.info("4. edit available");
           			     scanner=new Scanner(System.in);
  	 				     int f=scanner.nextInt();
         	 				if(f==1) {
         	 				  logger.info("enter new name: ");
         	 			         name=getNextLine(scanner);
         	 			         name=getNextLine(scanner);
         	 					product=pm.informationProduct(productlist, o);
         	 					productlist=pm.updateproducts(productlist,product.getid() ,name, product.getDescription(), product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==2) {
         	 					 logger.info("enter new description: ");
         	 			     String description=getNextLine(scanner);
         	 			         description=getNextLine(scanner);
         	 					product=pm.informationProduct(productlist, o);
         	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), description, product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==3) {
         	 					 logger.info("enter new price: ");
             	 			     String price=getNextLine(scanner);
             	 			         price=getNextLine(scanner);
             	 			         double price3=Double.valueOf(price);
             	 					product=pm.informationProduct(productlist, o);
             	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),price3, product.getCategory(), product.getAvailable());
             	 				
         	 				}
         	 				if(f==4) {
         	 					 logger.info("enter if available or not : ");
             	 			     String available=getNextLine(scanner);
             	 			          available=getNextLine(scanner);
             	 					product=pm.informationProduct(productlist, o);
             	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),product.getPrice(), product.getCategory(), available);
             	 				
         	 				
         	 				}
            				
         	 				
                       }
                     if(k==5) {
                    		logger.info("enter you product number: ");
                     	   scanner=new Scanner(System.in);
         	 				int l=scanner.nextInt(); 
         	 				pm.searchproduct(productlist, l);
                      }
                    if(k==6) {
                    	products=false;
                    }
 				}

 				}
 				if(c==2) {
 					boolean users=true;
 					while(users) {
		logger.info(SEPARATOR);
 					logger.info("Navigating to the Users page...");
 					logger.info("            === Users page ===");

 					logger.info("Please select an option:");
 					logger.info("1. view Users");
 					logger.info("2. add user ");
 					logger.info("3. delete user");
 					logger.info("4. search user ");
 					logger.info("5. go to home page");
		logger.info(SEPARATOR);
 					  scanner=new Scanner(System.in);
   	 				int l=scanner.nextInt(); 
   	 				if(l==1) {
   	 					um.printUsers(userList);
   	 					
   	 				}
   	 				if(l==2) {
   	 				logger.info("- Please enter  username and email and password and age :");
   	 			logger.info("username: ");
   	 	 	    String username=getNextLine(scanner);
   	 	          username=getNextLine(scanner);
   	 	          logger.info("email: ");
   	 		    String email2=getNextLine(scanner);
   	 		     while(!login.ifvalid(email2)) {
   	 		    	 logger.info("email: ");
   	 			     email2=getNextLine(scanner); 
   	 		     }
   	 		    logger.info("password: ");
   	 		     password=getNextLine(scanner);
   	 		    logger.info("age: ");
   	 		     age=getNextLine(scanner);
   	 	  userList= um.add(username, password, email2, age,userList);	
				um.printUsers(userList);

		logger.info(SEPARATOR);

   	 				}
   	 				if(l==3) {
   	 					um.printUsers(userList);
   	 				logger.info("enter  user number you want to delete: ");
              	   scanner=new Scanner(System.in);
  	 				int e=scanner.nextInt(); 
   	 					userList=um.deleteuser(userList, e);
   	 					um.printUsers(userList);
  	 				
  	 				

		logger.info(SEPARATOR);

   	 				}
   	 				if(l==4) {
   	   	 		  logger.info("enter  username: ");
   	 			 String username=getNextLine(scanner);
   		          username=getNextLine(scanner);
   		          um.searchuser(userList,username);
   		          
   	 				}
   	 				if(l==5) {
   	 					users=false;
   	 				}
 				}
 				}
 				
 				if(c==3) {
 					boolean orders=true;
 					while(orders) {
 					
		logger.info(SEPARATOR);
 					logger.info(" === request orders page ===");
 					logger.info("Please select an option:");
 					logger.info("1. view orders");
 					logger.info("2. check oreders ");
 					logger.info("3. edit order appointments ");
 					logger.info("4. go to home page");
		logger.info(SEPARATOR);
 					  scanner=new Scanner(System.in);
   	 				int m=scanner.nextInt(); 
   	 				if(m==1) {
 					 om.vieworder(request);
   	 				}
   	 				if(m==2) {
   	 				request=om.checkRequest(request); 
					 om.vieworder(request);
   	 				}
   	 				if(m==3) {
   	 				logger.info(SEPARATOR);
					logger.info("            === schedule appointments page ===");
					 om.vieworder(request);
					 logger.info("enter id order you want to schedule appointments :");
					 scanner=new Scanner(System.in);
				     int j=scanner.nextInt();
				        logger.info("Enter the date (yyyy-MM-dd)");
				        String userInput = getNextLine(scanner);
				         userInput = getNextLine(scanner);

						try {
							Date Date1=new Date();
					        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date1= dateFormat.parse(userInput);
							Date1.setHours(2);
							  request=om.setDate(request,j,Date1);
						        logger.info("Installation date updated");
						        String date=dateFormat.format(Date1);
                                String EMail1=om.getEmailForOrder(request,j);
								 SendMail.getSendEmail("The product you ordered will be installed on the date: "+date,EMail1); 
       						    om.vieworder(request);

						} catch (Exception e) {
							        logger.info("Error parsing date:");
						}
                  
   	 				}
   	 				if(m==4) {
   	 					orders=false;
   	 				}
   	 				
 				}
 				}
 				if(c==4) {
 					logger.info("you logout successfully");
 					t=false;
 				}
				}
				
			
			}
			
			else if(user.gettype().equals("installer")) {
				
				while(login.performLogin(email, password,userList)&&islogin) {
		logger.info(SEPARATOR);
					logger.info("you login as installer");
		logger.info(SEPARATOR);

					logger.info("Navigating to the home page...");
					logger.info("            === home page ===");
					logger.info("Please select an option:");
					logger.info("1. view all requests");
					logger.info("2. schedule appointments");
					logger.info("3. logout");
					logger.info(SEPARATOR);
					 scanner=new Scanner(System.in);
				     int d=scanner.nextInt();
				     if(d==1) {
				    
				 om.vieworder(request);
				 logger.info("do you want to cheak orders");
					logger.info("1. Yes");
					logger.info("2. No");
					scanner=new Scanner(System.in);
				     int v=scanner.nextInt();
				     if(v==1) {
				    	 request=om.checkRequest(request); 
						 om.vieworder(request);

				     }
				}
				     if(d==2) {
							logger.info(SEPARATOR);
							logger.info("            === schedule appointments page ===");
							 om.vieworder(request);
							 logger.info("enter id order you want to schedule appointments :");
							 scanner=new Scanner(System.in);
						     int j=scanner.nextInt();
						        logger.info("Enter the date (yyyy-MM-dd)");
						        String userInput = getNextLine(scanner);
						         userInput = getNextLine(scanner);

								try {
									Date Date=new Date();
							        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
									Date= dateFormat.parse(userInput);
									Date.setHours(2);
									  request=om.setDate(request,j,Date);
								        logger.info("Installation date updated");
								        String date=dateFormat.format(Date);
		                                String EMail=om.getEmailForOrder(request,j);
										 SendMail.getSendEmail("The product you ordered will be installed on the date: "+date,EMail); 
		       						    om.vieworder(request);

								} catch (Exception e) {
							        logger.info("Error parsing date:");

								}
                              

				     }
				     if( d==3){
		logger.info(SEPARATOR);
		            	   logger.info( "you logout successfully");
		logger.info(SEPARATOR);
		                 islogin=false; 
		               }
			}
		}
		}
	
		if(p==2) {
			logger.info("Navigating to the signup page...");
			logger.info("            === signup Page ===");
			logger.info("- Please enter your username and email and password and age :");
			logger.info("username: ");
	 	    String username=getNextLine(scanner);
	          username=getNextLine(scanner);
	          logger.info("email: ");
		     email=getNextLine(scanner);
		     while(!login.ifvalid(email)) {
		    	 logger.info("email: ");
			     email=getNextLine(scanner); 
		     }
		    logger.info("password: ");
		     password=getNextLine(scanner);
		    logger.info("age: ");
		     age=getNextLine(scanner);
	  userList= um.add(username, password, email, age,userList);	  
	}
       if(p==3) {
			notexit=false;
		}
}
  
       }
       
	

	
    private static String getNextLine(Scanner scanner) {
        return scanner.nextLine();
    }
    private static void print2(double pricep ,double total) {
    	logger.info("Product price= "+pricep);
    	logger.info("Total= "+total);   
    	}

}

