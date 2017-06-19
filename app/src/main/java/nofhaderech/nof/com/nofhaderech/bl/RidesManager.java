package nofhaderech.nof.com.nofhaderech.bl;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import nofhaderech.nof.com.nofhaderech.models.Ride;

/**
 * Created by USER on 6/19/2017.
 */

public class RidesManager {
    private DatabaseHandler dbHandler;

    public RidesManager()
    {
        dbHandler = new DatabaseHandler();
    }

    public void AddRideRequest(Ride ride) {
        dbHandler.AddToDbRandomKey("/ridesRequests", ride);
    }

    public void AddRideOffer(Ride ride) {
        dbHandler.AddToDbRandomKey("/ridesOffers", ride);
    }
}
