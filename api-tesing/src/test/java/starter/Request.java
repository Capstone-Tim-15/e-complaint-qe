package starter;

import io.restassured.response.Response;

//
//import io.restassured.specification.RequestSpecification;
//import net.serenitybdd.rest.SerenityRest;
//
//import static starter.utils.GenerateToken.adminToken;
//import static starter.utils.GenerateToken.userToken;
//
public class Request {
//    public static final RequestSpecification adminReq;
//
//    static {
//        adminReq = SerenityRest.given()
//                .header("Authorization", "Bearer " + adminToken())
//                .header("Content-Type", "application/json");
//    }
//
//    public static final RequestSpecification userReq;
//
//    static {
//        userReq = SerenityRest.given()
//                .header("Authorization", "Bearer " + userToken())
//                .header("Content-Type", "application/json");
//    }
//
//}

    private Response lastResponse;
    // Metode ini memungkinkan akses ke respons terakhir
    public Response getLastResponse() {
        return lastResponse;
    }


}
