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

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]
    public RidesManager()
    {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]
    }

    public void AddRideRequest(Ride ride) {
        String key = mDatabase.child("ridesRequests").push().getKey();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/ridesRequests/" + key, ride);
        mDatabase.updateChildren(childUpdates);
    }

    public void AddRideOffer(Ride ride) {
        String key = mDatabase.child("ridesOffers").push().getKey();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/ridesOffers/" + key, ride);
        mDatabase.updateChildren(childUpdates);
    }
}
