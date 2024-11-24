package ${package};

import io.restassured.response.Response;
import ${package}.payload.AuthPayload;
import ${package}.endpoints.AuthEndpoint;

import static org.hamcrest.Matchers.*;

public class BaseTest{

    protected String authToken;

    /**
     * method representing the endpoint to get the auth token.
     * @return the token
     */
    public String getToken(){
        AuthPayload authPayload = new AuthPayload("admin", "password123");
        Response authResponse = AuthEndpoint.createToken(authPayload);
        authResponse.then().
                assertThat().body("token", is(not(emptyOrNullString())));
        return authToken = authResponse.then().
                    extract().body().path("token");
    }
}