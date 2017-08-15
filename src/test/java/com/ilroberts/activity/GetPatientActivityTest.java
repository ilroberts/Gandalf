package com.ilroberts.activity;

import ca.uhn.fhir.model.dstu2.resource.Patient;
import com.ilroberts.api.BlackPearAPI;
import com.ilroberts.api.BlackPearAPIMockImpl;
import io.atlassian.fugue.Option;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JukitoRunner.class)
public class GetPatientActivityTest {

    public static class Module extends JukitoModule {
        @Override
        protected void configureTest() {
            bind(BlackPearAPI.class).to(BlackPearAPIMockImpl.class);
        }
    }

    @Inject
    private GetPatientActivityImpl getPatientActivity;

    @Test
    public void testGetPatient() {

        String orgId = "10101";
        String patientId = "123456";

        Option<Patient> patient = getPatientActivity.getPatient(orgId, patientId);
        assertThat(patient).isEqualTo(Option.none());
    }
}
