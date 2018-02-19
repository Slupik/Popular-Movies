package io.github.slupik.data.film.downloader;

import java.util.List;

import io.github.slupik.data.film.FilmBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface RetrofitDownloader {
    @GET("movie/popular?api_key={api_key}&language={language}&page={page}")
    Call<List<FilmBean>> getPopularFilms(@Path("api_key") String apiKey,
                                         @Path("language") String language,
                                         @Path("page") int page);

    @GET("movie/top_rated?api_key={api_key}&language={language}&page={page}")
    Call<List<FilmBean>> getTopRatedFilms(@Path("api_key") String apiKey,
                                          @Path("language") String language,
                                          @Path("page") int page);
}
