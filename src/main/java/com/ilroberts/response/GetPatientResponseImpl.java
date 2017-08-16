package com.ilroberts.response;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class GetPatientResponseImpl extends AbstractResponse implements GetPatientResponse {

    public GetPatientResponseImpl(HttpResponse<JsonNode> response) {
        super(response);
    }
}
