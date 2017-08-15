package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import io.atlassian.fugue.Option;

public interface GetPatientActivity {

    Option<Patient> getPatient(String orgId, String patientId);
}
