package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;

public interface GetPatientActivity {

    Patient getPatient(String orgId, String patientId);
}
