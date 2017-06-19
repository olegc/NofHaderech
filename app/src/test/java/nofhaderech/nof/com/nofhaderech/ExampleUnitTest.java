package nofhaderech.nof.com.nofhaderech;

import org.junit.Test;

import nofhaderech.nof.com.nofhaderech.bl.UsersManager;
import nofhaderech.nof.com.nofhaderech.models.User;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testAddUser() throws Exception {
        UsersManager manager = new UsersManager();
        manager.AddUser(new User("OrenShm", "0509218146", "Oren's Home", "Oren's Work", 0, 0));
        //assertEquals(4, 2 + 2);
    }
}