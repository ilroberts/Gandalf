package com.ilroberts.helper;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import com.ilroberts.response.GetPatientResponse;
import io.atlassian.fugue.Option;

public interface BlackPearHelper {

    Option<Patient> getPatientFromResponse(GetPatientResponse response);
}
