package com.ilroberts.helper;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import io.atlassian.fugue.Option;

public interface BlackPearHelper {

    Option<Patient> getPatientFromResponse(String response);
}
