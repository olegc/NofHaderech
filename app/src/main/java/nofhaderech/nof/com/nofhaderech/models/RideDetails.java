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

    public RideDetails(){}

    public RideDetails(String src_addr, String dst_addr, Date from_time, Date to_time) {
        this.src_addr = src_addr;
        this.dst_addr = dst_addr;
        this.from_time = from_time;
        this.to_time = to_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RideDetails that = (RideDetails) o;

        if (src_addr != null ? !src_addr.equals(that.src_addr) : that.src_addr != null)
            return false;
        if (dst_addr != null ? !dst_addr.equals(that.dst_addr) : that.dst_addr != null)
            return false;
        if (from_time != null ? !from_time.equals(that.from_time) : that.from_time != null)
            return false;
        return to_time != null ? to_time.equals(that.to_time) : that.to_time == null;

    }

    @Override
    public int hashCode() {
        int result = src_addr != null ? src_addr.hashCode() : 0;
        result = 31 * result + (dst_addr != null ? dst_addr.hashCode() : 0);
        result = 31 * result + (from_time != null ? from_time.hashCode() : 0);
        result = 31 * result + (to_time != null ? to_time.hashCode() : 0);
        return result;
    }
}
