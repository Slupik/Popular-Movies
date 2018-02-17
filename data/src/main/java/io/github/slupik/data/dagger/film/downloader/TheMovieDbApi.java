package io.github.slupik.data.dagger.film.downloader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module
public class TheMovieDbApi {
    private String apiKey;

    public TheMovieDbApi(String apiKey){
        this.apiKey = apiKey;
    }

    @Provides
    String getApiKey() {
        return apiKey;
    }
}
