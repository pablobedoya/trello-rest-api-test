package com.trello.restapi.service;

import java.util.Map;

import com.trello.restapi.model.response.CardResponse;
import com.trello.restapi.model.response.ResponseData;
import com.trello.restapi.request.RequestBuilder;
import com.trello.restapi.request.RequestData;

public class CardsService {

    private static final String URL = "https://api.trello.com/1";
    private static final String CARDS_PATH = "/cards";
    private static final String CARDS_ID_PATH = "/cards/{id}";

    private RequestBuilder requestBuilder = new RequestBuilder();
    private RequestData requestData;

    public ResponseData<CardResponse> createCard(Map<String, String> queryParams) {
        requestData = RequestData.builder().url(URL).queryParams(queryParams).path(CARDS_PATH).build();
        return requestBuilder.createCard(requestData);
    }

    public ResponseData<CardResponse> updateCard(Map<String, String> pathParams, Map<String, String> queryParams) {
        requestData = RequestData.builder().url(URL).pathParams(pathParams).queryParams(queryParams).path(CARDS_ID_PATH).build();
        return requestBuilder.updateCard(requestData);
    }

    public ResponseData<CardResponse> getCard(Map<String, String> pathParams, Map<String, String> queryParams) {
        requestData = RequestData.builder().url(URL).pathParams(pathParams).queryParams(queryParams).path(CARDS_ID_PATH).build();
        return requestBuilder.getCard(requestData);
    }
    
}
