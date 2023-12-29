package heroku_smoke_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({C01CreateToken.class,
        C02CreateBooking.class,
        C03FindBooking.class,
        C04UpdateBooking.class,
        C05PartiallyUpdateBooking.class,
        C06DeleteBooking.class,
        C07GetDeletingBooking.class})
public class Runner {



}
