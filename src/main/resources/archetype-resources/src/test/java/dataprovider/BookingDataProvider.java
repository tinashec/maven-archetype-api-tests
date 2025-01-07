package ${package}.dataprovider;

import org.testng.annotations.DataProvider;
import ${package}.payload.CreateBookingPayload;
import ${package}.model.BookingDates;

public class BookingDataProvider{
    
    public static final String BOOKING_PROVIDER = "bookingDataProvider";

    /**
     * a dataprovider that supplies the test method with the booking payload
     * @return a @CreateBookingPayload 
     */
    @DataProvider (name = BOOKING_PROVIDER)
    public Object[][] bookingDataProvider(){
        Object[][] booking;
        BookingDates dates = new BookingDates("2030-01-01", "2030-01-02");

        CreateBookingPayload bookingPayload = CreateBookingPayload.builder().
                    firstname("Test").
                    lastname("Booking").
                    totalprice(50).
                    depositpaid(true).
                    bookingdates(dates).
                    additionalneeds("Extra bed").
                build();
        
        booking = new Object[1][];
        booking[0] = new Object[]{bookingPayload};
        return booking;
    }
}