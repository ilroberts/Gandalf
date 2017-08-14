package com.ilroberts;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    private final String message;

    @Inject
    public HelloResource(@Named("message") String message) {
        this.message = message;
    }

    @GET
    public String hello() {
        return message;
    }
}
