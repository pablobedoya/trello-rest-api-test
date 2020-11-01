package com.trello.restapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {
	
	private T data;
	
	private int statusCode;
	
	private long time;
	
}
