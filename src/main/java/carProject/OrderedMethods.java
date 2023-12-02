package carProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderedMethods {

	public static int countorder(List<Product> orderedProducts) {
		int i=0;
		for(Product prduct: orderedProducts) {
			i++;
		}
		return i+1;
	}
	
	public static double searchorder(String productpurchase, List<Product> orderedProducts) {
            for (Product product:orderedProducts) {
	             if(product.getName().equals(productpurchase)) {
	            	 return product.getPrice();
	            	 }
                      }
		return 0;
	}
	public static boolean ifAvailable(Order order) {
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

	public static Order changeStatus(Order order, boolean available) {
if(available) {
	order.setOrderStatus("coniformed");
}
else {
	order.setOrderStatus("canceled");

}
return order;
	}
	public static int count(List<Order> requests) {
		int count=1;
		
		 for (Order request : requests) {
			count++;   
				
	       }
		
		return count;
	
	}

	public static String message(boolean f) {
		String s="";
		if(f) {
			s="order is coniformed";
		}
		else {
		
			s="order is canceled";
		}
	
		return s;

	}

	public static void vieworder(List<Order> requests,int id_customer) {
		    ProductMethods pm=new ProductMethods() ;

		 for (Order request : requests) {
        if(request.getCustomerid()==id_customer) {
     	   System.out.println("=====================================================");
    	   System.out.println("id:"+request.getOrderId());
    		 for (Product product : request.getOrderedProducts()){
				 System.out.println("Name: " + product.getName());
    		   }
    		 System.out.println("total price:"+pm.totalprice(request.getOrderedProducts()));
    	   System.out.println("Date:"+request.getOrderDate());
    	   System.out.println("status:"+request.getOrderStatus());
    	  
     	   System.out.println("=====================================================");
  
        }
		
	}
	}
	
	
	public static void vieworder(List<Order> requests) {
	    ProductMethods pm=new ProductMethods() ;

	 for (Order request : requests) {
    
 	   System.out.println("=====================================================");
		 System.out.println("order id: " + request.getOrderid());

	   System.out.println("for custmer with id:"+request.getCustomerid());
		 for (Product product : request.getOrderedProducts()){
			 System.out.println("Name: " + product.getName());
		   }
		 System.out.println("total price:"+pm.totalprice(request.getOrderedProducts()));
	   System.out.println("Date:"+request.getOrderDate());
	   System.out.println("status:"+request.getOrderStatus());
	   System.out.println("Email:"+request.getEmail());
	   System.out.println("city:"+request.getCity());
	   System.out.println("street:"+request.getStreet());
 	   System.out.println("=====================================================");
    
    
	
}
	 
	 
	 
	 
}

	public static List<Order> checkRequest(List<Order> requests) {
		String status="";
		 for (Order request : requests) {
	
				boolean f=OrderedMethods.ifAvailable(request);
				  request=OrderedMethods.changeStatus(request,f);
			 	 status=OrderedMethods.message(f);
			  SendMail.getSendEmail(status, request.getEmail()); 

			   }
	 	

	
		 return requests;
	
	}

	public static List<Order> setDate(List<Order> requests, int j, Date date) {
		 for (Order request : requests) {
			 if(request.getOrderid()==j) {
				 request.setDate(date);
			 }
			 
		 }	
		return requests;
	}

	public static String getEmailForOrder(List<Order> requests, int j) {
String email="";
for (Order request : requests) {
	if(request.getOrderid()==j) {
		email=request.getEmail();
	}
}
return email;
	}



}
