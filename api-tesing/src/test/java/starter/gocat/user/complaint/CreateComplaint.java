package starter.gocat.user.complaint;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static starter.Url.complaint;
import static starter.Url.invComplaint;
import static starter.utils.GenerateToken.tokenUser;

public class CreateComplaint {

    private static String getAttachmentPath() {
        return "src/test/resources/attachment/polusi-udara.jpeg";
    }

    private static final RequestSpecification requestSpec;

    static {
        RestAssured.config = RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig()
                .encodeContentTypeAs("multipart/form-data", ContentType.TEXT)
                .encodeContentTypeAs("application/x-www-form-urlencoded", ContentType.TEXT));

        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "multipart/form-data");
    }

    @Step("I set {String} endpoint for create complaint")
    public String setEndpointCreateComplaint (String endpointType){
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = complaint;
                break;
            case "invalid":
                endpoint = invComplaint;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send post request with {String} to valid create complaint")
    public void sendPostValidCreateComplaintEndpoint(String credentialType) {
        Map<String, Object> formData = new HashMap<>();

        switch (credentialType) {
            case "valid requestBody":
                requestSpec
                        .multiPart("categoryId", "abcdef")
                        .multiPart("title", "lingkungan")
                        .multiPart("content", "sudah sejak 2 minggu terkahir polusi udara di lingkungan sekitar Bekasi kian memburuk.")
                        .multiPart("attachment", new File(getAttachmentPath()))
                        .post(setEndpointCreateComplaint("valid"));
                break;
            case "invalid categoryId":
                SerenityRest.given()
                        .header("Authorization", "Bearer " + tokenUser())
                        .header("Content-Type", "multipart/form-data")
                        .multiPart("categoryId", "invalid")
                        .multiPart("title", "Lingkungan")
                        .multiPart("content", "sudah sejak 2 minggu terkahir polusi udara di lingkungan sekitar Bekasi kian memburuk.")
                        .multiPart("attachment", new File(getAttachmentPath()))
                        .post(setEndpointCreateComplaint("valid"));
                break;
            case "empty title":
                SerenityRest.given()
                        .header("Authorization", "Bearer " + tokenUser())
                        .header("Content-Type", "multipart/form-data")
                        .multiPart("categoryId", "abcdef")
                        .multiPart("title", "")
                        .multiPart("content", "sudah sejak 2 minggu terkahir polusi udara di lingkungan sekitar Bekasi kian memburuk.")
                        .multiPart("attachment", new File(getAttachmentPath()))
                        .post(setEndpointCreateComplaint("valid"));
                break;
            case "empty content":
                SerenityRest.given()
                        .header("Authorization", "Bearer " + tokenUser())
                        .header("Content-Type", "multipart/form-data")
                        .multiPart("categoryId", "abcdef")
                        .multiPart("title", "lingkungan")
                        .multiPart("content", "")
                        .multiPart("attachment", new File(getAttachmentPath()))
                        .post(setEndpointCreateComplaint("valid"));
                break;
            case "empty attachment":
                SerenityRest.given()
                        .header("Authorization", "Bearer " + tokenUser())
                        .header("Content-Type", "multipart/form-data")
                        .multiPart("categoryId", "abcdef")
                        .multiPart("title", "lingkungan")
                        .multiPart("content", "sudah sejak 2 minggu terkahir polusi udara di lingkungan sekitar Bekasi kian memburuk.")
                        .multiPart("attachment", "")
                        .post(setEndpointCreateComplaint("valid"));
                break;
            default:
                Assert.fail("Unsupported credential type: " + credentialType);
        }

    }

    @Step("I send post request with valid requestBody to invalid create complaint endpoint")
    public void sendPostInvalidCreateComplaintEndpoint() {
        requestSpec
                .multiPart("categoryId", "abcdef")
                .multiPart("title", "lingkungan")
                .multiPart("content", "sudah sejak 2 minggu terkahir polusi udara di lingkungan sekitar Bekasi kian memburuk.")
                .multiPart("attachment", new File(getAttachmentPath()))
                .post(setEndpointCreateComplaint("invalid"));
    }

    @Step("I send post request with valid requestBody to create complaint endpoint without login")
    public void sendPostCreateComplaintWithoutLogin() {
        SerenityRest.given()
                .header("Content-Type", "multipart/form-data")
                .multiPart("categoryId", "abcdef")
                .multiPart("title", "lingkungan")
                .multiPart("content", "sudah sejak 2 minggu terkahir polusi udara di lingkungan sekitar Bekasi kian memburuk.")
                .multiPart("attachment", new File(getAttachmentPath()))
                .post(setEndpointCreateComplaint("valid"));
    }

    @Step("I receive my detail complaint")
    public void receiveDetailComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_CREATE_COMPLAINT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("meta", notNullValue()));
        restAssuredThat(response -> response.body("results", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
