package com.ilroberts;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilroberts.configuration.BlackPearConfiguration;
import io.dropwizard.Configuration;

public class ServerConfiguration extends Configuration {

    @JsonProperty("blackpear")
    private BlackPearConfiguration bpc;

    public BlackPearConfiguration getBlackPearConfiguration() {
        return bpc;
    }
}
