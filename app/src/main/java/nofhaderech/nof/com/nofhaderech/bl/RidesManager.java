package nofhaderech.nof.com.nofhaderech.bl;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import nofhaderech.nof.com.nofhaderech.models.Ride;
import nofhaderech.nof.com.nofhaderech.models.User;

/**
 * Created by USER on 6/19/2017.
 */

public class RidesManager
{
    private String MatchedDriver;
    private String TokenId;

    public RidesManager(){
    }

    public void AddRideRequest(final Ride ride)
    {
        if(ride == null) return;
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("/ridesOffers/").runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                if(mutableData == null || mutableData.getValue() == null)
                    return Transaction.success(mutableData);

                boolean findMatch = false;
                for (MutableData child : mutableData.getChildren()) {
                    Ride driver = child.getValue(Ride.class);
                    if (driver == null) {
                        return Transaction.success(mutableData);
                    }

                    // find match
                    boolean hasMatch = driver.IsSameRideDetails(ride);
                    if(hasMatch)
                    {
                        MatchedDriver = driver.getKey();

                        String table = "/matchesFromRiderToDriver/" + ride.user_id +"/" + driver.user_id + "/token_id";
                        FindToken(table, driver.user_id);

                        findMatch = true;
                        break;
                    }
                }
                if(!findMatch) {
                    // no match
                    mDatabase.child("/ridesRequests/" + ride.getKey()).setValue(ride);
                    return Transaction.success(mutableData);
                }
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
                Log.d(DatabaseHandler.TAG, "AddRideRequest:onComplete:" + databaseError);
                mDatabase.child("/ridesOffers/" + MatchedDriver).removeValue();
            }
        });
    }

    public void AddRideOffer(final Ride ride)
    {
        if(ride == null) return;
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("/ridesRequests/").runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                if(mutableData == null || mutableData.getValue() == null)
                    return Transaction.success(mutableData);

                for (MutableData child : mutableData.getChildren()) {
                    Ride rider = child.getValue(Ride.class);
                    if (rider == null) {
                        return Transaction.success(mutableData);
                    }

                    // find match
                    boolean hasMatch = rider.IsSameRideDetails(ride);
                    if(hasMatch)
                    {
                        mDatabase.child("/ridesRequests/" + rider.getKey()).removeValue();

                        String table = "/matchesFromDriverToRider/" + ride.user_id +"/" + rider.user_id  + "/token_id";
                        FindToken(table, rider.user_id);

                        return Transaction.success(mutableData);
                    }
                }
                // no match
                mDatabase.child("/ridesOffers/" + ride.getKey()).setValue(ride);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
                Log.d(DatabaseHandler.TAG, "AddRideOffer:onComplete:" + databaseError);
            }
        });
    }

    private void FindToken(final String table, final String user_id) {
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("/users/" + user_id).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                User u = mutableData.getValue(User.class);
                if (u == null) {
                    return Transaction.success(mutableData);
                }
                TokenId = u.token_id;
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
                mDatabase.child(table).setValue(TokenId);
                Log.d(DatabaseHandler.TAG, "postTransaction:onComplete:" + databaseError);
            }
        });
    }
}
