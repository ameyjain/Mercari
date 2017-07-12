package com.mercari.mercaritest.dagger;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final MercariApp app;

    AppModule(@NonNull MercariApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public MercariApp provideApp() {
        return app;
    }
}
