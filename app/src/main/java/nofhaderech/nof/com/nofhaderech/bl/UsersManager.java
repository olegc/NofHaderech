package nofhaderech.nof.com.nofhaderech.bl;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;

import nofhaderech.nof.com.nofhaderech.models.Ride;
import nofhaderech.nof.com.nofhaderech.models.User;

/**
 * Created by USER on 6/19/2017.
 */

public class UsersManager {
    private DatabaseHandler dbHandler;

    public UsersManager()
    {
        dbHandler = new DatabaseHandler();
    }

    public void AddUser(User user) {
        dbHandler.AddToDB("/users/" + user.id, user);
    }

    public void SetHomeAddr(String userId, String home_addr){
        dbHandler.AddToDB("/users/" + userId + "/home_addr", home_addr);
    }

    public void SetWorkAddr(String userId, String work_addr){
        dbHandler.AddToDB("/users/" + userId + "/work_addr", work_addr);
    }

    public void AddPointsForRide(String userId){
        dbHandler.IncreaseUserPoints(userId);
    }
    public void RateDriver(String driverId, int rating){
        dbHandler.RateUser(driverId, rating);
    }

    public boolean IsUserExists(final User u)
    {
        boolean isExist = false;
        if(u == null) return isExist;
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Query filterQuery  = mDatabase.child("/users/").orderByChild("type").equalTo(true);
        if (filterQuery != null) {
            isExist = true;
        }
        return isExist;
    }
}
