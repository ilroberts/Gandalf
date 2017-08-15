package com.ilroberts.helper;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;
import com.google.inject.Singleton;
import io.atlassian.fugue.Option;
import org.json.JSONArray;
import org.json.JSONObject;

@Singleton
public class BlackPearHelperImpl implements BlackPearHelper {

    private final FhirContext ctx;
    private final IParser parser;

    public BlackPearHelperImpl() {

        ctx = FhirContext.forDstu2();
        parser = ctx.newJsonParser();
    }

    @Override
    public Option<Patient> getPatientFromResponse(String response) {

        JSONObject root = new JSONObject(response);
        JSONArray entryArray = root.getJSONArray("entry");
        JSONObject p = entryArray.getJSONObject(0);
        Patient patient = parser.parseResource(Patient.class, p.getJSONObject("content").toString());
        return Option.some(patient);
    }
}
