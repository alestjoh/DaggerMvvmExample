package com.example.daggermvvmexample.di;

import android.content.Context;

import com.example.daggermvvmexample.App;
import com.example.daggermvvmexample.common.domain.model.CommonGreetingRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    CommonGreetingRepository provideCommonHelloService() {
        return new CommonGreetingRepository();
    }
}
