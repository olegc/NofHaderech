package nofhaderech.nof.com.nofhaderech.bl;

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
    public void SetRatingForRide(String userId, int rating){
        dbHandler.RateUser(userId, rating);
    }
}
