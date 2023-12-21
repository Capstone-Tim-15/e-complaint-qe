package starter.stepdefinitions.user.chat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.chat.GetChatByRoomId;

public class GetChatByRoomIdSteps {
    @Steps
    GetChatByRoomId getChatByRoomId;

    @Given("I set {string} endpoint for get chat by room id")
    public void setEndpointGetChatByRoomId(String endpointType) {
        getChatByRoomId.setEndpointGetChatByRoomId(endpointType);
    }

    @When("I send get request to {string} get chat by room id endpoint")
    public void sendGetBaseTypeGetChatByRoomIdEndpoint(String baseType) {
        getChatByRoomId.sendGetBaseTypeGetChatByRoomIdEndpoint(baseType);
    }

    @When("I send get request to valid get chat by room id endpoint without token")
    public void  getChatByRoomIdWithoutToken() {
        getChatByRoomId.getChatByRoomIdWithoutToken();
    }

    @And("I receive detail chat")
    public void receiveDetailChat() {
        getChatByRoomId.receiveDetailChat();
    }
}
