package carProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



public class Main {


	
	  static LOGIN login=new LOGIN();
	  private static  List<User> userList=Mydata.listUser();
	  private static  ProductMethods pm=new ProductMethods() ;
	  private static  UserMethods um=new UserMethods() ;

	private static  List<Product> productlist=Mydata.listProduct();
    private static List<Product> orderedProducts=new ArrayList<Product>();
    private static List<Order> request=new ArrayList<Order>();

	private static User user=new User();
     private static Product product =new Product ();
	 static Logger logger =  Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

    
		String name,email,password,age;
       boolean islogin=false;
      boolean notexit=true;
       
    
       
       

       while(notexit) {
       logger.info("===============================================================");

		logger.info("Welcome to the Application!");
		logger.info("Please select an option:");
		logger.info("1. Login");
		logger.info("2. signup");
	       	logger.info("3. exit");

		logger.info("===============================================================");

		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		if(p==1) {
			logger.info("===============================================================");

			logger.info("Navigating to the login page...");
			logger.info("            === Login Page ===");
			logger.info("- Please enter your email and password:");
			logger.info("===============================================================");
			
			logger.info("Email: ");
	 	    email=scanner.nextLine();
	          email=scanner.nextLine();
	          while(!login.ifvalid(email)) {
	 		    	 logger.info("email: ");
	 			     email=scanner.nextLine(); 
	 		     }
	          logger.info("Password: ");
		     password=scanner.nextLine();
			login.navigateToLoginPage(email,password,userList);
			while(!login.performLogin(email, password,userList)) {
				logger.info("Email: ");
		 	    email=scanner.nextLine();
		          logger.info("Password: ");
			     password=scanner.nextLine();
			}
			islogin=true;
			user=um.informationUser(userList, email) ;
			orderedProducts=new ArrayList<Product>();
			
			if(user.gettype().equals("customer")) {
			while(login.performLogin(email, password,userList)&&islogin) {
				logger.info( "===============================================");
				logger.info("you login as customer");
				logger.info("================================================");

				logger.info("Navigating to the home page...");
				logger.info("            === home page ===");
				logger.info("Please select an option:");
				logger.info("1. view all products");
				logger.info("2. view products category");
				logger.info("3. search about product you want");
				logger.info("4. view your profile");
				logger.info("5. view your request orders");
				logger.info("6. logout");

				logger.info("===============================================================");

				 scanner=new Scanner(System.in);
			     int d=scanner.nextInt();
				if(d==1) {
					logger.info("Navigating to the product page...");
					logger.info("            === product page ===");
					pm.printproducts(productlist);
					logger.info("Please select an option:");
					logger.info("1. To view a specific product");
					logger.info("2. go to home page");
    				logger.info("===============================================================");

					 scanner=new Scanner(System.in);
				     int k=scanner.nextInt();
                          if(k==1) {
          					logger.info("enter the product number");
          					scanner=new Scanner(System.in);
       				         int y=scanner.nextInt();
       				        boolean m=pm.searchproduct(productlist, y);
            				logger.info("===============================================================");

       				     logger.info("Please select an option:");
     					logger.info("1. add to my chart");
     					logger.info("2. go to home page");
        				logger.info("===============================================================");

     					scanner=new Scanner(System.in);
  				        int b =scanner.nextInt();
  				         if(b==1) {
  				        	 
  				        	logger.info("Navigating to the add to chart page...");
  							logger.info("            === add to chart page ===");
  		    				logger.info("===============================================================");
                             
  				        	product=pm.informationProduct(productlist,y );
  				        	orderedProducts.add(product);
  				        	user.setOrderedProducts(orderedProducts);
  				        	pm.countProducts(orderedProducts);
  				        	double total=pm.totalprice(orderedProducts);
  				        	logger.info("product Price= "+product.getPrice());
				        	logger.info("total= "+total);  		    		
				        	logger.info("===============================================================");
				        	logger.info("===============================================================");
				        	 logger.info("Please select an option:");
								logger.info("1. make purchase");
								logger.info("2. go to home page");
			   				logger.info("===============================================================");

								scanner=new Scanner(System.in);
							        int u =scanner.nextInt();
							        if(u==1) {
							        	logger.info("===============================================================");

					  				     logger.info("Please enter you email ,city ,street");
							        	logger.info("email: ");
									   String Email=scanner.nextLine();
									    Email=scanner.nextLine();
									   logger.info("city: ");
									   String city=scanner.nextLine();
									   logger.info("street: ");
									   String street=scanner.nextLine();
									   Date date=new Date();
									   int id2= OrderedMethods.count(request);
					  				  logger.info("chose time: 1-2 , 2-3 , 3-4");
					  				logger.info("Time: ");
									   String Time=scanner.nextLine();
									    Time=scanner.nextLine();
									   int installer=um.id_installer(userList,Time);
									  Order order=new Order(id2,user.getid(),orderedProducts,Email,date,city,street,"pending",installer);
									  
									  request.add(order);
									  //boolean f=OrderedMethods.ifAvailable(order);
									  //order=OrderedMethods.changeStatus(order,f);
									 // String status=OrderedMethods.message(f);
									  String status="order is "+order.getOrderStatus();
									  SendMail.getSendEmail(status, user.getEmail()); 
									  logger.info("Your request has been sent. We will contact you ");
							        	logger.info("===============================================================");

							        } 
  				         }
                          }
					


					
				}
				if(d==2){
			  logger.info("===============================================================");
				String[] cate = pm.printcategory(productlist);
				logger.info("Please select an option:");
					logger.info("1. view product in specific catogery");
					logger.info("2. go to home page");
				logger.info("===============================================================");
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
				        logger.info("Please select an option:");
						logger.info("1. To view a specific product");
						logger.info("2. go to home page");
	    				logger.info("===============================================================");

						 scanner=new Scanner(System.in);
					     int k=scanner.nextInt();
	                          if(k==1) {
	          					logger.info("enter the product number");
	          					scanner=new Scanner(System.in);
	       				         int y=scanner.nextInt();
	       				        pm.searchproduct(productlist, y);
	    	    	     logger.info("===============================================================");

	       				     logger.info("Please select an option:");
	     					logger.info("1. add to my chart");
	     					logger.info("2. go to home page");
	        				logger.info("===============================================================");

	     					scanner=new Scanner(System.in);
	  				        int b2 =scanner.nextInt();
	  				         if(b2==1) {
	  				        	 
	  				        	logger.info("Navigating to the add to chart page...");
	  							logger.info("            === add to chart page ===");
	  		    				logger.info("===============================================================");

	  				        	product=pm.informationProduct(productlist,y );
	  				        	orderedProducts.add(product);
	  				        	pm.countProducts(orderedProducts);
	  				        	double total=pm.totalprice(orderedProducts);
	  				        	logger.info("product Price= "+product.getPrice());

					        	logger.info("total= "+total);	  	
					        	logger.info("===============================================================");
					        	 logger.info("Please select an option:");
									logger.info("1. make purchase");
									logger.info("2. go to home page");
				   				logger.info("===============================================================");

									scanner=new Scanner(System.in);
								        int u =scanner.nextInt();
								        if(u==1) {
								        	logger.info("===============================================================");

						  				     logger.info("Please enter you email ,city ,street");
								        	logger.info("email: ");
										   String Email=scanner.nextLine();
										    Email=scanner.nextLine();
										   logger.info("city: ");
										   String city=scanner.nextLine();
										   logger.info("street: ");
										   String street=scanner.nextLine();
										   Date date=new Date();
										   int id2= OrderedMethods.count(request);
										   logger.info("chose time: 1-2 , 2-3 , 3-4");
							  				logger.info("Time: ");
											   String Time=scanner.nextLine();
											    Time=scanner.nextLine();
											   int installer=um.id_installer(userList,Time);
											   Order order=new Order(id2,user.getid(),orderedProducts,Email,date,city,street,"pending",installer);
										  
										  request.add(order);
										//  boolean f=OrderedMethods.ifAvailable(order);
										//  order=OrderedMethods.changeStatus(order,f);
										 // String status=OrderedMethods.message(f);
										  String status="order is "+order.getOrderStatus();
										  SendMail.getSendEmail(status, user.getEmail()); 
										  logger.info("Your request has been sent. We will contact you ");
								        	logger.info("===============================================================");

								        }
								    
	  				         }
	                          }
		        }

				        


				}
				if(d==3) {
	    				logger.info("===============================================================");

				logger.info("enter the product name: ");

					
					scanner=new Scanner(System.in);
					 String nameproduct=scanner.nextLine();	
					 if(pm.isexsist(productlist, nameproduct)) {
					int id= pm.searchproductname(productlist,nameproduct);
    				logger.info("===============================================================");

  				     logger.info("Please select an option:");
					logger.info("1. add to my chart");
					logger.info("2. go to home page");
   				logger.info("===============================================================");

					scanner=new Scanner(System.in);
				        int b2 =scanner.nextInt();
				         if(b2==1) {
				        	 
				        	logger.info("Navigating to the add to chart page...");
							logger.info("            === add to chart page ===");
		    				logger.info("===============================================================");

				        	product=pm.informationProduct(productlist,id );
				        	orderedProducts.add(product);
				        	pm.countProducts(orderedProducts);
				        	double total=pm.totalprice(orderedProducts);
				        	logger.info("product Price= "+product.getPrice());
				        	logger.info("total= "+total);
		    				logger.info("===============================================================");
				        			logger.info("===============================================================");

				  				     logger.info("Please select an option:");
									logger.info("1. make purchase");
									logger.info("2. go to home page");
				   				logger.info("===============================================================");

									scanner=new Scanner(System.in);
								        int u =scanner.nextInt();
								        if(u==1) {
								        	logger.info("===============================================================");

						  				     logger.info("Please enter you email ,city ,street");
								        	logger.info("email: ");
										   String Email=scanner.nextLine();
										    Email=scanner.nextLine();
										   logger.info("city: ");
										   String city=scanner.nextLine();
										   logger.info("street: ");
										   String street=scanner.nextLine();
										   Date date=new Date();
										   int id2= OrderedMethods.count(request) ;
										   logger.info("chose time: 1-2 , 2-3 , 3-4");
							  				logger.info("Time: ");
											   String Time=scanner.nextLine();
											    Time=scanner.nextLine();
											   int installer=um.id_installer(userList,Time);
											   Order order=new Order(id2,user.getid(),orderedProducts,Email,date,city,street,"pending",installer);
										  request.add(order);
										  //boolean f=OrderedMethods.ifAvailable(order);
										//  order=OrderedMethods.changeStatus(order,f);
										 // String status=OrderedMethods.message(f);
										  String status="order is "+order.getOrderStatus();
										  SendMail.getSendEmail(status, user.getEmail()); 
										  logger.info("Your request has been sent. We will contact you ");
								        	logger.info("===============================================================");
      
								        }
								        	
								       
								        	
								        
				        	 }
					
					 
					 }
	    		logger.info("===============================================================");

					}
				
				
                if(d==4) {
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

    				logger.info("===============================================================");

    				 scanner=new Scanner(System.in);
    				int c=scanner.nextInt();
                       if(c==1) {
           		       logger.info("new name: ");
           		      name=scanner.nextLine();
      	              name=scanner.nextLine();
                       user=um.informationUser(userList, email) ;  
                      userList= um.updateUser(userList,user.getid(),name,user.getEmail(), user.getPassword(), user.getAge(), user.gettype());

                       }
                       if(c==2) {
                    	   
               		       logger.info("new password: ");
               		      password=scanner.nextLine();
          	              password=scanner.nextLine();
          	             
                           user=um.informationUser(userList, email) ;  
                          userList= um.updateUser(userList,user.getid(),user.getName(),user.getEmail(), password, user.getAge(), user.gettype());
                           }
                       if(c==3) {
                    	   logger.info("new email: ");
                 		     String  email2=scanner.nextLine();
            	              email2=scanner.nextLine();
            	              if(login.ifvalid(email2)) {
                             user=um.informationUser(userList, email) ;  
                              email=email2;
                              
                            userList= um.updateUser(userList,user.getid(),user.getName(),email, user.getPassword(), user.getAge(), user.gettype());
            	              }
                       }
                       if(c==4) {
                    	   logger.info("new age: ");
                 		     String age2=scanner.nextLine();
            	              age2=scanner.nextLine();
                             user=um.informationUser(userList, email) ;  
                            userList= um.updateUser(userList,user.getid(),user.getName(),user.getEmail(), user.getPassword(),age2, user.gettype());

                       }
                       if(c==5) {
                    	   logger.info("=====================================================");
                    	   logger.info( "you logout successfully");
                    	   logger.info("=====================================================");
                         islogin=false;
                	
                }


			}
               if(d==5) {
            	   OrderedMethods.vieworder(request,user.getid());
               }
               if( d==6){
            	   logger.info("=====================================================");
            	   logger.info( "you logout successfully");
            	   logger.info("=====================================================");
                 islogin=false; 
               }
                
			}
		}
			else if(user.gettype().equals("Admin")) {
				boolean t=true;
				while(t) {
				logger.info("===================================================================================");

				logger.info("Navigating to the Admin page...");
				logger.info("            === home page ===");
				logger.info("Please select an option:");
				logger.info("1. Manage Products");
				logger.info("2. Manage Users");
				logger.info("3. Manage orders ");
				logger.info("4. log out");

				logger.info("===================================================================================");

				 scanner=new Scanner(System.in);
 				int c=scanner.nextInt();
 				if(c==1) {
 					pm.printproducts(productlist);
 					logger.info("===================================================================================");
 					logger.info("Navigating to the product page...");
 					logger.info("            === product page ===");

 					logger.info("Please select an option:");
 					logger.info("1. Add product");
 					logger.info("2. delete product");
 					logger.info("3. search product");
 					logger.info("4. update product");
 					logger.info("5.view details about specific product");
 					logger.info("6. go to home page");
 					logger.info("===================================================================================");

 					 scanner=new Scanner(System.in);
 	 				int k=scanner.nextInt();
                       if (k==1) {
           				logger.info("===================================================================================");

           				logger.info("enter Product Name , description ,price , category , available about product");
           				logger.info("Product Name: ");
           		 	    String productname=scanner.nextLine();
           		 	     productname=scanner.nextLine();

           		 	     logger.info("description: ");
        	 	          String description=scanner.nextLine();
        	 	         logger.info("price: ");
        	 	 	    String price=scanner.nextLine();
        	 	 	    double price2=Double.valueOf(price);
        	 	 	  logger.info("category: ");
        		 	    String category=scanner.nextLine();
        		 	   logger.info("available: ");
        		 	    String available=scanner.nextLine();
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
         	 	          String productname=scanner.nextLine();
         	 	        productname=scanner.nextLine();
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
         	 			         name=scanner.nextLine();
         	 			         name=scanner.nextLine();
         	 					product=pm.informationProduct(productlist, o);
         	 					productlist=pm.updateproducts(productlist,product.getid() ,name, product.getDescription(), product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==2) {
         	 					 logger.info("enter new description: ");
         	 			     String description=scanner.nextLine();
         	 			         description=scanner.nextLine();
         	 					product=pm.informationProduct(productlist, o);
         	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), description, product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==3) {
         	 					 logger.info("enter new price: ");
             	 			     String price=scanner.nextLine();
             	 			         price=scanner.nextLine();
             	 			         double price3=Double.valueOf(price);
             	 					product=pm.informationProduct(productlist, o);
             	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),price3, product.getCategory(), product.getAvailable());
             	 				
         	 				}
         	 				if(f==4) {
         	 					 logger.info("enter if available or not : ");
             	 			     String available=scanner.nextLine();
             	 			          available=scanner.nextLine();
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


 				}
 				if(c==2) {
 					logger.info("===================================================================================");
 					logger.info("Navigating to the Users page...");
 					logger.info("            === Users page ===");

 					logger.info("Please select an option:");
 					logger.info("1. view Users");
 					logger.info("2. add user ");
 					logger.info("3. delete user");
 					logger.info("4. search user ");
 					logger.info("5. go to home page");
 					logger.info("===================================================================================");
 					  scanner=new Scanner(System.in);
   	 				int l=scanner.nextInt(); 
   	 				if(l==1) {
   	 					um.printUsers(userList);
   	 					
   	 				}
   	 				if(l==2) {
   	 				logger.info("- Please enter  username and email and password and age :");
   	 			logger.info("username: ");
   	 	 	    String username=scanner.nextLine();
   	 	          username=scanner.nextLine();
   	 	          logger.info("email: ");
   	 		    String email2=scanner.nextLine();
   	 		     while(!login.ifvalid(email2)) {
   	 		    	 logger.info("email: ");
   	 			     email2=scanner.nextLine(); 
   	 		     }
   	 		    logger.info("password: ");
   	 		     password=scanner.nextLine();
   	 		    logger.info("age: ");
   	 		     age=scanner.nextLine();
   	 	  userList= um.add(username, password, email2, age,userList);	
			logger.info("===================================================================================");

   	 				}
   	 				if(l==3) {
   	 					um.printUsers(userList);
   	 				logger.info("enter  user number you want to delete: ");
              	   scanner=new Scanner(System.in);
  	 				int e=scanner.nextInt(); 
   	 					userList=um.deleteuser(userList, e);
   	 					logger.info("===================================================================================");

   	 				}
   	 				if(l==4) {
   	   	 		  logger.info("enter  username: ");
   	 			 String username=scanner.nextLine();
   		          username=scanner.nextLine();
   		          um.searchuser(userList,username);
   		          
   	 				}
 				}
 				
 				if(c==3) {
 					logger.info("===================================================================================");
 					logger.info(" === request orders page ===");
 					logger.info("Please select an option:");
 					logger.info("1. view orders");
 					logger.info("2. check oreders ");
 					logger.info("3. edit order appointments ");
 					logger.info("4. go to home page");
 					logger.info("===================================================================================");
 					  scanner=new Scanner(System.in);
   	 				int m=scanner.nextInt(); 
   	 				if(m==1) {
 					 OrderedMethods.vieworder(request);
   	 				}
   	 				if(m==2) {
   	 				request=OrderedMethods.checkRequest(request); 
					 OrderedMethods.vieworder(request);
   	 				}
   	 				if(m==3) {
   	 				logger.info("===============================================================");
					logger.info("            === schedule appointments page ===");
					 OrderedMethods.vieworder(request);
					 logger.info("enter id order you want to schedule appointments :");
					 scanner=new Scanner(System.in);
				     int j=scanner.nextInt();
				        logger.info("Enter the date (yyyy-MM-dd HH:mm)");
				        String userInput = scanner.nextLine();
				         userInput = scanner.nextLine();

						try {
							Date Date=new Date();
					        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							Date= dateFormat.parse(userInput);
							  request=OrderedMethods.setDate(request,j,Date);
						        logger.info("Installation date updated");
						        String date=dateFormat.format(Date);
                                String EMail=OrderedMethods.getEmailForOrder(request,j);
								 SendMail.getSendEmail("The product you ordered will be installed on the date: "+date,EMail); 
       						    OrderedMethods.vieworder(request);

						} catch (Exception e) {
                                         logger.log(Level.SEVERE, "Error sending email: " + e.getMessage());
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
					logger.info( "===============================================");
					logger.info("you login as installer");
					logger.info("================================================");

					logger.info("Navigating to the home page...");
					logger.info("            === home page ===");
					logger.info("Please select an option:");
					logger.info("1. view all requests");
					logger.info("2. schedule appointments");
					logger.info("3. logout");
					logger.info("===============================================================");
					 scanner=new Scanner(System.in);
				     int d=scanner.nextInt();
				     if(d==1) {
				    
				 OrderedMethods.vieworder(request);
				 logger.info("do you want to cheak orders");
					logger.info("1. Yes");
					logger.info("2. No");
					scanner=new Scanner(System.in);
				     int v=scanner.nextInt();
				     if(v==1) {
				    	 request=OrderedMethods.checkRequest(request); 
						 OrderedMethods.vieworder(request);

				     }
				}
				     if(d==2) {
							logger.info("===============================================================");
							logger.info("            === schedule appointments page ===");
							 OrderedMethods.vieworder(request);
							 logger.info("enter id order you want to schedule appointments :");
							 scanner=new Scanner(System.in);
						     int j=scanner.nextInt();
						        logger.info("Enter the date (yyyy-MM-dd HH:mm)");
						        String userInput = scanner.nextLine();
						         userInput = scanner.nextLine();

								try {
									Date Date=new Date();
							        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
									Date= dateFormat.parse(userInput);
									  request=OrderedMethods.setDate(request,j,Date);
								        logger.info("Installation date updated");
								        String date=dateFormat.format(Date);
		                                String EMail=OrderedMethods.getEmailForOrder(request,j);
										 SendMail.getSendEmail("The product you ordered will be installed on the date: "+date,EMail); 
		       						    OrderedMethods.vieworder(request);

								} catch (Exception e) {
									            logger.log(Level.SEVERE, "Error sending email: " + e.getMessage());

								}
                              

				     }
				     if( d==3){
		            	   logger.info("=====================================================");
		            	   logger.info( "you logout successfully");
		            	   logger.info("=====================================================");
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
	 	    String username=scanner.nextLine();
	          username=scanner.nextLine();
	          logger.info("email: ");
		     email=scanner.nextLine();
		     while(!login.ifvalid(email)) {
		    	 logger.info("email: ");
			     email=scanner.nextLine(); 
		     }
		    logger.info("password: ");
		     password=scanner.nextLine();
		    logger.info("age: ");
		     age=scanner.nextLine();
	  userList= um.add(username, password, email, age,userList);	  
	}
       if(p==3) {
			notexit=false;
		}
}
       
       }
       
	
}
