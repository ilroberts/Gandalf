package com.ilroberts.resource;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.parser.IParser;
import com.ilroberts.activity.GetPatientActivity;
import io.atlassian.fugue.Option;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Organization")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlackPearResource {

    @Inject
    private GetPatientActivity getPatientActivity;
    @Inject
    private FhirContext ctx;

    @GET
    @Path("/{orgId}/Patient/{patientId}")
    public String getPatient(@PathParam("orgId") String orgId, @PathParam("patientId") String patientId) {

        Option<Patient> patient = getPatientActivity.getPatient(orgId, patientId);

        if (!patient.isEmpty()) {

            IParser parser = ctx.newJsonParser();
            return parser.encodeResourceToString(patient.get());
        } else {
            return "oop, something went wrong!";
        }
    }

}
