package starter.stepdefinitions.user.chat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.gocat.user.chat.CreateRoomChat;

public class CreateRoomChatSteps {
    @Steps
    CreateRoomChat createRoomChat;

    @Given("I set {string} endpoint for create room chat")
    public void setEndpointCreateRoomChat (String endpointType){
        createRoomChat.setEndpointCreateRoomChat(endpointType);
    }

    @When("I send post request to {string} create room chat endpoint")
    public void sendPostBaseTypeCreateRoomChatEndpoint(String baseType) {
        createRoomChat.sendPostBaseTypeCreateRoomChatEndpoint(baseType);
    }

    @When("I send post request to create room chat endpoint without token")
    public void createRoomChatWithoutLogin() {
        createRoomChat.createRoomChatWithoutLogin();
    }

    @And("I receive message that room chat is created")
    public void receiveDetailRoomChat() {
        createRoomChat.receiveDetailRoomChat();
    }
}
