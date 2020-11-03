package com.trello.restapi.request;

import static io.restassured.RestAssured.given;

import com.trello.restapi.model.response.CreateBoardResponse;
import com.trello.restapi.model.response.CardResponse;
import com.trello.restapi.model.response.CreateListResponse;
import com.trello.restapi.model.response.DeleteBoardResponse;
import com.trello.restapi.model.response.ResponseData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestBuilder {
    
    public ResponseData<CreateBoardResponse> createBoard(RequestData requestData) {
        Response response = executePostRequest(requestData);

        CreateBoardResponse createBoardResponse = new CreateBoardResponse();
        if (response.getContentType().contains(ContentType.JSON.toString()))
            createBoardResponse = response.as(CreateBoardResponse.class);

        ResponseData<CreateBoardResponse> responseData = new ResponseData<CreateBoardResponse>();
        responseData.setData(createBoardResponse);
        responseData.setStatusCode(response.getStatusCode());
        responseData.setTime(response.getTime());

        return responseData;
    }

    public ResponseData<DeleteBoardResponse> deleteBoard(RequestData requestData) {
        Response response = executeDeleteRequest(requestData);

        DeleteBoardResponse deleteBoardResponse = new DeleteBoardResponse();
        if (response.getContentType().contains(ContentType.JSON.toString()))
            deleteBoardResponse = response.as(DeleteBoardResponse.class);

        ResponseData<DeleteBoardResponse> responseData = new ResponseData<DeleteBoardResponse>();
        responseData.setData(deleteBoardResponse);
        responseData.setStatusCode(response.getStatusCode());
        responseData.setTime(response.getTime());

        return responseData;
    }

    public ResponseData<CreateListResponse> createList(RequestData requestData) {
        Response response = executePostRequest(requestData);

        CreateListResponse createListResponse = new CreateListResponse();
        if (response.getContentType().contains(ContentType.JSON.toString()))
            createListResponse = response.as(CreateListResponse.class);

        ResponseData<CreateListResponse> responseData = new ResponseData<CreateListResponse>();
        responseData.setData(createListResponse);
        responseData.setStatusCode(response.getStatusCode());
        responseData.setTime(response.getTime());

        return responseData;
    }

    public ResponseData<CardResponse> createCard(RequestData requestData) {
        Response response = executePostRequest(requestData);

        CardResponse createCardResponse = new CardResponse();
        if (response.getContentType().contains(ContentType.JSON.toString()))
            createCardResponse = response.as(CardResponse.class);

        ResponseData<CardResponse> responseData = new ResponseData<CardResponse>();
        responseData.setData(createCardResponse);
        responseData.setStatusCode(response.getStatusCode());
        responseData.setTime(response.getTime());

        return responseData;
    }

    public ResponseData<CardResponse> updateCard(RequestData requestData) {
        Response response = executePutRequest(requestData);

        CardResponse updateCardResponse = new CardResponse();
        if (response.getContentType().contains(ContentType.JSON.toString()))
            updateCardResponse = response.as(CardResponse.class);

        ResponseData<CardResponse> responseData = new ResponseData<CardResponse>();
        responseData.setData(updateCardResponse);
        responseData.setStatusCode(response.getStatusCode());
        responseData.setTime(response.getTime());

        return responseData;
    }

    public ResponseData<CardResponse> getCard(RequestData requestData) {
        Response response = executeGetRequest(requestData);

        CardResponse getCardResponse = new CardResponse();
        if (response.getContentType().contains(ContentType.JSON.toString()))
            getCardResponse = response.as(CardResponse.class);

        ResponseData<CardResponse> responseData = new ResponseData<CardResponse>();
        responseData.setData(getCardResponse);
        responseData.setStatusCode(response.getStatusCode());
        responseData.setTime(response.getTime());

        return responseData;
    }

    private Response executePostRequest(RequestData requestData) {
        return given()
                    .baseUri(requestData.getUrl())
                    .headers(requestData.getHeaders())
                    .pathParams(requestData.getPathParams())
                    .queryParams(requestData.getQueryParams())
                    .contentType(requestData.getContentType())
                .when()
                    .post(requestData.getPath());
    }

    private Response executeGetRequest(RequestData requestData) {
        return given()
                    .baseUri(requestData.getUrl())
                    .headers(requestData.getHeaders())
                    .pathParams(requestData.getPathParams())
                    .queryParams(requestData.getQueryParams())
                .when()
                    .get(requestData.getPath());
    }

    private Response executePutRequest(RequestData requestData) {
        return given()
                    .baseUri(requestData.getUrl())
                    .headers(requestData.getHeaders())
                    .pathParams(requestData.getPathParams())
                    .contentType(requestData.getContentType())
                    .queryParams(requestData.getQueryParams())
                .when()
                    .put(requestData.getPath());
    }

    private Response executeDeleteRequest(RequestData requestData) {
        return given()
                    .baseUri(requestData.getUrl())
                    .headers(requestData.getHeaders())
                    .pathParams(requestData.getPathParams())
                    .queryParams(requestData.getQueryParams())
                .when()
                    .delete(requestData.getPath());
    }

}
