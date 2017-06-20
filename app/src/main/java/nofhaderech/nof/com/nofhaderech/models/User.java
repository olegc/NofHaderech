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
    public String token_id;

    public User(){
        this.points = 0;
        this.rating = 0;
        this.num_ratings = 0;
        this.token_id = null;
    }

    public User(String id, String mobile, String home_addr, String work_addr) {
        this();
        this.id = id;
        this.mobile = mobile;
        this.home_addr = home_addr;
        this.work_addr = work_addr;
    }


}
