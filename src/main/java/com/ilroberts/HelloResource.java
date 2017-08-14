package com.ilroberts;

import com.ilroberts.activity.Activity;
import com.ilroberts.configuration.BlackPearConfiguration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    private final BlackPearConfiguration conf;

    @Inject
    private Activity activity;

    @Inject
    public HelloResource(@Named("blackpear") BlackPearConfiguration conf) {
        this.conf = conf;
    }

    @GET
    public String hello() {

        return activity.perform();
    }
}
