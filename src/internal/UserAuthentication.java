package internal;

import java.util.HashMap;
import java.util.Scanner;

public class UserAuthentication {
    public HashMap<User, String> users = new HashMap<>();

    public UserAuthentication(){
        User u1 = new User("Andrew", 1);
        users.put(u1, "Andrew");
    }

    public boolean authenticateUser(Integer uuid){
        Scanner scan = new Scanner(System.in);
        User authUser = new User("", uuid);
        if (users.containsKey(authUser)){
            System.out.println("UUID already exists");
            return false;
        }
        else{
            System.out.println("Creating user with UUID " + uuid);
            String username = scan.nextLine();
            User user = new User(username, uuid);
            users.put(user, username);
            return true;
        }
    }
}
