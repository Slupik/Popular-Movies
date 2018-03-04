package io.github.slupik.popularmovies.dagger.view.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module
class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}