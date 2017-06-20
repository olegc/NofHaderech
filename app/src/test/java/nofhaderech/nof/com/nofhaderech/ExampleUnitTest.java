package nofhaderech.nof.com.nofhaderech;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import nofhaderech.nof.com.nofhaderech.bl.RidesManager;
import nofhaderech.nof.com.nofhaderech.bl.UsersManager;
import nofhaderech.nof.com.nofhaderech.models.Ride;
import nofhaderech.nof.com.nofhaderech.models.RideDetails;
import nofhaderech.nof.com.nofhaderech.models.User;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void InitializeDB() throws Exception
    {
        testAddUser();
        testAddRideOffer();
        testAddRideRequest();
    }

    @Test
    public void testAddUser() throws Exception {
        UsersManager manager = new UsersManager();
        manager.AddUser(new User("OrenShm", "0509218146", "Carmelia", "Rafael", ""));
    }

    @Test
    public void testAddRideOffer() throws Exception {
        RidesManager manager = new RidesManager();

        Date from = new GregorianCalendar(2017,6,20,17,00,00).getTime();
        Date to = new GregorianCalendar(2017,6,20,17,30,00).getTime();
        manager.AddRideOffer(new Ride("OrenShm", new RideDetails("Rafael", "Carmelia", from, to)));
    }

    @Test
    public void testAddRideRequest() throws Exception {
        RidesManager manager = new RidesManager();

        Date from = new GregorianCalendar(2017,6,20,17,00,00).getTime();
        Date to = new GregorianCalendar(2017,6,20,17,30,00).getTime();
        manager.AddRideRequest(new Ride("Nir Amar", new RideDetails("Oren's Work", "Carmelia", from, to)));
    }
}