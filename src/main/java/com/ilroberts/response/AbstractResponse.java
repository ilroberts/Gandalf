package com.ilroberts.response;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public abstract class AbstractResponse implements Response {

    private final HttpResponse<JsonNode> response;

    public AbstractResponse(HttpResponse<JsonNode> response) {
        this.response = response;
    }

    public HttpResponse<JsonNode> get() {
        return response;
    }

    public int getStatus() {
        return response.getStatus();
    }

    public JsonNode getBody() {
        return response.getBody();
    }
}
