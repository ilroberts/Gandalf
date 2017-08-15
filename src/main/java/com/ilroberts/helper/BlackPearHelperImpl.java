package com.ilroberts.helper;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;
import com.google.inject.Singleton;
import io.atlassian.fugue.Option;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

        Optional<JSONObject> patientJson = arrayToStream(new JSONObject(response).getJSONArray("entry"))
                .map(JSONObject.class::cast)
                .map(o -> o.get("content"))
                .map(JSONObject.class::cast)
                .filter(t -> t.get("resourceType").equals("Patient"))
                .findFirst();

        if (patientJson.isPresent()) {
            Patient patient = parser.parseResource(Patient.class, patientJson.get().toString());
            return Option.some(patient);
        }
        return Option.none();
    }

    @Nonnull
    private static Stream<Object> arrayToStream(JSONArray array) {
        return StreamSupport.stream(array.spliterator(), false);
    }
}
