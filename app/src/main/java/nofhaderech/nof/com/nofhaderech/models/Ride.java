package nofhaderech.nof.com.nofhaderech.models;

/**
 * Created by USER on 6/19/2017.
 */

public class Ride {
    public String user_id;
    public RideDetails rideDetails;

    public Ride(String user_id, RideDetails rideDetails) {
        this.user_id = user_id;
        this.rideDetails = rideDetails;
    }
}
