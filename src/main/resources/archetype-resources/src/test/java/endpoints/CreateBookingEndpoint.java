package ${package}.endpoints;

import ${package}.payload.CreateBookingPayload;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static ${package}.utils.Constants.baseUrl;
import static io.restassured.RestAssured.given;

public class CreateBookingEndpoint{

    /**
     * method which sends a POST request to the /booking endpoint to create a booking
     * @param bookingPayload is the payload required when creating a booking
     * @return the response from the request
     */
    public static Response createBooking(CreateBookingPayload bookingPayload){
        Response bookingResp = given().
                    contentType(ContentType.JSON).
                    body(bookingPayload).
                    log().all().
              when().
                post(baseUrl.concat("/booking"));
        return bookingResp;
    }
}