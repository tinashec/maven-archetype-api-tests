package ${package}.endpoints;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import ${package}.payload.AuthPayload;

import static ${package}.utils.Constants.baseUrl;
import static io.restassured.RestAssured.given;

public class AuthEndpoint {
    
    /**
     * method for one of the actions from your API. This creates the auth token
     * @param authPayload represents the body of the request
     * @return RestAssured response from the request
     */
    public static Response createToken(AuthPayload authPayload){
        Response authResp = given().
                    contentType(ContentType.JSON).
                    body(authPayload).
                    log().all().
                when().
                    post(baseUrl.concat("/auth"));
        return authResp;
    }
}