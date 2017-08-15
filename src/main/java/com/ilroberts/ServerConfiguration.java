package com.ilroberts;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ilroberts.configuration.BlackPearConfiguration;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

public class ServerConfiguration extends Configuration {

    @NotEmpty
    private String message;

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    public String getMessage() {
        return message;
    }

    @JsonProperty("blackpear")
    private BlackPearConfiguration bpc;

    public BlackPearConfiguration getBlackPearConfiguration() {
        return bpc;
    }
}
