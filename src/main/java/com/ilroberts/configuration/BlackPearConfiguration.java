package com.ilroberts.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class BlackPearConfiguration {

    @NotEmpty
    private String baseUrl;

    @NotEmpty
    private String authorizationString;

    @JsonProperty
    public String getAuthorizationString() {
        return authorizationString;
    }

    @JsonProperty
    public void setAuthorizationString(String authorizationString) {
        this.authorizationString = authorizationString;
    }

    @JsonProperty
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
