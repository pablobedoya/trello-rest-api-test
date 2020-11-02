package com.trello.restapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateListResponse {
    public String id;
    public String name;
    public Boolean closed;
    public Integer pos;
    public String idBoard;
    public Limits limits;
}
