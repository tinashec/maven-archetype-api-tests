package ${package}.payload;

import ${package}.model.BookingDates;
import lombok.Builder;
import java.util.Map;

@Builder
public class CreateBookingPayload{
    private String firstname, lastname, additionalneeds;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates; // checkin and checkout
}