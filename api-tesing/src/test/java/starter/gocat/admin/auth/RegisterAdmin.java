package starter.gocat.admin.auth;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterAdmin {
    private static String url = "http://34.128.69.15:8000";

    @Step("I set {String} endpoint for admin register")
    public String setEndpointAdminRegister(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = "/admin/register";
                break;
            case "invalid":
                endpoint = "/adm/register";
                break;
            default:
                break;
        }
        return url + endpoint;
    }

    @Step("I send post request with {String} to valid admin register endpoint")
    public void sendPostValidAdminRegisterEndpoint(String credentialType) {
        JSONObject requestBody = new JSONObject();
        Faker faker = new Faker();

        String username = faker.name().firstName();
        String email = faker.internet().safeEmailAddress();

        switch (credentialType) {
            case "username of more than 16 characters":
                requestBody.put("name", "retno");
                requestBody.put("username", "morethan16characters");
                requestBody.put("email", email);
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "12345678");
                break;
            case "registered username":
                requestBody.put("name", "zara");
                requestBody.put("username", "Syafrudin");
                requestBody.put("email", email);
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "12345678");
                break;
            case "registered email":
                requestBody.put("name", "zara");
                requestBody.put("username", username);
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "12345678");
                break;
            case "integer password":
                requestBody.put("name", "zara");
                requestBody.put("username", username);
                requestBody.put("email", email);
                requestBody.put("phone", "081234567890");
                requestBody.put("password", 12345678);
                break;
            case "empty name":
                requestBody.put("name", "");
                requestBody.put("username", username);
                requestBody.put("email", email);
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "12345678");
                break;
            case "empty username":
                requestBody.put("name", "zara");
                requestBody.put("username", "");
                requestBody.put("email", email);
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "12345678");
                break;
            case "empty email":
                requestBody.put("name", "zara");
                requestBody.put("username", username);
                requestBody.put("email", "");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "12345678");
                break;
            case "empty phone":
                requestBody.put("name", "zara");
                requestBody.put("username", username);
                requestBody.put("email", email);
                requestBody.put("phone", "");
                requestBody.put("password", "12345678");
                break;
            case "empty password":
                requestBody.put("name", "zara");
                requestBody.put("username", username);
                requestBody.put("email", email);
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "");
                break;
            default:
                requestBody.put("invalidField", "InvalidValue");
                break;
        }

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setEndpointAdminRegister("valid"));
    }

    @Step("I send post request with valid requestBody to {String} admin register endpoint")
    public void sendPostInvalidAdminRegisterEndpoint(String baseType) {
        JSONObject requestBody = new JSONObject();

        Faker faker = new Faker();

        String username = faker.name().firstName();
        String email = faker.internet().safeEmailAddress();

        requestBody.put("name", "retno");
        requestBody.put("username", username);
        requestBody.put("email", email);
        requestBody.put("phone", "081234567890");
        requestBody.put("password", "12345678");

        switch (baseType) {
            case "valid":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .post(setEndpointAdminRegister("valid"));
                break;
            case "invalid":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .post(setEndpointAdminRegister("invalid"));
                break;
        }
    }

    @Step("I send {String} request to admin register")
    public void sendOtherMethodToAdminRegister(String methodType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "retno");
        requestBody.put("username", "rere");
        requestBody.put("email", "rere@gmail.com");
        requestBody.put("phone", "081234567890");
        requestBody.put("password", "12345678");

        switch (methodType) {
            case "get":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .get(setEndpointAdminRegister("valid"));
                break;
            case "put":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .put(setEndpointAdminRegister("valid"));
                break;
            case "delete":
                SerenityRest.given()
                        .header("Content-Type", "application/json")
                        .body(requestBody.toString())
                        .delete(setEndpointAdminRegister("valid"));
                break;
        }
    }

    @Step("I receive my detail account")
    public void receiveDetailAccount() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_REGISTER_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("meta", notNullValue()));
        restAssuredThat(response -> response.body("results", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
