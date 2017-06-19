package nofhaderech.nof.com.nofhaderech.bl;

import java.util.Date;
import java.util.GregorianCalendar;

import nofhaderech.nof.com.nofhaderech.models.Ride;
import nofhaderech.nof.com.nofhaderech.models.RideDetails;
import nofhaderech.nof.com.nofhaderech.models.User;

/**
 * Created by USER on 6/19/2017.
 */

public class DbMockifier {

    public void InitializeDB()
    {
        try {
            testAddUser();
            testAddRideOffer();
            testAddRideRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testAddUser() throws Exception {
        UsersManager manager = new UsersManager();
        manager.AddUser(new User("OrenShm", "0509218146", "Carmelia", "Rafael", 0, 0));
    }

    public void testAddRideOffer() throws Exception {
        RidesManager manager = new RidesManager();

        Date from = new GregorianCalendar(2017,6,20,17,00,00).getTime();
        Date to = new GregorianCalendar(2017,6,20,17,30,00).getTime();

        manager.AddRideOffer(new Ride("OrenShm", new RideDetails("Rafael", "Carmelia", from, to)));
        manager.AddRideOffer(new Ride("OrenShm2", new RideDetails("Rafael", "Carmelia", from, to)));

    }

    public void testAddRideRequest() throws Exception {
        RidesManager manager = new RidesManager();

        Date from = new GregorianCalendar(2017,6,20,17,00,00).getTime();
        Date to = new GregorianCalendar(2017,6,20,17,30,00).getTime();
        manager.AddRideRequest(new Ride("Nir Amar", new RideDetails("Rafael", "Carmelia", from, to)));
    }
}
