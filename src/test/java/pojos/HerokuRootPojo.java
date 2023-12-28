package pojos;

public class HerokuRootPojo {
    /*

     */

    private Integer bookingid;
    private BookingPojo booking;

    public HerokuRootPojo() {
    }

    public HerokuRootPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
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
