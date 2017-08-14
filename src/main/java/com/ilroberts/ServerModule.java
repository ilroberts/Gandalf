package com.ilroberts;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.ilroberts.activity.Activity;
import com.ilroberts.activity.HelloActivity;
import com.ilroberts.configuration.BlackPearConfiguration;

import javax.inject.Named;

public class ServerModule extends AbstractModule {

    @Override
    public void configure() {

    }

    @Provides
    @Named("helloActivity")
    public Activity provideActivity(ServerConfiguration configuration) {
        return new HelloActivity(configuration.getMessage());
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

}
