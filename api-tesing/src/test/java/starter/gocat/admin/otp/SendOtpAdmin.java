package starter.gocat.admin.otp;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static starter.Url.invUrl;
import static starter.Url.adminSendOtpUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class SendOtpAdmin {


    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for send otp admin")
    public String setEndpointSendOtpAdmin(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = adminSendOtpUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} send otp admin endpoint")
    public void sendPostBaseTypeSendOtpAdminEndpoint(String baseType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "qealta@gmail.com");

        switch (baseType) {
            case "valid":
                requestSpec
                        .body(requestBody.toString())
                        .post(setEndpointSendOtpAdmin("valid"));
                break;
            case "invalid":
                requestSpec
                        .body(requestBody.toString())
                        .post(setEndpointSendOtpAdmin("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I receive otp admin")
    public void receiveOtpAdmin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_OTP_ADMIN_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

