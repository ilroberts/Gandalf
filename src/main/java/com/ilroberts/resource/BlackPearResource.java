package com.ilroberts.resource;

import com.ilroberts.activity.GetPatientActivity;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Organization")
@Api("/Organization")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlackPearResource {

    @Inject
    private GetPatientActivity getPatientActivity;

    @GET
    @Path("/{orgId}/Patient/{patientId}")
    public String getPatient(@PathParam("orgId") String orgId, @PathParam("patientId") String patientId) {

        getPatientActivity.getPatient(orgId, patientId);
        return "";
    }


}
