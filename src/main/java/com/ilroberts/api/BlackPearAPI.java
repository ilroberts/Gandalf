package com.ilroberts.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import io.atlassian.fugue.Option;

public interface BlackPearAPI {

   Option<HttpResponse<JsonNode>> getPatient(String orgId, String patientId);
}
