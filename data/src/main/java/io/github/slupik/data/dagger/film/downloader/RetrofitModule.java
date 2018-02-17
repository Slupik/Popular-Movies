package io.github.slupik.data.dagger.film.downloader;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.film.downloader.RetrofitDownloader;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
@Module(includes = {GsonModule.class, TheMovieDbApi.class})
class RetrofitModule {
    private static final String BASE_URL = "http://api.themoviedb.org/3/movie/popular?api_key=";

    @Provides
    Retrofit retrofit(Gson gson, String apiKey){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL+apiKey)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    RetrofitDownloader downloader(Retrofit retrofit) {
        return retrofit.create(RetrofitDownloader.class);
    }
}
