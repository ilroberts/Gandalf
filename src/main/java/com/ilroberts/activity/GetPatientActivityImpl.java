package com.ilroberts.activity;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;
import com.ilroberts.api.BlackPearAPI;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import io.atlassian.fugue.Option;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;

public class GetPatientActivityImpl implements GetPatientActivity {

    @Inject
    private BlackPearAPI blackPearAPI;

    public Option<Patient> getPatient(String orgId, String patientId) {

        Option<HttpResponse<JsonNode>> response = blackPearAPI.getPatient(orgId, patientId);

        if(response.isEmpty() || (response.get().getStatus() != 200)) {
            return Option.none();
        }

        // extract the patient from the bundle
        String body = response.get().getBody().toString();
        JSONObject root = new JSONObject(body);
        JSONArray entryArray = root.getJSONArray("entry");
        JSONObject p = entryArray.getJSONObject(0);
        JSONObject x = p.getJSONObject("content");
        String s = x.toString();

        FhirContext ctx = FhirContext.forDstu2();
        IParser parser = ctx.newJsonParser();
        Patient patient = parser.parseResource(Patient.class, s);

        return Option.some(patient);

    }
}
