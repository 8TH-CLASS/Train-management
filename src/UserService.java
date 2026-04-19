import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap = new HashMap<>();
    private User currentUser = null;

    public boolean registerUser(String username, String password, String fullname, String contact) {
        if (userMap.containsKey(username)) {
            System.out.println("Username already taken, please choose another");
            return false;
        }
        User user = new User(username, password, fullname, contact);
        userMap.put(username, user);   // BUG 1 FIX — save user into the map
        currentUser = user;
        System.out.println("WELCOME: " + currentUser.getFullname() + "!");
        return true;
    }

    public boolean loginUser(String username, String password) {
        if (!userMap.containsKey(username)) {
            System.out.println("No user found with this username");
            return false;
        }
        User user = userMap.get(username);   // BUG 2 FIX — fetch user and verify password
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect password");
            return false;
        }
        currentUser = user;
        System.out.println("WELCOME BACK: " + currentUser.getFullname() + "!");
        return true;
    }

    void logoutUser() {
        if (currentUser != null) {
            System.out.println("Logged out: " + currentUser.getFullname());
        }
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}