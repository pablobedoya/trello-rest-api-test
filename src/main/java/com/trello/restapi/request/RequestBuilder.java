package com.trello.restapi.request;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class RequestBuilder {

    private Response executePostRequest(RequestData requestData) {
        return given()
                    .baseUri(requestData.getUrl())
                    .headers(requestData.getHeaders())
                    .pathParams(requestData.getPathParams())
                    .contentType(requestData.getContentType())
                    .body(requestData.getRequestBody())
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
                .body(requestData.getRequestBody())
            .when()
                .put(requestData.getPath());
    }

    private Response executeDeleteRequest(RequestData requestData) {
        return given()
                .baseUri(requestData.getUrl())
                .headers(requestData.getHeaders())
                .pathParams(requestData.getPathParams())
            .when()
                .delete(requestData.getPath());
    }

}
