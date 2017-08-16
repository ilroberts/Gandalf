package com.ilroberts.response;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public interface Response {

    HttpResponse<JsonNode> get();
    int getStatus();
    JsonNode getBody();

}
