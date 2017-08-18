package com.ilroberts;

import ca.uhn.fhir.context.FhirContext;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.ilroberts.activity.GetPatientActivity;
import com.ilroberts.activity.GetPatientActivityImpl;
import com.ilroberts.api.BlackPearAPI;
import com.ilroberts.api.BlackPearAPIImpl;
import com.ilroberts.configuration.BlackPearConfiguration;
import com.ilroberts.helper.BlackPearHelper;
import com.ilroberts.helper.BlackPearHelperImpl;

import javax.inject.Named;

public class ServerModule extends AbstractModule {

    @Override
    public void configure() {

        bind(BlackPearHelper.class).to(BlackPearHelperImpl.class);
        bind(GetPatientActivity.class).to(GetPatientActivityImpl.class);
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

    @Provides@Singleton
    public FhirContext providesFhirContext(){
        return FhirContext.forDstu2();
    }
}
