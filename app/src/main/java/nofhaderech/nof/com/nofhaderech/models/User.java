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

    public User(){}

    public User(String id, String mobile, String home_addr, String work_addr, int points, double rating) {
        this.id = id;
        this.mobile = mobile;
        this.home_addr = home_addr;
        this.work_addr = work_addr;
        this.points = points;
        this.rating = rating;
    }


}
