package io.github.slupik.data.dagger.film.downloader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module
class GsonModule {
    @Provides
    Gson gson(){
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
