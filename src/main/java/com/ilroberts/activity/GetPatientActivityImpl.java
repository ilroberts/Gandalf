package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import com.ilroberts.api.BlackPearAPI;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import io.atlassian.fugue.Option;

import javax.inject.Inject;

public class GetPatientActivityImpl implements GetPatientActivity {

    @Inject
    private BlackPearAPI blackPearAPI;

    public Patient getPatient(String orgId, String patientId) {

        Patient patient = new Patient();

        Option<HttpResponse<JsonNode>> response = blackPearAPI.getPatient(orgId, patientId);

        if(!response.isEmpty()) {
            System.out.println("do something...");
        }

        return patient;
    }
}
