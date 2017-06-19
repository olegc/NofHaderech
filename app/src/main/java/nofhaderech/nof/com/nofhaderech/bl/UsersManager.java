package nofhaderech.nof.com.nofhaderech.bl;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import nofhaderech.nof.com.nofhaderech.models.User;

/**
 * Created by USER on 6/19/2017.
 */

public class UsersManager {
    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    public UsersManager()
    {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]
    }

    public void AddUser(User user) {
        // Create new user at /users/$userid
        //String key = mDatabase.child("users").push().getKey();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + user.id, user);
        mDatabase.updateChildren(childUpdates);
    }

    public void SetHomeAddr(String userId, String home_addr){

    }
    public void SetWorkAddr(String userId, String work_addr){

    }
    public void AddPointsForRide(String userId){

    }
    public void SetRatingForRide(String userId, int rating){

    }
}
