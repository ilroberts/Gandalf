package com.ilroberts.resource;

import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Organization")
@Api("/Organization")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlackPearResource {


    @GET
    @Path("/{orgId}/Patient/{patientId}")
    public String getPatient(@PathParam("orgId") String orgId, @PathParam("patientId") String patientId) {

        return "";
    }


}
