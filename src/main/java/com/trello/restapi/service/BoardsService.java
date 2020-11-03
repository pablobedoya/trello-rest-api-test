package com.trello.restapi.service;

import java.util.Map;

import com.trello.restapi.model.response.CreateBoardResponse;
import com.trello.restapi.model.response.DeleteBoardResponse;
import com.trello.restapi.model.response.ResponseData;
import com.trello.restapi.request.RequestBuilder;
import com.trello.restapi.request.RequestData;

public class BoardsService {

    private static final String URL = "https://api.trello.com/1";
    private static final String BOARDS_PATH = "/boards";
    private static final String BOARDS_ID_PATH = "/boards/{id}";

    private RequestBuilder requestBuilder = new RequestBuilder();
    private RequestData requestData;

    public ResponseData<CreateBoardResponse> createBoard(Map<String, String> queryParams) {
        requestData = RequestData.builder().url(URL).queryParams(queryParams).path(BOARDS_PATH).build();
        return requestBuilder.createBoard(requestData);
    }

    public ResponseData<DeleteBoardResponse> deleteBoard(Map<String, String> pathParams, Map<String, String> queryParams) {
        requestData = RequestData.builder().url(URL).pathParams(pathParams).queryParams(queryParams).path(BOARDS_ID_PATH).build();
        return requestBuilder.deleteBoard(requestData);
    }

}
