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
       
       
    
       
       

       while(true) {
       System.out.println("===============================================================");

		System.out.println("Welcome to the Application!");
		System.out.println("Please select an option:");
		System.out.println("1. Login");
		System.out.println("2. signup");
		System.out.println("===============================================================");

		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		if(p==1) {
			System.out.println("===============================================================");

			System.out.println("Navigating to the login page...");
			System.out.println("            === Login Page ===");
			System.out.println("- Please enter your email and password:");
			System.out.println("===============================================================");
			
			System.out.println("Email: ");
	 	    email=scanner.nextLine();
	          email=scanner.nextLine();
	          while(!login.ifvalid(email)) {
	 		    	 System.out.println("email: ");
	 			     email=scanner.nextLine(); 
	 		     }
	          System.out.println("Password: ");
		     password=scanner.nextLine();
			login.navigateToLoginPage(email,password,userList);
			while(!login.performLogin(email, password,userList)) {
				System.out.println("Email: ");
		 	    email=scanner.nextLine();
		          System.out.println("Password: ");
			     password=scanner.nextLine();
			}
			islogin=true;
			user=um.informationUser(userList, email) ;
			orderedProducts=new ArrayList<Product>();
			
			if(user.gettype().equals("customer")) {
			while(login.performLogin(email, password,userList)&&islogin) {
				System.out.println( "===============================================");
				System.out.println("you login as customer");
				System.out.println("================================================");

				System.out.println("Navigating to the home page...");
				System.out.println("            === home page ===");
				System.out.println("Please select an option:");
				System.out.println("1. view all products");
				System.out.println("2. view products category");
				System.out.println("3. search about product you want");
				System.out.println("4. view your profile");
				System.out.println("5. view your request orders");
				System.out.println("6. logout");

				System.out.println("===============================================================");

				 scanner=new Scanner(System.in);
			     int d=scanner.nextInt();
				if(d==1) {
					System.out.println("Navigating to the product page...");
					System.out.println("            === product page ===");
					pm.printproducts(productlist);
					System.out.println("Please select an option:");
					System.out.println("1. To view a specific product");
					System.out.println("2. go to home page");
    				System.out.println("===============================================================");

					 scanner=new Scanner(System.in);
				     int k=scanner.nextInt();
                          if(k==1) {
          					System.out.println("enter the product number");
          					scanner=new Scanner(System.in);
       				         int y=scanner.nextInt();
       				        boolean m=pm.searchproduct(productlist, y);
            				System.out.println("===============================================================");

       				     System.out.println("Please select an option:");
     					System.out.println("1. add to my chart");
     					System.out.println("2. go to home page");
        				System.out.println("===============================================================");

     					scanner=new Scanner(System.in);
  				        int b =scanner.nextInt();
  				         if(b==1) {
  				        	 
  				        	System.out.println("Navigating to the add to chart page...");
  							System.out.println("            === add to chart page ===");
  		    				System.out.println("===============================================================");
                             
  				        	product=pm.informationProduct(productlist,y );
  				        	orderedProducts.add(product);
  				        	user.setOrderedProducts(orderedProducts);
  				        	pm.countProducts(orderedProducts);
  				        	double total=pm.totalprice(orderedProducts);
  				        	System.out.println("product Price= "+product.getPrice());
				        	System.out.println("total= "+total);  		    		
				        	System.out.println("===============================================================");
				        	System.out.println("===============================================================");
				        	 System.out.println("Please select an option:");
								System.out.println("1. make purchase");
								System.out.println("2. go to home page");
			   				System.out.println("===============================================================");

								scanner=new Scanner(System.in);
							        int u =scanner.nextInt();
							        if(u==1) {
							        	System.out.println("===============================================================");

					  				     System.out.println("Please enter you email ,city ,street");
							        	System.out.println("email: ");
									   String Email=scanner.nextLine();
									    Email=scanner.nextLine();
									   System.out.println("city: ");
									   String city=scanner.nextLine();
									   System.out.println("street: ");
									   String street=scanner.nextLine();
									   Date date=new Date();
									   int id2= OrderedMethods.count(request);
					  				  System.out.println("chose time: 1-2 , 2-3 , 3-4");
					  				System.out.println("Time: ");
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
									  System.out.println("Your request has been sent. We will contact you ");
							        	System.out.println("===============================================================");

							        } 
  				         }
                          }
					


					
				}
				if(d==2){
			  System.out.println("===============================================================");
				String[] cate = pm.printcategory(productlist);
				System.out.println("Please select an option:");
					System.out.println("1. view product in specific catogery");
					System.out.println("2. go to home page");
				System.out.println("===============================================================");
				scanner=new Scanner(System.in);
		        int a1 =scanner.nextInt();
		        if(a1==1) {
					System.out.println("enter category number");
							        
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
				        System.out.println("Please select an option:");
						System.out.println("1. To view a specific product");
						System.out.println("2. go to home page");
	    				System.out.println("===============================================================");

						 scanner=new Scanner(System.in);
					     int k=scanner.nextInt();
	                          if(k==1) {
	          					System.out.println("enter the product number");
	          					scanner=new Scanner(System.in);
	       				         int y=scanner.nextInt();
	       				        pm.searchproduct(productlist, y);
	    	    	     System.out.println("===============================================================");

	       				     System.out.println("Please select an option:");
	     					System.out.println("1. add to my chart");
	     					System.out.println("2. go to home page");
	        				System.out.println("===============================================================");

	     					scanner=new Scanner(System.in);
	  				        int b2 =scanner.nextInt();
	  				         if(b2==1) {
	  				        	 
	  				        	System.out.println("Navigating to the add to chart page...");
	  							System.out.println("            === add to chart page ===");
	  		    				System.out.println("===============================================================");

	  				        	product=pm.informationProduct(productlist,y );
	  				        	orderedProducts.add(product);
	  				        	pm.countProducts(orderedProducts);
	  				        	double total=pm.totalprice(orderedProducts);
	  				        	System.out.println("product Price= "+product.getPrice());

					        	System.out.println("total= "+total);	  	
					        	System.out.println("===============================================================");
					        	 System.out.println("Please select an option:");
									System.out.println("1. make purchase");
									System.out.println("2. go to home page");
				   				System.out.println("===============================================================");

									scanner=new Scanner(System.in);
								        int u =scanner.nextInt();
								        if(u==1) {
								        	System.out.println("===============================================================");

						  				     System.out.println("Please enter you email ,city ,street");
								        	System.out.println("email: ");
										   String Email=scanner.nextLine();
										    Email=scanner.nextLine();
										   System.out.println("city: ");
										   String city=scanner.nextLine();
										   System.out.println("street: ");
										   String street=scanner.nextLine();
										   Date date=new Date();
										   int id2= OrderedMethods.count(request);
										   System.out.println("chose time: 1-2 , 2-3 , 3-4");
							  				System.out.println("Time: ");
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
										  System.out.println("Your request has been sent. We will contact you ");
								        	System.out.println("===============================================================");

								        }
								    
	  				         }
	                          }
		        }

				        


				}
				if(d==3) {
	    				System.out.println("===============================================================");

				System.out.println("enter the product name: ");

					
					scanner=new Scanner(System.in);
					 String nameproduct=scanner.nextLine();	
					 if(pm.isexsist(productlist, nameproduct)) {
					int id= pm.searchproductname(productlist,nameproduct);
    				System.out.println("===============================================================");

  				     System.out.println("Please select an option:");
					System.out.println("1. add to my chart");
					System.out.println("2. go to home page");
   				System.out.println("===============================================================");

					scanner=new Scanner(System.in);
				        int b2 =scanner.nextInt();
				         if(b2==1) {
				        	 
				        	System.out.println("Navigating to the add to chart page...");
							System.out.println("            === add to chart page ===");
		    				System.out.println("===============================================================");

				        	product=pm.informationProduct(productlist,id );
				        	orderedProducts.add(product);
				        	pm.countProducts(orderedProducts);
				        	double total=pm.totalprice(orderedProducts);
				        	System.out.println("product Price= "+product.getPrice());
				        	System.out.println("total= "+total);
		    				System.out.println("===============================================================");
				        			System.out.println("===============================================================");

				  				     System.out.println("Please select an option:");
									System.out.println("1. make purchase");
									System.out.println("2. go to home page");
				   				System.out.println("===============================================================");

									scanner=new Scanner(System.in);
								        int u =scanner.nextInt();
								        if(u==1) {
								        	System.out.println("===============================================================");

						  				     System.out.println("Please enter you email ,city ,street");
								        	System.out.println("email: ");
										   String Email=scanner.nextLine();
										    Email=scanner.nextLine();
										   System.out.println("city: ");
										   String city=scanner.nextLine();
										   System.out.println("street: ");
										   String street=scanner.nextLine();
										   Date date=new Date();
										   int id2= OrderedMethods.count(request) ;
										   System.out.println("chose time: 1-2 , 2-3 , 3-4");
							  				System.out.println("Time: ");
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
										  System.out.println("Your request has been sent. We will contact you ");
								        	System.out.println("===============================================================");
      
								        }
								        	
								       
								        	
								        
				        	 }
					
					 
					 }
	    		System.out.println("===============================================================");

					}
				
				
                if(d==4) {
                	user=um.informationUser(userList, email);
                	um.searchuser(userList, user.getName());
                	System.out.println("Navigating to the profile page...");
    				System.out.println("            === profile edit page ===");
    				
    				System.out.println("Please select an option:");
    				System.out.println("1. edit name");
    				System.out.println("2. edit password");
    				System.out.println("3. edit email");
    				System.out.println("4. edit age");
    				System.out.println("5. logout");

    				System.out.println("===============================================================");

    				 scanner=new Scanner(System.in);
    				int c=scanner.nextInt();
                       if(c==1) {
           		       System.out.println("new name: ");
           		      name=scanner.nextLine();
      	              name=scanner.nextLine();
                       user=um.informationUser(userList, email) ;  
                      userList= um.updateUser(userList,user.getid(),name,user.getEmail(), user.getPassword(), user.getAge(), user.gettype());

                       }
                       if(c==2) {
                    	   
               		       System.out.println("new password: ");
               		      password=scanner.nextLine();
          	              password=scanner.nextLine();
          	             
                           user=um.informationUser(userList, email) ;  
                          userList= um.updateUser(userList,user.getid(),user.getName(),user.getEmail(), password, user.getAge(), user.gettype());
                           }
                       if(c==3) {
                    	   System.out.println("new email: ");
                 		     String  email2=scanner.nextLine();
            	              email2=scanner.nextLine();
            	              if(login.ifvalid(email2)) {
                             user=um.informationUser(userList, email) ;  
                              email=email2;
                              
                            userList= um.updateUser(userList,user.getid(),user.getName(),email, user.getPassword(), user.getAge(), user.gettype());
            	              }
                       }
                       if(c==4) {
                    	   System.out.println("new age: ");
                 		     String age2=scanner.nextLine();
            	              age2=scanner.nextLine();
                             user=um.informationUser(userList, email) ;  
                            userList= um.updateUser(userList,user.getid(),user.getName(),user.getEmail(), user.getPassword(),age2, user.gettype());

                       }
                       if(c==5) {
                    	   System.out.println("=====================================================");
                    	   System.out.println( "you logout successfully");
                    	   System.out.println("=====================================================");
                         islogin=false;
                	
                }


			}
               if(d==5) {
            	   OrderedMethods.vieworder(request,user.getid());
               }
               if( d==6){
            	   System.out.println("=====================================================");
            	   System.out.println( "you logout successfully");
            	   System.out.println("=====================================================");
                 islogin=false; 
               }
                
			}
		}
			else if(user.gettype().equals("Admin")) {
				boolean t=true;
				while(t) {
				System.out.println("===================================================================================");

				System.out.println("Navigating to the Admin page...");
				System.out.println("            === home page ===");
				System.out.println("Please select an option:");
				System.out.println("1. Manage Products");
				System.out.println("2. Manage Users");
				System.out.println("3. Manage orders ");
				System.out.println("4. log out");

				System.out.println("===================================================================================");

				 scanner=new Scanner(System.in);
 				int c=scanner.nextInt();
 				if(c==1) {
 					pm.printproducts(productlist);
 					System.out.println("===================================================================================");
 					System.out.println("Navigating to the product page...");
 					System.out.println("            === product page ===");

 					System.out.println("Please select an option:");
 					System.out.println("1. Add product");
 					System.out.println("2. delete product");
 					System.out.println("3. search product");
 					System.out.println("4. update product");
 					System.out.println("5.view details about specific product");
 					System.out.println("6. go to home page");
 					System.out.println("===================================================================================");

 					 scanner=new Scanner(System.in);
 	 				int k=scanner.nextInt();
                       if (k==1) {
           				System.out.println("===================================================================================");

           				System.out.println("enter Product Name , description ,price , category , available about product");
           				System.out.println("Product Name: ");
           		 	    String productname=scanner.nextLine();
           		 	     productname=scanner.nextLine();

           		 	     System.out.println("description: ");
        	 	          String description=scanner.nextLine();
        	 	         System.out.println("price: ");
        	 	 	    String price=scanner.nextLine();
        	 	 	    double price2=Double.valueOf(price);
        	 	 	  System.out.println("category: ");
        		 	    String category=scanner.nextLine();
        		 	   System.out.println("available: ");
        		 	    String available=scanner.nextLine();
        		 	  int id=  pm.countProducts(productlist);
        		 	   productlist=pm.addproducts(productlist,productname,description,price2,category,available);

                       }
                       else if(k==2) {
              				System.out.println("enter you product number: ");
                    	   scanner=new Scanner(System.in);
        	 				int l=scanner.nextInt(); 
        	 				productlist=pm.deleteproducts(productlist, l);	
                       }
                       else if(k==3) {
                    	   System.out.println("enter product name: ");
         	 	          String productname=scanner.nextLine();
         	 	        productname=scanner.nextLine();
         	 	          pm.searchproductname(productlist, productname);
         	 	       
                       }
                       else if(k==4) {
                    	   pm.printproducts(productlist);
                    	   System.out.println("enter you product number you would to update: ");
                     	   scanner=new Scanner(System.in);
         	 				int o=scanner.nextInt();
                    	   System.out.println("Please select an option:");
           				System.out.println("1. edit name");
           				System.out.println("2. edit description");
           				System.out.println("3. edit price");
           				System.out.println("4. edit available");
           			     scanner=new Scanner(System.in);
  	 				     int f=scanner.nextInt();
         	 				if(f==1) {
         	 				  System.out.println("enter new name: ");
         	 			         name=scanner.nextLine();
         	 			         name=scanner.nextLine();
         	 					product=pm.informationProduct(productlist, o);
         	 					productlist=pm.updateproducts(productlist,product.getid() ,name, product.getDescription(), product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==2) {
         	 					 System.out.println("enter new description: ");
         	 			     String description=scanner.nextLine();
         	 			         description=scanner.nextLine();
         	 					product=pm.informationProduct(productlist, o);
         	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), description, product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==3) {
         	 					 System.out.println("enter new price: ");
             	 			     String price=scanner.nextLine();
             	 			         price=scanner.nextLine();
             	 			         double price3=Double.valueOf(price);
             	 					product=pm.informationProduct(productlist, o);
             	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),price3, product.getCategory(), product.getAvailable());
             	 				
         	 				}
         	 				if(f==4) {
         	 					 System.out.println("enter if available or not : ");
             	 			     String available=scanner.nextLine();
             	 			          available=scanner.nextLine();
             	 					product=pm.informationProduct(productlist, o);
             	 					productlist=pm.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),product.getPrice(), product.getCategory(), available);
             	 				
         	 				
         	 				}
            				
         	 				
                       }
                     if(k==5) {
                    		System.out.println("enter you product number: ");
                     	   scanner=new Scanner(System.in);
         	 				int l=scanner.nextInt(); 
         	 				pm.searchproduct(productlist, l);
                      }


 				}
 				if(c==2) {
 					System.out.println("===================================================================================");
 					System.out.println("Navigating to the Users page...");
 					System.out.println("            === Users page ===");

 					System.out.println("Please select an option:");
 					System.out.println("1. view Users");
 					System.out.println("2. add user ");
 					System.out.println("3. delete user");
 					System.out.println("4. search user ");
 					System.out.println("5. go to home page");
 					System.out.println("===================================================================================");
 					  scanner=new Scanner(System.in);
   	 				int l=scanner.nextInt(); 
   	 				if(l==1) {
   	 					um.printUsers(userList);
   	 					
   	 				}
   	 				if(l==2) {
   	 				System.out.println("- Please enter  username and email and password and age :");
   	 			System.out.println("username: ");
   	 	 	    String username=scanner.nextLine();
   	 	          username=scanner.nextLine();
   	 	          System.out.println("email: ");
   	 		    String email2=scanner.nextLine();
   	 		     while(!login.ifvalid(email2)) {
   	 		    	 System.out.println("email: ");
   	 			     email2=scanner.nextLine(); 
   	 		     }
   	 		    System.out.println("password: ");
   	 		     password=scanner.nextLine();
   	 		    System.out.println("age: ");
   	 		     age=scanner.nextLine();
   	 	  userList= um.add(username, password, email2, age,userList);	
			System.out.println("===================================================================================");

   	 				}
   	 				if(l==3) {
   	 					um.printUsers(userList);
   	 				System.out.println("enter  user number you want to delete: ");
              	   scanner=new Scanner(System.in);
  	 				int e=scanner.nextInt(); 
   	 					userList=um.deleteuser(userList, e);
   	 					System.out.println("===================================================================================");

   	 				}
   	 				if(l==4) {
   	   	 		  System.out.println("enter  username: ");
   	 			 String username=scanner.nextLine();
   		          username=scanner.nextLine();
   		          um.searchuser(userList,username);
   		          
   	 				}
 				}
 				
 				if(c==3) {
 					System.out.println("===================================================================================");
 					System.out.println(" === request orders page ===");
 					System.out.println("Please select an option:");
 					System.out.println("1. view orders");
 					System.out.println("2. check oreders ");
 					System.out.println("3. edit order appointments ");
 					System.out.println("4. go to home page");
 					System.out.println("===================================================================================");
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
   	 				System.out.println("===============================================================");
					System.out.println("            === schedule appointments page ===");
					 OrderedMethods.vieworder(request);
					 System.out.println("enter id order you want to schedule appointments :");
					 scanner=new Scanner(System.in);
				     int j=scanner.nextInt();
				        System.out.println("Enter the date (yyyy-MM-dd HH:mm)");
				        String userInput = scanner.nextLine();
				         userInput = scanner.nextLine();

						try {
							Date Date=new Date();
					        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							Date= dateFormat.parse(userInput);
							  request=OrderedMethods.setDate(request,j,Date);
						        System.out.println("Installation date updated");
						        String date=dateFormat.format(Date);
                                String EMail=OrderedMethods.getEmailForOrder(request,j);
								 SendMail.getSendEmail("The product you ordered will be installed on the date: "+date,EMail); 
       						    OrderedMethods.vieworder(request);

						} catch (ParseException e) {
							e.printStackTrace();
						}
                  
   	 				}
   	 				
 					
 				}
 				if(c==4) {
 					System.out.println("you logout successfully");
 					t=false;
 				}
				}
				
			
			}
			
			else if(user.gettype().equals("installer")) {
				
				while(login.performLogin(email, password,userList)&&islogin) {
					System.out.println( "===============================================");
					System.out.println("you login as installer");
					System.out.println("================================================");

					System.out.println("Navigating to the home page...");
					System.out.println("            === home page ===");
					System.out.println("Please select an option:");
					System.out.println("1. view all requests");
					System.out.println("2. schedule appointments");
					System.out.println("3. logout");
					System.out.println("===============================================================");
					 scanner=new Scanner(System.in);
				     int d=scanner.nextInt();
				     if(d==1) {
				    
				 OrderedMethods.vieworder(request);
				 System.out.println("do you want to cheak orders");
					System.out.println("1. Yes");
					System.out.println("2. No");
					scanner=new Scanner(System.in);
				     int v=scanner.nextInt();
				     if(v==1) {
				    	 request=OrderedMethods.checkRequest(request); 
						 OrderedMethods.vieworder(request);

				     }
				}
				     if(d==2) {
							System.out.println("===============================================================");
							System.out.println("            === schedule appointments page ===");
							 OrderedMethods.vieworder(request);
							 System.out.println("enter id order you want to schedule appointments :");
							 scanner=new Scanner(System.in);
						     int j=scanner.nextInt();
						        System.out.println("Enter the date (yyyy-MM-dd HH:mm)");
						        String userInput = scanner.nextLine();
						         userInput = scanner.nextLine();

								try {
									Date Date=new Date();
							        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
									Date= dateFormat.parse(userInput);
									  request=OrderedMethods.setDate(request,j,Date);
								        System.out.println("Installation date updated");
								        String date=dateFormat.format(Date);
		                                String EMail=OrderedMethods.getEmailForOrder(request,j);
										 SendMail.getSendEmail("The product you ordered will be installed on the date: "+date,EMail); 
		       						    OrderedMethods.vieworder(request);

								} catch (ParseException e) {
									e.printStackTrace();
								}
                              

				     }
				     if( d==3){
		            	   System.out.println("=====================================================");
		            	   System.out.println( "you logout successfully");
		            	   System.out.println("=====================================================");
		                 islogin=false; 
		               }
			}
		}
		}
	
		if(p==2) {
			System.out.println("Navigating to the signup page...");
			System.out.println("            === signup Page ===");
			System.out.println("- Please enter your username and email and password and age :");
			System.out.println("username: ");
	 	    String username=scanner.nextLine();
	          username=scanner.nextLine();
	          System.out.println("email: ");
		     email=scanner.nextLine();
		     while(!login.ifvalid(email)) {
		    	 System.out.println("email: ");
			     email=scanner.nextLine(); 
		     }
		    System.out.println("password: ");
		     password=scanner.nextLine();
		    System.out.println("age: ");
		     age=scanner.nextLine();
	  userList= um.add(username, password, email, age,userList);	  
	}

}
       
       }
       
	
}

	

