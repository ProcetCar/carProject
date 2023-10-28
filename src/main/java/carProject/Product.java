package carProject;
 
public class Product {
    private String name;
    private String description;
    private double price;
    private String category;
    private String available;

   
    public Product( String name, String description, double price, String category, String available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
    }

      

    public String getName() {
        return name;
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

    
    public void updateProduct(String name, String description, double price, String category, String available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
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
    
}

