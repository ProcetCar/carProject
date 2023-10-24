package carProject;

import java.util.ArrayList;
import java.util.List;

public class Signup {
   private List<User> userlist=new ArrayList<User>();

	public boolean run(int p) {
        return p == 1;
    }
	public void add(String username,String password,String email,String age) {
		userlist.add(new User(username,email,password,"customer",age));	
	      User.userList.add(new User(username,email,password,"customer",age));
			}
}
