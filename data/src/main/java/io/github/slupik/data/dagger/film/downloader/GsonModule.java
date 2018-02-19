package io.github.slupik.data.dagger.film.downloader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.film.gson.FilmDeserializer;
import io.github.slupik.popularmovies.domain.film.Film;

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
                .registerTypeAdapter(Film.class, new FilmDeserializer())
                .setLenient()
                .create();
    }
}
