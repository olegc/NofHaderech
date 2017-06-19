package nofhaderech.nof.com.nofhaderech.models;

import java.util.Date;

/**
 * Created by USER on 6/19/2017.
 */

public class RideDetails {
    public String src_addr;
    public String dst_addr;

    public Date from_time;
    public Date to_time;

    public RideDetails(String src_addr) {
        this.src_addr = src_addr;
    }
}
