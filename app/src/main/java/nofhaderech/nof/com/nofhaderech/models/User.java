package nofhaderech.nof.com.nofhaderech.models;

/**
 * Created by USER on 6/19/2017.
 */

public class User {
    public String id;
    public String mobile;
    public String home_addr;
    public String work_addr;

    public int points;
    public double rating;
    public int num_ratings;

    public User(){}

    public User(String id, String mobile, String home_addr, String work_addr) {
        this.id = id;
        this.mobile = mobile;
        this.home_addr = home_addr;
        this.work_addr = work_addr;
        this.points = 0;
        this.rating = 0;
        this.num_ratings = 0;
    }

    public boolean IsSameUser(User other)
    {
        return id.equals(other.id);
    }
}
