package starter.utils;

//import io.restassured.response.ResponseBody;
//import net.serenitybdd.rest.SerenityRest;
//import org.json.JSONObject;
//
//import static starter.Url.loginAdmin;
//import static starter.Url.loginUser;

public class GenerateToken {
//    public static String adminToken() {
//        JSONObject adminData = Utils.getAdmin();
//        JSONObject requestBody = new JSONObject();
//
//
//        requestBody.put("username", adminData.get("username"));
//        requestBody.put("password", adminData.get("password"));
//
//        ResponseBody loginResponse = SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .body(requestBody.toString())
//                .post(loginAdmin)
//                .body();
//
//        JSONObject loginResponseBody = new JSONObject(loginResponse.asString());
//
//        return loginResponseBody.getJSONObject("results").optString("token");
//    }
//
//    public static String userToken() {
//        JSONObject userData = Utils.getUser();
//        JSONObject requestBody = new JSONObject();
//
//
//        requestBody.put("username", userData.get("username"));
//        requestBody.put("password", userData.get("password"));
//
//        ResponseBody loginResponse = SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .body(requestBody.toString())
//                .post(loginUser)
//                .body();
//
//        JSONObject loginResponseBody = new JSONObject(loginResponse.asString());
//
//        return loginResponseBody.getJSONObject("results").optString("token");
//    }

    public static String tokenAdmin() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJlbWFpbCI6InFlYWx0YUBnbWFpbC5jb20iLCJleHAiOjE3MDI2MjYyMjYsImlkIjoiYXNWVFlzIiwibmFtZSI6IkFuZ2d1biIsInJvbGUiOiJhZG1pbiJ9.8xmpuw_JA3HCdah4X4Qa6geC7S4qIqNLR6alMciDDcQ";
    }

    public static String tokenUser() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJlbWFpbCI6ImluaWFyYUBnbWFpbC5jb20iLCJleHAiOjE3MDI2MjYyNjYsImlkIjoiVlEwZlhUIiwibmFtZSI6ImFyYSIsInJvbGUiOiJ1c2VyIn0.C9q8hIMv10Prs2gOcAmIxwNxfjP65PULDVydJOY-60Y";
    }
}
