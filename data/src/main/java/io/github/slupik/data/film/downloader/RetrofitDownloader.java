package io.github.slupik.data.film.downloader;

import java.util.List;

import io.github.slupik.data.film.FilmBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface RetrofitDownloader {
    @GET("/movie/popular")
    Call<List<FilmBean>> getPopularFilms();

    @GET("/movie/top_rated")
    Call<List<FilmBean>> getTopRatedFilms();
}
