//package steps;
//
//import models.SpotifyAuthResponse;
//
//import static io.restassured.RestAssured.given;
//import static specs.BaseSpec.*;
//
//public class SpotifySteps {
//
//
//    public SpotifyAuthResponse getToken() {
//
//        return given(tokenRequestSpec)
//                .when()
//                .post("/api/token")
//                .then()
//                .spec(getResponseWithStatusCode(200))
//                .extract()
//                .response().as(SpotifyAuthResponse.class);
//    }
//
//    public SpotifyAuthResponse refreshAccessToken() {
//
//        return given(authRequestSpec)
//                .when()
//                .post("/api/token")
//                .then()
//                .spec(getResponseWithStatusCode(200))
//                .extract()
//                .response().as(SpotifyAuthResponse.class);
//    }
//
//
//}
