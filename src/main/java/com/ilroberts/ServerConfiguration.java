package com.ilroberts;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilroberts.configuration.BlackPearConfiguration;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ServerConfiguration extends Configuration {

    @NotEmpty
    private String message;

    public String getMessage() {
        return message;
    }

    @JsonProperty("blackpear")
    private BlackPearConfiguration bpc;

    public BlackPearConfiguration getBlackPearConfiguration() {
        return bpc;
    }
}
