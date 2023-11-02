package carProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {
	static LOGIN login=new LOGIN();
	  private static  List<User> userList=Mydata.listUser();
	  private static  ProductCatalog pc=new ProductCatalog() ;
	private static  List<Product> productlist=Mydata.listProduct();
    private static List<Product> orderedProducts=new ArrayList<Product>();
	private static User user=new User();
     private static Product product =new Product ();

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
			user=user.informationUser(userList, email) ;
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
				System.out.println("===============================================================");

				 scanner=new Scanner(System.in);
			     int d=scanner.nextInt();
				if(d==1) {
					System.out.println("Navigating to the product page...");
					System.out.println("            === product page ===");
					pc.printproducts(productlist);
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
       				        pc.searchproduct(productlist, y);
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

  				        	product=product.informationProduct(productlist,y );
  				        	orderedProducts.add(product);
  				        	pc.countProducts(orderedProducts);
  				        	double total=pc.totalprice(orderedProducts);
  				        	System.out.println("product Price= "+product.getPrice());
				        	System.out.println("total= "+total);  		    				System.out.println("===============================================================");
  				        	 
  				         }
                          }
					


					
				}
				if(d==2){
			  System.out.println("===============================================================");
				String[] cate = pc.printcategory(productlist);
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
				        	pc.viewproductCategory(productlist, "Electronics");
				        	
				        }
				        if(b==2) {
				        	pc.viewproductCategory(productlist, "Interior");
				        }
				        if(b==3) {
				        	pc.viewproductCategory(productlist, "Exterior");

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
	       				        pc.searchproduct(productlist, y);
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

	  				        	product=product.informationProduct(productlist,y );
	  				        	orderedProducts.add(product);
	  				        	pc.countProducts(orderedProducts);
	  				        	double total=pc.totalprice(orderedProducts);
	  				        	System.out.println("product Price= "+product.getPrice());

					        	System.out.println("total= "+total);	  		    				System.out.println("===============================================================");
	  				        	 
	  				         }
	                          }
		        }

				        


				}
				if(d==3) {
	    				System.out.println("===============================================================");

				System.out.println("enter the product name: ");

					
					scanner=new Scanner(System.in);
					 String nameproduct=scanner.nextLine();	
					 if(pc.isexsist(productlist, nameproduct)) {
					int id= pc.searchproductname(productlist,nameproduct);
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

				        	product=product.informationProduct(productlist,id );
				        	orderedProducts.add(product);
				        	pc.countProducts(orderedProducts);
				        	double total=pc.totalprice(orderedProducts);
				        	System.out.println("product Price= "+product.getPrice());
				        	System.out.println("total= "+total);
		    				System.out.println("===============================================================");
				        	 
					
					 
					 }
	    		System.out.println("===============================================================");

					}
				}
				
                if(d==4) {
                	//user.viewprofile(email,userList);
                	user=user.informationUser(userList, email);
                	user.searchuser(userList, user.getName());
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
                       user=user.informationUser(userList, email) ;  
                      userList= user.updateUser(userList,user.getid(),name,user.getEmail(), user.getPassword(), user.getAge(), user.gettype());

                       }
                       if(c==2) {
                    	   
               		       System.out.println("new password: ");
               		      password=scanner.nextLine();
          	              password=scanner.nextLine();
          	             
                           user=user.informationUser(userList, email) ;  
                          userList= user.updateUser(userList,user.getid(),user.getName(),user.getEmail(), password, user.getAge(), user.gettype());
                           }
                       if(c==3) {
                    	   System.out.println("new email: ");
                 		     String  email2=scanner.nextLine();
            	              email2=scanner.nextLine();
            	              if(login.ifvalid(email2)) {
                             user=user.informationUser(userList, email) ;  
                              email=email2;
                              
                            userList= user.updateUser(userList,user.getid(),user.getName(),email, user.getPassword(), user.getAge(), user.gettype());
            	              }
                       }
                       if(c==4) {
                    	   System.out.println("new age: ");
                 		     String age2=scanner.nextLine();
            	              age2=scanner.nextLine();
                             user=user.informationUser(userList, email) ;  
                            userList= user.updateUser(userList,user.getid(),user.getName(),user.getEmail(), user.getPassword(),age2, user.gettype());

                       }
                       if(c==5) {
                    	   System.out.println("=====================================================");
                    	   System.out.println( "you logout successfully");
                    	   System.out.println("=====================================================");
                         islogin=false;
                	
                }


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
				System.out.println("3. log out");

				System.out.println("===================================================================================");

				 scanner=new Scanner(System.in);
 				int c=scanner.nextInt();
 				if(c==1) {
 					pc.printproducts(productlist);
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
        		 	  int id=  pc.countProducts(productlist);
        		 	   productlist=pc.addproducts(productlist,productname,description,price2,category,available);

                       }
                       else if(k==2) {
              				System.out.println("enter you product number: ");
                    	   scanner=new Scanner(System.in);
        	 				int l=scanner.nextInt(); 
        	 				productlist=pc.deleteproducts(productlist, l);	
                       }
                       else if(k==3) {
                    	   System.out.println("enter product name: ");
         	 	          String productname=scanner.nextLine();
         	 	        productname=scanner.nextLine();
         	 	          pc.searchproductname(productlist, productname);
         	 	       
                       }
                       else if(k==4) {
                    	   pc.printproducts(productlist);
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
         	 					product=product.informationProduct(productlist, o);
         	 					productlist=pc.updateproducts(productlist,product.getid() ,name, product.getDescription(), product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==2) {
         	 					 System.out.println("enter new description: ");
         	 			     String description=scanner.nextLine();
         	 			         description=scanner.nextLine();
         	 					product=product.informationProduct(productlist, o);
         	 					productlist=pc.updateproducts(productlist,product.getid() ,product.getName(), description, product.getPrice(), product.getCategory(), product.getAvailable());
         	 				}
         	 				if(f==3) {
         	 					 System.out.println("enter new price: ");
             	 			     String price=scanner.nextLine();
             	 			         price=scanner.nextLine();
             	 			         double price3=Double.valueOf(price);
             	 					product=product.informationProduct(productlist, o);
             	 					productlist=pc.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),price3, product.getCategory(), product.getAvailable());
             	 				
         	 				}
         	 				if(f==4) {
         	 					 System.out.println("enter if available or not : ");
             	 			     String available=scanner.nextLine();
             	 			          available=scanner.nextLine();
             	 					product=product.informationProduct(productlist, o);
             	 					productlist=pc.updateproducts(productlist,product.getid() ,product.getName(), product.getDescription(),product.getPrice(), product.getCategory(), available);
             	 				
         	 				
         	 				}
            				
         	 				
                       }
                     if(k==5) {
                    		System.out.println("enter you product number: ");
                     	   scanner=new Scanner(System.in);
         	 				int l=scanner.nextInt(); 
         	 				pc.searchproduct(productlist, l);
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
   	 					user.printUsers(userList);
   	 					
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
   	 	  userList= user.add(username, password, email2, age,userList);	
			System.out.println("===================================================================================");

   	 				}
   	 				if(l==3) {
   	 					user.printUsers(userList);
   	 				System.out.println("enter  user number you want to delete: ");
              	   scanner=new Scanner(System.in);
  	 				int e=scanner.nextInt(); 
   	 					userList=user.deleteuser(userList, e);
   	 					System.out.println("===================================================================================");

   	 				}
   	 				if(l==4) {
   	   	 		  System.out.println("enter  username: ");
   	 			 String username=scanner.nextLine();
   		          username=scanner.nextLine();
   		          user.searchuser(userList,username);
   		          
   	 				}
 				}
 				if(c==3) {
 					System.out.println("you logout successfully");
 					t=false;
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
	  userList= user.add(username, password, email, age,userList);	  
	}

}
       
       }
       
	}

	

