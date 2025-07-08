//package specs;
//
//
//import config.SpotifyConfig;
//import helpers.SpotifyTokenService;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import org.aeonbits.owner.ConfigFactory;
//import org.junit.jupiter.api.BeforeAll;
//
//import java.util.Base64;
//
//import static helpers.CustomAllureListener.withCustomTemplates;
//import static io.restassured.RestAssured.with;
//import static io.restassured.filter.log.LogDetail.ALL;
//import static io.restassured.http.ContentType.JSON;
//
//public class BaseSpec {
//
//    private static final SpotifyConfig CONFIG = ConfigFactory.create(SpotifyConfig.class);
//    public static String token;
//
//    public static RequestSpecification tokenRequestSpec = with()
//            .filter(withCustomTemplates())
//            .log().all()
//            .contentType("application/x-www-form-urlencoded")
//            .formParam("client_id", CONFIG.clientId())
//            .formParam("grant_type", "client_credentials")
//            .formParam("client_secret", CONFIG.clientSecret())
//            .baseUri(CONFIG.baseUrl());
//
//    public static RequestSpecification authRequestSpec = with()
//            .filter(withCustomTemplates())
//            .log().all()
//            .formParam("grant_type", "authorization_code")
//            .formParam("code", token)
//            .formParam("redirect_uri", CONFIG.redirectUri())
//            .contentType("application/x-www-form-urlencoded")
//            .baseUri(CONFIG.baseUrl())
//            .header("Authorization", "Basic " + Base64.getEncoder()
//                    .encodeToString((CONFIG.clientId() + ":" + CONFIG.clientSecret()).getBytes()));
//
//
//    public static ResponseSpecification getResponseWithStatusCode(int statusCode) {
//        return new ResponseSpecBuilder()
//                .log(ALL)
//                .expectContentType(JSON)
//                .expectStatusCode(statusCode)
//                .build();
//    }
//
//    @BeforeAll
//    public static void getToken() {
//        token = SpotifyTokenService.getToken();
//    }
//}