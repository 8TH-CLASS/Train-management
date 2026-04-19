import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String ,User> userMap = new HashMap() ;
    private User currentUser = null;

    public boolean registerUser (String username , String password , String fullname , String contact){
        if (userMap.containsKey(username)) {
            System.out.println("username already taken , Please choose another ");
            return false ;
        }
        User user =  new User(username , password , fullname, contact);
        if(!user.getPassword().equals(password)) {
            System.out.println("incorrect password");
            return false ;
        }
        currentUser = user ;
        System.out.println("WELCOME :" +currentUser.getFullname() + "!");
        return true ;

    }
    private void logoutUser () {
        if (currentUser != null) {
            System.out.println("logged out "+currentUser.getFullname()) ;
        }
        currentUser = null;
    }
 }
