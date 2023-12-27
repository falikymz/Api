package pojos;

public class HerokuRootPojo {
    /*

     */

    private Integer bookingid;
    private HerokuAppPojo booking;

    public HerokuRootPojo() {
    }

    public HerokuRootPojo(Integer bookingid, HerokuAppPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public HerokuAppPojo getBooking() {
        return booking;
    }

    public void setBooking(HerokuAppPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerokuRootPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
