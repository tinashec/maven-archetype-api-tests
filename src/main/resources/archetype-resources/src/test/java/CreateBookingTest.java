package ${package};

import ${package}.endpoints.CreateBookingEndpoint;
import ${package}.payload.CreateBookingPayload;
import ${package}.model.BookingDates;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateBookingTest {

    @Test (description = "create booking test")
    public void createBookingTest(){
        // given booking payload (this should be moved to a data-provider)
        BookingDates dates = new BookingDates("2030-01-01", "2030-01-02");
        
        CreateBookingPayload bookingPayload = CreateBookingPayload.builder().
                    firstname("Test").
                    lastname("Booking").
                    totalprice(50).
                    depositpaid(true).
                    bookingdates(dates).
                    additionalneeds("Extra bed").
                build();
        // when I make a booking
        Response createBookingResp = CreateBookingEndpoint.createBooking(bookingPayload);
        // then the booking is successful
        createBookingResp.then().
                statusCode(HttpStatus.SC_OK).
                assertThat().body("bookingid", is(not(emptyOrNullString())));
    }
}