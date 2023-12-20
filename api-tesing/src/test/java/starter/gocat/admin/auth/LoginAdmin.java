package starter.gocat.admin.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static starter.Url.adminLoginUrl;
import static starter.Url.invUrl;

public class LoginAdmin {

    @Step("I set {String} endpoint for admin login")
    public String setEndpointAdminLogin(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = adminLoginUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported endpoint type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send post request with valid requestBody to {String} admin login endpoint")
    public void sendPostToBaseTypeAdminLoginEndpoint(String baseType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "anggun");
        requestBody.put("password", "1234567890");

        switch (baseType) {
            case "valid":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .post(setEndpointAdminLogin("valid"));
                break;
            case "invalid":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .post(setEndpointAdminLogin("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send post request with {String} to valid admin login endpoint")
    public void sendPostValidAdminLoginEndpoint(String credentialType) {
        JSONObject requestBody = new JSONObject();

        switch (credentialType) {
            case "invalid username":
                requestBody.put("username", "invara");
                requestBody.put("password", "1234567890");
                break;
            case "invalid password":
                requestBody.put("username", "Anggun");
                requestBody.put("password", "invalid");
                break;
            case "empty username":
                requestBody.put("username", "");
                requestBody.put("password", "1234567890");
                break;
            case "empty password":
                requestBody.put("username", "Anggun");
                requestBody.put("password", "");
                break;
            case "integer password":
                requestBody.put("username", "Anggun");
                requestBody.put("password", 1234567890);
                break;
            default:
                Assert.fail("Unsupported credential type: " + credentialType);
        }

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setEndpointAdminLogin("valid"));
    }

    @Step("I send {String} request to admin login")
    public void sendOtherMethodToAdminLogin(String methodType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "Anggun");
        requestBody.put("password", "1234567890");

        switch (methodType) {
            case "get":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .get(setEndpointAdminLogin("valid"));
                break;
            case "put":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .put(setEndpointAdminLogin("valid"));
                break;
            case "delete":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .delete(setEndpointAdminLogin("valid"));
                break;
        }
    }

}