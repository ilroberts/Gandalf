package com.ilroberts.api;

import com.ilroberts.response.GetPatientResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import io.atlassian.fugue.Option;

public class BlackPearAPIMockImpl implements BlackPearAPI {

    @Override
    public Option<GetPatientResponse> getPatient(String orgId, String patientId) {
        return Option.none();
    }
}
