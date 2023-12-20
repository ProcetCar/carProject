package carProject;

import java.util.List;

public class Product {
    private String name;
    private String description;
    private double price;
    private String category;
    private String available;
    private int id;
    private String image;

   
    public Product( int id,String name, String description, double price, String category, String available,String image) {
        
    	this.id=id;
    	this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
        this.image=image;
    }

      

    public Product() {
    	super();
	}


    public String getimage() {
        return image;
    }
	public String getName() {
        return name;
    }

    public int getid() {
        return id;
    }
    public String getDescription() {
        return description;
    }


    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
    public void setid(int id) {
        this.id = id;
    }
    
 


    public void displayProductDetails() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + available);
}



	public void setDescription(String description) {
        this.description = description;

	}



	public void setPrice(double price) {
        this.price = price;
	}



	public void setcategory(String category) {
        this.category = category;
	}




public void setName(String productname) {
this.name=productname;	
}
    
}

