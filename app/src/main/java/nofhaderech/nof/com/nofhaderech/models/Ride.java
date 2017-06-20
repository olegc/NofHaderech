package nofhaderech.nof.com.nofhaderech.models;

/**
 * Created by USER on 6/19/2017.
 */

public class Ride {
    public String user_id;
    public RideDetails rideDetails;

    public Ride(){
        rideDetails = new RideDetails();
    }

    public Ride(String user_id, RideDetails rideDetails) {
        this.user_id = user_id;
        this.rideDetails = rideDetails;
    }

    public boolean IsSameRideDetails(Ride ride)
    {
        return rideDetails != null ? rideDetails.equals(ride.rideDetails) : ride.rideDetails == null;
    }

    public String getKey() {
        return String.valueOf(hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (user_id != null ? !user_id.equals(ride.user_id) : ride.user_id != null) return false;
        return rideDetails != null ? rideDetails.equals(ride.rideDetails) : ride.rideDetails == null;

    }

    @Override
    public int hashCode() {
        int result = user_id != null ? user_id.hashCode() : 0;
        result = 31 * result + (rideDetails != null ? rideDetails.hashCode() : 0);
        return result;
    }
}
