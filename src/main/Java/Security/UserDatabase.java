package Security;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserDatabase implements Serializable {
    private ArrayList<User> usersList;

    public UserDatabase() {
        this.usersList = new ArrayList<>();
    }

    public void add(User user){
        if(!usersList.contains(user)){
            usersList.add(user);
        }
    }
}
