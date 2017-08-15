package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;

public class GetPatientActivityImpl implements GetPatientActivity {

    public Patient getPatient(String orgId, String patientId) {

        Patient patient = new Patient();
        return patient;
    }
}
