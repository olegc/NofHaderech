package nofhaderech.nof.com.nofhaderech.bl;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by USER on 6/19/2017.
 */

public class DatabaseHandler {


    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    public DatabaseHandler(){
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]
    }

    public void AddToDbRandomKey (String childObject, Object value){
        String key = mDatabase.child(childObject).push().getKey();
        mDatabase.child(childObject + "/" + key).setValue(value);
    }

    public void AddToDB (String key, Object value){
        // Create new user at /users/$userid
        //String key = mDatabase.child("users").push().getKey();
        //Map<String, Object> childUpdates = new HashMap<>();
        //childUpdates.put(key, value);
        //mDatabase.updateChildren(childUpdates);

        mDatabase.child(key).setValue(value);
    }

    public Object ReadFromDB (String key){
        return null;
        //return mDatabase.child(key).getRef();
    }
}