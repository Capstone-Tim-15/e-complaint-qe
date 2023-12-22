package starter.gocat.user.auth;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static starter.Url.invUrl;
import static starter.Url.userLoginUrl;

public class UserLogin {



    @Step("I set {String} endpoint for user login")
    public String setEndpointUserLogin(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = userLoginUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send post request with {String} to valid user login endpoint")
    public void sendPostValidUserLoginEndpoint(String credentialType) {
        JSONObject requestBody = new JSONObject();

        switch (credentialType) {
            case "unregistered username":
                requestBody.put("username", "unregist");
                requestBody.put("password", "someone123");
                break;
            case "integer password":
                requestBody.put("username", "someone");
                requestBody.put("password", 12312);
                break;
            case "empty username":
                requestBody.put("username", "");
                requestBody.put("password", "someone123");
                break;
            case "empty password":
                requestBody.put("username", "someone");
                requestBody.put("password", "");
                break;
            default:
                requestBody.put("invalidField", "InvalidValue");
                break;
        }

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setEndpointUserLogin("valid"));
    }

    @Step("I send post request with valid requestBody to {String} user login endpoint")
    public void sendPostInvalidUserLoginEndpoint(String baseType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "iniara");
        requestBody.put("password", "12345678");

        switch (baseType) {
            case "valid":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .post(setEndpointUserLogin("valid"));
                break;
            case "invalid":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .post(setEndpointUserLogin("invalid"));
                break;
        }
    }

    @Step("I send {String} request to user login")
    public void sendOtherMethodToUserLogin(String methodType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "iniara");
        requestBody.put("password", "12345678");

        switch (methodType) {
            case "get":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .get(setEndpointUserLogin("valid"));
                break;
            case "put":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .put(setEndpointUserLogin("valid"));
                break;
        }
    }

    @Step("I receive my token account")
    public void receiveTokenAccount() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_LOGIN_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("meta", notNullValue()));
        restAssuredThat(response -> response.body("results", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


}


