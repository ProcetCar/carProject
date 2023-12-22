package carProject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.logging.Logger;


public class ProductMethods {
       private static final Logger LOGGER = Logger.getLogger(ProductMethods.class.getName());

    
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
        int i = 0;
        for (Product product : productlist) {
            if (product.getid() == id) {
                productlist.remove(product);
                LOGGER.info("Deleted successfully");
                LOGGER.info("============================================================");
                break;
            }
        }
        for (Product product : productlist) {
            i++;
            product.setid(i);
        }
        return productlist;
    }
	 public List<Product> addproducts(List<Product> productlist, String productname, String description, double price, String category, String available) {
        int id = countProducts(productlist);
        productlist.add(new Product(id, productname, description, price, category, available, ""));
        LOGGER.info("==========================================================================");
        LOGGER.info("Added successfully");
        LOGGER.info("==========================================================================");
        return productlist;
    }
	public List<Product> deletecategory(List<Product> productlist, String string) {
		List<Product> toRemove = new ArrayList<>();
    for (Product product : productlist) {
        if (product.getCategory().equalsIgnoreCase(string)) {
            toRemove.add(product);
        }
    }
    productlist.removeAll(toRemove);
    return productlist;

	}
	public void printproducts(List<Product> productlist) {
        LOGGER.info("==================================================================");
        for (Product product : productlist) {
            String s = String.valueOf(product.getid()) + ". " + "product name: " + product.getName();
            LOGGER.info(s);
        }
        LOGGER.info("==================================================================");
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
        LOGGER.info("==================================================================");
        for (Product product : productlist) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                String s = String.valueOf(product.getid()) + ". " + "product name: " + product.getName();
                LOGGER.info(s);
            }
        }
        LOGGER.info("==================================================================");
    }
	








	public String[] printcategory(List<Product> productlist) {
        Set<String> uniqueCategories = new HashSet<>();
        for (Product product : productlist) {
            uniqueCategories.add(product.getCategory());
        }
        LOGGER.info("==================================================================");
        String[] cate = new String[uniqueCategories.size()];
        int i = 0;
        int j = i + 1;
        for (String category : uniqueCategories) {
            LOGGER.info(j + ". " + category);
            cate[i] = category;
            i++;
            j = i + 1;
        }
        LOGGER.info("==================================================================");
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
	public boolean searchproduct(List<Product> productlist, int id) {
        for (Product product : productlist) {
            if (product.getid() == id) {
                LOGGER.info("Name: " + product.getName());
                LOGGER.info("Description: " + product.getDescription());
                LOGGER.info("Category: " + product.getCategory());
                LOGGER.info("Price: " + product.getPrice());
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
            if (product.getName().equalsIgnoreCase(nameproduct)) {
                id = product.getid();
                LOGGER.info("Name: " + product.getName());
                LOGGER.info("Description: " + product.getDescription());
                LOGGER.info("Category: " + product.getCategory());
                LOGGER.info("Price: " + product.getPrice());
                openimage(product.getimage());
                break;
            }
        }
        return id;
    }








	 public void openimage(String imagePath) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                File imageFile = new File(imagePath);
                desktop.open(imageFile);
            } catch (IOException e) {
                LOGGER.severe("Error opening image: " + e.getMessage());
            }
        } else {
            LOGGER.warning("Desktop not supported.");
        }
    }
	
	
}

