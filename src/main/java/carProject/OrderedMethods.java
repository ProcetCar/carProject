package carProject;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class OrderedMethods {
    private static final Logger LOGGER = LogManager.getLogger(OrderedMethods.class);

	public  int countorder(List<Product> orderedProducts) {
		int i=0;
		for(Product prduct: orderedProducts) {
			i++;
		}
		return i+1;
	}
	
	public  double searchorder(String productpurchase, List<Product> orderedProducts) {
            for (Product product:orderedProducts) {
	             if(product.getName().equals(productpurchase)) {
	            	 return product.getPrice();
	            	 }
                      }
		return 0;
	}
	public  boolean ifAvailable(Order order) {
     UserMethods um=new UserMethods() ;
	     List<Product> products=order.getOrderedProducts();
	     List<User> Allusers=Mydata.listUser();


	     for (Product product : products) {
			   
				if(product.getAvailable().equalsIgnoreCase("not available") ||! um.isexsist(Allusers, order.getCustomerId())) {
					
				        return false;
				}
	}
	     
			return true;

	}

	public  Order changeStatus(Order order, boolean available) {
if(available) {
	order.setOrderStatus("coniformed");
}
else {
	order.setOrderStatus("canceled");

}
return order;
	}
	public  int count(List<Order> requests) {
		int count=1;
		
		 for (Order request : requests) {
			count++;   
				
	       }
		
		return count;
	
	}

	public  String message(boolean f) {
		String s="";
		if(f) {
			s="order is coniformed";
		}
		else {
		
			s="order is canceled";
		}
	
		return s;

	}
    public  void vieworder(List<Order> requests, int id_customer) {
        ProductMethods pm = new ProductMethods();

        for (Order request : requests) {
            if (request.getCustomerid() == id_customer) {
                LOGGER.info("=====================================================");
                LOGGER.info("id:" + request.getOrderid());
                for (Product product : request.getOrderedProducts()) {
                    LOGGER.info("Name: " + product.getName());
                }
                LOGGER.info("total price:" + pm.totalprice(request.getOrderedProducts()));
                LOGGER.info("Date:" + request.getOrderDate());
                LOGGER.info("status:" + request.getOrderStatus());
                LOGGER.info("=====================================================");
            }
        }
    }

	
	
public  void vieworder(List<Order> requests) {
        ProductMethods pm = new ProductMethods();

        for (Order request : requests) {
            LOGGER.info("=====================================================");
            LOGGER.info("order id: " + request.getOrderid());
            LOGGER.info("for customer with id:" + request.getCustomerid());
            for (Product product : request.getOrderedProducts()) {
                LOGGER.info("Name: " + product.getName());
            }
            LOGGER.info("total price:" + pm.totalprice(request.getOrderedProducts()));
            LOGGER.info("Date:" + request.getOrderDate());
            LOGGER.info("status:" + request.getOrderStatus());
            LOGGER.info("Email:" + request.getEmail());
            LOGGER.info("city:" + request.getCity());
            LOGGER.info("street:" + request.getStreet());
            LOGGER.info("=====================================================");
        }
    }

	public  List<Order> checkRequest(List<Order> requests) {
		String status="";
		 for (Order request : requests) {
	
				boolean f=ifAvailable(request);
				  request=changeStatus(request,f);
			 	 status=message(f);
			  SendMail.getSendEmail(status, request.getEmail()); 

			   }
	 	

	
		 return requests;
	
	}

	public  List<Order> setDate(List<Order> requests, int j, Date date) {
		 for (Order request : requests) {
			 if(request.getOrderid()==j) {
				 request.setDate(date);
			 }
			 
		 }	
		return requests;
	}

	public  String getEmailForOrder(List<Order> requests, int j) {
String email="";
for (Order request : requests) {
	if(request.getOrderid()==j) {
		email=request.getEmail();
	}
}
return email;
	}



}
