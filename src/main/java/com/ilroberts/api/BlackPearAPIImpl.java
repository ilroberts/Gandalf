package com.ilroberts.api;

import com.ilroberts.configuration.BlackPearConfiguration;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.atlassian.fugue.Option;

import javax.inject.Inject;

public class BlackPearAPIImpl implements BlackPearAPI {

    private BlackPearConfiguration bpc;

    @Inject
    public BlackPearAPIImpl(BlackPearConfiguration conf) {
        this.bpc = conf;
    }

    @Override
    public Option<HttpResponse<JsonNode>> getPatient(String orgId, String patientId) {

        HttpResponse<JsonNode> response;
        try {

            String url = bpc.getBaseUrl() + "/{orgId}/Patient";
            response  = Unirest.get(url)
                    .routeParam("orgId", orgId)
                    .queryString("identifier", patientId)
                    .header("Authorization", bpc.getAuthorizationString()).asJson();

            return Option.some(response);

        } catch (UnirestException e) {
            e.printStackTrace();
            return(Option.none());
        }
    }
}
