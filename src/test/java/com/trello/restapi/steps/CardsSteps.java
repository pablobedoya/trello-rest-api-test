package com.trello.restapi.steps;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.trello.restapi.model.response.CardResponse;
import com.trello.restapi.model.response.CreateBoardResponse;
import com.trello.restapi.model.response.CreateListResponse;
import com.trello.restapi.model.response.ResponseData;
import com.trello.restapi.service.BoardsService;
import com.trello.restapi.service.CardsService;
import com.trello.restapi.service.ListsService;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CardsSteps {

    private BoardsService boardsService = new BoardsService();
    private ListsService listsService = new ListsService();
    private CardsService cardsService = new CardsService();
    
    private ResponseData<CreateBoardResponse> createBoardResponse;
    private ResponseData<CreateListResponse> createListResponse;
    private ResponseData<CardResponse> createCardResponse;
    private ResponseData<CardResponse> updateCardResponse;
    private ResponseData<CardResponse> getCardResponse;
    
    private Map<String, String> defaultParams = new HashMap<>();

    @Given("I have Trello valid credentials")
    public void i_have_trello_valid_credentials() {
        defaultParams.put("key", "05eb8e3c106dd98462d72e6210ac950c");
        defaultParams.put("token", "d5dfee84b3bf85e0d7520c3157554db7ff66b0497c419216854c87903120bbac");
    }

    @And("I create a board")
    public void i_create_a_board() {
        Map<String, String> createBoardParams = new HashMap<>();
        createBoardParams.putAll(defaultParams);
        createBoardParams.put("name", "Board 1");
        createBoardResponse = boardsService.createBoard(createBoardParams);
        assertEquals(200, createBoardResponse.getStatusCode());
    }

    @And("I create a list")
    public void i_create_a_list() {
        Map<String, String> createListParams = new HashMap<>();
        createListParams.putAll(defaultParams);
        createListParams.put("name", "Lista 1");
        createListParams.put("idBoard", createBoardResponse.getData().getId());
        createListResponse = listsService.createList(createListParams);
        assertEquals(200, createListResponse.getStatusCode());
    }

    @When("I create a card")
    public void i_create_a_card() {
        Map<String, String> createCardParams = new HashMap<>();
        createCardParams.putAll(defaultParams);
        createCardParams.put("name", "Card 1");
        createCardParams.put("desc", "Description for card 1");
        createCardParams.put("idList", createListResponse.getData().getId());
        createCardResponse = cardsService.createCard(createCardParams);
    }
    
    @When("I update the card")
    public void i_update_the_card() {
        Map<String, String> updateCardParams = new HashMap<>();
        updateCardParams.putAll(defaultParams);
        updateCardParams.put("name", "Card number 2");
        updateCardParams.put("desc", "Description for card number 2");
        
        Map<String, String> updateCardPathParams = new HashMap<>();
        updateCardPathParams.put("id", createCardResponse.getData().getId());
        
        updateCardResponse = cardsService.updateCard(updateCardPathParams, updateCardParams);
    }
    
    @When("I update the card with an invalid id")
    public void i_update_the_card_with_an_invalid_id() {
        Map<String, String> updateCardParams = new HashMap<>();
        updateCardParams.putAll(defaultParams);
        updateCardParams.put("name", "Card number 2");
        updateCardParams.put("desc", "Description for card number 2");
        
        Map<String, String> updateCardPathParams = new HashMap<>();
        updateCardPathParams.put("id", "invalid");
        
        updateCardResponse = cardsService.updateCard(updateCardPathParams, updateCardParams);
    }

    @When("I submit a request to get the card with invalid credentials")
    public void i_submit_a_request_to_get_the_card_with_invalid_credentials() {
        Map<String, String> invalidCredentialsParams = new HashMap<>();
        invalidCredentialsParams.put("key", "0471642aefef5fa1fa76530ce1ba4c85");
        invalidCredentialsParams.put("token", "9eb76d9a9d02b8dd40c2f3e5df18556c831d4d1fadbe2c45f8310e6c93b5c548");
        
        Map<String, String> getCardPathParams = new HashMap<>();
        getCardPathParams.put("id", createCardResponse.getData().getId());
        
        getCardResponse = cardsService.getCard(getCardPathParams, invalidCredentialsParams);
    }

    @Then("Trello should return that the card was created successfully")
    public void trello_should_return_that_the_card_was_created_successfully() {
        assertEquals(200, createCardResponse.getStatusCode());
    }

    @And("I should have a card with creation data")
    public void i_should_have_a_card_with_creation_data() {
        assertEquals("Card 1", createCardResponse.getData().getName());
        assertEquals("Description for card 1", createCardResponse.getData().getDesc());
    }
    
    @Then("Trello should return that the card was updated successfully")
    public void trello_should_return_that_the_card_was_updated_successfully() {
        assertEquals(200, updateCardResponse.getStatusCode());
    }

    @And("I should have a card with update data")
    public void i_should_have_a_card_with_update_data() {
        assertEquals("Card number 2", updateCardResponse.getData().getName());
        assertEquals("Description for card number 2", updateCardResponse.getData().getDesc());
    }
    
    @Then("Trello should return that the card has not been updated")
    public void trello_should_return_that_the_card_has_not_been_updated() {
        assertEquals(400, updateCardResponse.getStatusCode());
    }

    @Then("Trello should return that the credentials are invalid")
    public void trello_should_return_that_the_credentials_are_invalid() {
        assertEquals(401, getCardResponse.getStatusCode());
    }
    
    @After
    public void tearDown() {
        Map<String, String> deleteBoardPathParams = new HashMap<>();
        deleteBoardPathParams.put("id", createBoardResponse.getData().getId());
        boardsService.deleteBoard(deleteBoardPathParams, defaultParams);
    }
    
}
