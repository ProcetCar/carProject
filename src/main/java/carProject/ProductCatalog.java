package carProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductCatalog {
   

    private List<Product> products=new ArrayList<Product>();
    
    public ProductCatalog() {
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
	public List<Product> updateproducts(List<Product> productlist, String productname, String description, double price,
			String category, String available) {
		 for (Product product : productlist) {
             if (product.getName().equals(productname)) {
            	 product.setDescription(description);
            	 product.setPrice(price);
            	 product.setcategory(category);
            	 product.setAvailable(available);
             }
         }
				return productlist;
		
		
	}
	public List<Product> deleteproducts(List<Product> productlist, String string) {
		 int i=0;
		for (Product product : productlist) {
             if (product.getName().equals(string)) {
            	 productlist.remove(product);
            	 break;
             }
         }
		 for (Product product : productlist) {
           i++;
           product.setid(i);
         }
				return productlist;
	}
	public List<Product> deletecategory(List<Product> productlist, String string) {
		for (Product product : productlist) {
            if (product.getCategory().equals(string)) {
           	 productlist.remove(product);
           	 continue;
           	
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








	public void viewproductCategory(List<Product> productlist, String category) {
     	 System.out.println("==================================================================");

		for (Product product : productlist) {
           if(product.getCategory().equals(category)) {
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
			if(product.getCategory().equals(category)) {
				
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
	public  void searchproduct(List<Product> productlist, int id) {

		for (Product product : productlist) {
			if(product.getid()==id) {
				 System.out.println("Name: " + product.getName());
			        System.out.println("Description: " + product.getDescription());
			        System.out.println("Category: " + product.getCategory());
			        System.out.println("Price: " + product.getPrice());
			        System.out.println("Availability: " + product.getAvailable());
			        break;
			}
        }
		
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
		   
			if(product.getName().equals(nameproduct)) {
               id=product.getid();
				 System.out.println("Name: " + product.getName());
			        System.out.println("Description: " + product.getDescription());
			        System.out.println("Category: " + product.getCategory());
			        System.out.println("Price: " + product.getPrice());
			        System.out.println("Availability: " + product.getAvailable());
			        break;
			}
		}
		return id;
	}
	
	
}

