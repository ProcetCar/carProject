package carProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductCatalog {
   

	// List to store products
    private List<Product> products=new ArrayList<Product>();
    
    public ProductCatalog() {
		super();
		// TODO Auto-generated constructor stub
	}
    // Constructor to initialize the list of products
    public ProductCatalog(List<Product> products) {
        this.products = products;
    }


	// Method to add a new product to the catalog
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to update product information
    public void updateProduct(Product product) {
        // Implementation to update product information
    }

    // Method to delete a product from the catalog
    public void deleteProduct(String productName) {
    	for (Product product : products) {
            if (product.getName().equals(productName)) {
                products.remove(product);
            }
        }
    }

    // Method to get a list of products in a specific category
    public List<Product> getProductsByCategory(String category) {
    	  List<Product> productsInCategory = new ArrayList<Product>();
          for (Product product : products) {
              if (product.getCategory().equalsIgnoreCase(category)) {
                  productsInCategory.add(product);
              }
          }
          return productsInCategory;
    }

    // Method to retrieve detailed information about a product
    public Product getProductDetails(String  productName) {
    	  for (Product product : products) {
              if (product.getName().equalsIgnoreCase(productName)) {
                  return product;
              }
          }
          return null; // Product not found
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
		 for (Product product : productlist) {
             if (product.getName().equals(string)) {
            	 productlist.remove(product);
            	 break;
             }
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
		 for (Product product : productlist) {

	         String s=product.getName()+","+product.getCategory();
	        		 
	            	 System.out.println(s);
	             
	         }		
	}
	public List<Product> removeRepeated(List<Product> productlist) {
        HashSet<Product> uniqueSet = new HashSet<>();

        List<Product> uniqueList = new ArrayList<>();

        for (Product item : productlist) {
            if (uniqueSet.add(item)) {
                uniqueList.add(item);
            }
        }
        return productlist;
        
	}
	
}

