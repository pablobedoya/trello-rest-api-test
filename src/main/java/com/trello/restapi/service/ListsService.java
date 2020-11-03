package com.trello.restapi.service;

import java.util.Map;

import com.trello.restapi.model.response.CreateListResponse;
import com.trello.restapi.model.response.ResponseData;
import com.trello.restapi.request.RequestBuilder;
import com.trello.restapi.request.RequestData;

public class ListsService {

    private static final String URL = "https://api.trello.com/1";
    private static final String LISTS_PATH = "/lists";

    private RequestBuilder requestBuilder = new RequestBuilder();
    private RequestData requestData;

    public ResponseData<CreateListResponse> createList(Map<String, String> queryParams) {
        requestData = RequestData.builder().url(URL).queryParams(queryParams).path(LISTS_PATH).build();
        return requestBuilder.createList(requestData);
    }

}
