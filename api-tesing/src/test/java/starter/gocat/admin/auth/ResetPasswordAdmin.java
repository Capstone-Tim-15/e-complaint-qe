package starter.gocat.admin.auth;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static starter.Url.baseUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class ResetPasswordAdmin {



    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .header("Content-Type", "application/json");
    }

    private static final String url = "http://34.128.69.15:8000";

    @Step("I set valid endpoint for reset password admin")
    public String setEndpointResetPasswordAdmin() {

        return url + "/admin/reset-password";
    }

    @Step("I send post request with {String} to valid reset password admin endpoint")
    public void sendPostValidResetPasswordAdminEndpoint(String credentialType) {
        Map<String, Object> requestBodyMap = new LinkedHashMap<>();

        switch (credentialType) {
            case "valid requestBody":
                requestBodyMap.put("newPassword", "1234567890");
                requestBodyMap.put("confirmNewPassword", "1234567890");
                break;
            case "invalid confirm password":
                requestBodyMap.put("newPassword", "new");
                requestBodyMap.put("confirmNewPassword", "newpassword");
                break;

            case "empty new password":
                requestBodyMap.put("newPassword", "");
                requestBodyMap.put("confirmNewPassword", "1234567890");
                break;

            case "empty confirm password":
                requestBodyMap.put("newPassword", "1234567890");
                requestBodyMap.put("confirmNewPassword", "");
                break;

            default:
                Assert.fail("Unsupported credential type: " + credentialType);

        }
        JSONObject requestBody = new JSONObject(requestBodyMap);
        requestSpec
                .body(requestBody.toString())
                .put(setEndpointResetPasswordAdmin());

    }

    @Step("I send post request to valid reset password admin endpoint without login")
    public void sendPostToResetPasswordAdminWithoutLogin() {

        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("newPassword", "1234567890");
        requestBodyMap.put("confirmNewPassword", "1234567890");

        JSONObject requestBody = new JSONObject(requestBodyMap);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .get(setEndpointResetPasswordAdmin());
    }




}
