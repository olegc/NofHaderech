package nofhaderech.nof.com.nofhaderech.bl;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import nofhaderech.nof.com.nofhaderech.models.User;


/**
 * Created by USER on 6/19/2017.
 */

public class DatabaseHandler {
    public static final String TAG = "DatabaseHandler";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    public DatabaseHandler() {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]
    }

    public void AddToDbRandomKey(String childObject, Object value) {
        String key = mDatabase.child(childObject).push().getKey();
        mDatabase.child(childObject + "/" + key).setValue(value);
    }

    public void AddToDB(String key, Object value) {
        // Create new user at /users/$userid
        //String key = mDatabase.child("users").push().getKey();
        //Map<String, Object> childUpdates = new HashMap<>();
        //childUpdates.put(key, value);
        //mDatabase.updateChildren(childUpdates);

        mDatabase.child(key).setValue(value);
    }

    public void IncreaseUserPoints(String userId) {
        mDatabase.child("/users/" + userId).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                User u = mutableData.getValue(User.class);
                if (u == null) {
                    return Transaction.success(mutableData);
                }
                u.points = u.points + 1;
                mutableData.setValue(u);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
                Log.d(TAG, "postTransaction:onComplete:" + databaseError);
            }
        });
    }

    public void RateUser(String userId, final int rating) {
        mDatabase.child("/users/" + userId).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                User u = mutableData.getValue(User.class);
                if (u == null) {
                    return Transaction.success(mutableData);
                }
                u.rating = u.rating * u.points + rating;
                mutableData.setValue(u);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
                Log.d(TAG, "postTransaction:onComplete:" + databaseError);
            }
        });
    }
//
//    public void temp(){
//        ReadFromDB("dfgdfg", new DatabaseResultCallback() {
//            @Override
//            public void HandleDatabaseResult(Object object) {
//
//            }
//        });
//    }
//
//
//    //public Object UpdateValueInDb (String key, final DatabaseResultCallback callback){
//    public Object UpdateValueInDb (String key, final Object newValue){
//        // Add all polls in ref as rows
//        final DatabaseResultCallback callback = new DatabaseResultCallback() {
//            @Override
//            public void HandleDatabaseResult(Object object) {
//                mDatabase.child(key).setValue(newValue);
//            }
//        }
//        mDatabase.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                UpdateSomething(snapshot.getValue(), callback);
//                //retVal = snapshot.getValue();
//                return;
////                for (DataSnapshot child : snapshot.getChildren()) {
//////                    System.out.println("inner:" + child.getValue());
////                    retVal = child.getValue();
////                    retVal = snapshot.getValue();
////                    return;
////                    //child.getValue();
////
////                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("Canceled");
//                // Getting Post failed, log a message
////                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        });
//
//        //return retVal;
//        //return mDatabase.child(key).getRef();
//        return null;
//    }
//
//    private void UpdateSomething(Object object, DatabaseResultCallback callback){
//        callback.HandleDatabaseResult(object);
//    }
//
//    public interface DatabaseResultCallback {
//        void HandleDatabaseResult(Object object);
//    }
}





