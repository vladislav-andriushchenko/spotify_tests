//package helpers;
//
//import config.SpotifyConfig;
//import io.restassured.response.Response;
//import org.aeonbits.owner.ConfigFactory;
//
//import java.time.Instant;
//import java.util.concurrent.atomic.AtomicReference;
//
//import static io.restassured.RestAssured.given;
//
//public class SpotifyTokenService {
//
//    private static final SpotifyConfig config = ConfigFactory.create(SpotifyConfig.class);
//    private static final AtomicReference<String> tokenHolder = new AtomicReference<>();
//    private static volatile long tokenExpiry;
//
//    public static String getToken() {
//        if (needsRefresh()) {
//            synchronized (SpotifyTokenService.class) {
//                if (needsRefresh()) {
//                    refreshToken();
//                }
//            }
//        }
//        return tokenHolder.get();
//    }
//
//    private static boolean needsRefresh() {
//        return tokenHolder.get() == null ||
//                Instant.now().getEpochSecond() > tokenExpiry - 300; // 5 min buffer
//    }
//
//    private static void refreshToken() {
//        Response response = given()
//                .baseUri(config.baseUrl())
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("grant_type", "client_credentials")
//                .formParam("client_id", config.clientId())
//                .formParam("client_secret", config.clientSecret())
//                .when()
//                .post("/api/token");
//
//        tokenHolder.set(response.jsonPath().getString("access_token"));
//        tokenExpiry = Instant.now().getEpochSecond() + response.jsonPath().getInt("expires_in");
//    }
//}
