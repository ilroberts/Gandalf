package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GetPatientActivityTest {


    private GetPatientActivityImpl getPatientActivity;

    @Before
    public void init() {
        getPatientActivity = new GetPatientActivityImpl();
    }

    @Test
    public void testGetPatient() {

        String orgId = "10101";
        String patientId = "123456";

        Patient patient = getPatientActivity.getPatient(orgId, patientId);
        assertThat(patient).isNotNull();

    }
}
