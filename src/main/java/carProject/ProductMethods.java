package carProject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductMethods {
   
    
    public ProductMethods() {
		super();
	}
    



    


      
	public boolean isexsist(List<Product> productlist, String string) {
		String productname=string;
		String productcategory=string;
		 for (Product product : productlist) {
             if (product.getName().equals(productname)||product.getCategory().equals(productcategory)) {
                 return true;
             }
         }
         return false;		
	}
	public List<Product> updateproducts(List<Product> productlist,int id, String productname, String description, double price,
			String category, String available) {
		 for (Product product : productlist) {
			 if(product.getid()==id) {
             product.setName(productname);
            	 product.setDescription(description);
            	 product.setPrice(price);
            	 product.setcategory(category);
            	 product.setAvailable(available);
			 }
         }
				return productlist;
		
		
	}
	public List<Product> deleteproducts(List<Product> productlist, int id) {
		 int i=0;
		for (Product product : productlist) {
             if (product.getid()==id) {
            	 productlist.remove(product);
            	 System.out.println("deleted successfully");
            	 System.out.println("============================================================");

            	 break;
             }
         }
		 for (Product product : productlist) {
           i++;
           product.setid(i);
         }
				return productlist;
	}
	public List<Product> addproducts(List<Product> productlist,String productname, String description, double price,
			String category, String available ) {
	 	  int id=countProducts(productlist);
		productlist.add(new Product(id,productname,description,price,category,available,""));
		System.out.println("==========================================================================");
		System.out.println("added successfully");
		System.out.println("==========================================================================");

		return productlist;
	}
	public List<Product> deletecategory(List<Product> productlist, String string) {
		for (Product product : productlist) {
            if (product.getCategory().equalsIgnoreCase(string)) {
           	 productlist.remove(product);
           	
            }
        }
				return productlist;
	}
	public void printproducts(List<Product> productlist) {
      	 System.out.println("==================================================================");

		 for (Product product : productlist) {

                  
	        // String s=String.valueOf(product.getid())+". "+"product name: "+product.getName()+", "+"product Description: "+product.getDescription()+", "+"product Category: "+product.getCategory()+", "+"product price: "+product.getPrice()+", "+"product Available: "+product.getAvailable();
	            	String s=String.valueOf(product.getid())+". "+"product name: "+product.getName();
			 System.out.println(s);
	            
	         }	
       	 System.out.println("==================================================================");

	}
	public int countProducts(List<Product> productlist) {
		int i=0;
		 for (Product product : productlist) {
           i++;       
        }
		 i++;
		return i;
	}

public Product informationProduct(List<Product> productlist,int id) {
		

		for (Product product : productlist) {
            if (product.getid()==id) {
            return product;	  
            }
            
        }
		return null;
	
	}






	public void viewproductCategory(List<Product> productlist, String category) {
     	 System.out.println("==================================================================");

		for (Product product : productlist) {
           if(product.getCategory().equalsIgnoreCase(category)) {
        	  // String s=String.valueOf(product.getid())+". "+"product name: "+product.getName()+", "+"product Description: "+product.getDescription()+", "+"product Category: "+product.getCategory()+", "+"product price: "+product.getPrice()+", "+"product Available: "+product.getAvailable();
          	  String s=String.valueOf(product.getid())+". "+"product name: "+product.getName();
        	   System.out.println(s);
}
		}
     	 System.out.println("==================================================================");

			
	}
	








	public String[] printcategory(List<Product> productlist) {
        Set<String> uniqueCategories = new HashSet<>();
        for (Product product : productlist) {
            uniqueCategories.add(product.getCategory());
        }
      System.out.println("==================================================================");
  	String[] cate = new String[3];
int i=0;
int j=i+1;
        for (String category : uniqueCategories) {
        	System.out.print(j+". ");
            System.out.println(category);
            cate[i]=category;
            i++;
            j=i+1;
        }
      System.out.println("==================================================================");

		return cate;
	}







	public List<Product> searchcategory(List<Product> productlist, String category) {
	    List<Product> productlist2=new ArrayList<Product>();

		for (Product product : productlist) {
			if(product.getCategory().equalsIgnoreCase(category)) {
				
				productlist2.add(product);
			}
        }
		int i=1;
		for (Product product : productlist2) {
			product.setid(i);
			i++;
        }
		
		
		return productlist2;
	}
	public  boolean searchproduct(List<Product> productlist, int id) {

		for (Product product : productlist) {
			if(product.getid()==id) {
				 System.out.println("Name: " + product.getName());
			        System.out.println("Description: " + product.getDescription());
			        System.out.println("Category: " + product.getCategory());
			        System.out.println("Price: " + product.getPrice());
			        openimage(product.getimage());
			        return true;
			}
        }
		return false;
		
	}
	
	
		
	








	public double totalprice(List<Product> orderedProducts) {
double sum=0;
for (Product product : orderedProducts) {
	sum=product.getPrice()+sum;
}
		return sum;
	}








	public int searchproductname(List<Product> productlist, String nameproduct) {
		int id = 0;
		for (Product product : productlist) {
		   
			if(product.getName().equalsIgnoreCase(nameproduct)) {
               id=product.getid();
				 System.out.println("Name: " + product.getName());
			        System.out.println("Description: " + product.getDescription());
			        System.out.println("Category: " + product.getCategory());
			        System.out.println("Price: " + product.getPrice());
			        openimage(product.getimage());

			        break;
			}
		}
		return id;
	}








	public void openimage(String imagePath) {
		// Check if Desktop is supported on the current platform
	       if (Desktop.isDesktopSupported()) {
	           Desktop desktop = Desktop.getDesktop();
	           try {
	               File imageFile = new File(imagePath);
	               desktop.open(imageFile);

	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	       } else {
	           System.out.println("Desktop not supported.");
	       }
		
	}
	
	
}

