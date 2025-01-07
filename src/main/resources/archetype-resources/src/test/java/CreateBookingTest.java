package ${package};

import ${package}.endpoints.CreateBookingEndpoint;
import ${package}.payload.CreateBookingPayload;
import ${package}.model.BookingDates;
import ${package}.dataprovider.BookingDataProvider;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateBookingTest {

    @Test (description = "create booking test", dataProvider = BookingDataProvider.BOOKING_PROVIDER,
            dataProviderClass = BookingDataProvider.class)
    public void createBookingTest(CreateBookingPayload bookingPayload){
        // given booking payload (injected into the method via the data-provider)
        // when I make a booking
        Response createBookingResp = CreateBookingEndpoint.createBooking(bookingPayload);
        // then the booking is successful
        createBookingResp.then().
                statusCode(HttpStatus.SC_OK).
                assertThat().body("bookingid", is(not(emptyOrNullString())));
    }
}