package carProject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LOGIN {
    private static final Logger LOGGER = Logger.getLogger(LOGIN.class.getName());
    private String enteredEmail;
    private String enteredPassword;
    private static String tyu = "";

    public boolean run(int p) {
        return p == 1;
    }

    public void navigateToLoginPage(String email, String password, List<User> userlist) {
        enteredPassword = password;
        enteredEmail = email;

        if (performLogin(enteredEmail, enteredPassword, userlist)) {
            LOGGER.info("Login successful.\n\n");
        } else {
            LOGGER.info("Invalid email or password. Please try again.");
        }
    }

    public boolean performLogin(String email, String password, List<User> userlist) {
        for (User user : userlist) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                tyu = user.gettype();
                return true;
            }
        }
        return false;
    }

    public boolean getA() {
        return tyu.equals("Admin");
    }

    public boolean geti() {
        return tyu.equals("installer");
    }

    public boolean getc() {
        return tyu.equals("customer");
    }

    public boolean checkIfRegister(String email, List<User> userlist) {
        for (User user : userlist) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean ifvalid(String string) {
        if (string.equals("") || !string.contains("@gmail.com")) {
            LOGGER.info("invalid email, please try again...");
            return false;
        }
        return true;
    }
}




