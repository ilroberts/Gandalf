package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import com.ilroberts.api.BlackPearAPI;
import com.ilroberts.helper.BlackPearHelper;
import com.ilroberts.response.GetPatientResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import io.atlassian.fugue.Option;

import javax.inject.Inject;

public class GetPatientActivityImpl implements GetPatientActivity {

    @Inject
    private BlackPearAPI blackPearAPI;

    @Inject
    private BlackPearHelper helper;

    public Option<Patient> getPatient(String orgId, String patientId) {

        Option<GetPatientResponse> response = blackPearAPI.getPatient(orgId, patientId);

        if(response.isEmpty() || (response.get().getStatus() != 200)) {
            return Option.none();
        }

        String body = response.get().getBody().toString();
        System.out.println(body);
        return helper.getPatientFromResponse(response.get());
    }
}
