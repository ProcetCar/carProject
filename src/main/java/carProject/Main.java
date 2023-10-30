package carProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;




public class Main {
	static LOGIN login=new LOGIN();
	  private static  List<User> userList=Mydata.listUser();
	  private static  ProductCatalog pc=new ProductCatalog() ;
	private static  List<Product> productlist=Mydata.listProduct();
    private static List<Product> orderedProducts=new ArrayList<Product>();
  	private static String[] cate = new String[3];

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
				cate=pc.printcategory(productlist);
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
                	user.viewprofile(email,userList);
                	
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
	  user.printUsers(userList);
	}

}
       }
       
	}

	

