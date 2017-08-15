package com.ilroberts;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.ilroberts.activity.Activity;
import com.ilroberts.activity.GetPatientActivity;
import com.ilroberts.activity.GetPatientActivityImpl;
import com.ilroberts.api.BlackPearAPI;
import com.ilroberts.api.BlackPearAPIImpl;
import com.ilroberts.configuration.BlackPearConfiguration;

import javax.inject.Named;

public class ServerModule extends AbstractModule {

    @Override
    public void configure() {

        bind(GetPatientActivity.class).to(GetPatientActivityImpl.class);

    }

    @Provides
    @Named("message")
    public String provideMessage(ServerConfiguration configuration) {
        return configuration.getMessage();
    }

    @Provides
    @Named("blackpear")
    public BlackPearConfiguration getBlackPearConfiguration(ServerConfiguration configuration) {
        return configuration.getBlackPearConfiguration();
    }

    @Provides
    public BlackPearAPI provideBlackPearAPI(ServerConfiguration configuration) {
        return new BlackPearAPIImpl(configuration.getBlackPearConfiguration());
    }
}
