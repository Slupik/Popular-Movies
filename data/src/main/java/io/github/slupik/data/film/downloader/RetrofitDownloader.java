package io.github.slupik.data.film.downloader;

import io.github.slupik.data.film.list.FilmListBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface RetrofitDownloader {
    //@GET("movie/popular?api_key={api_key}&language={language}&page={page}")
    @GET("movie/popular")
    Call<FilmListBean> getPopularFilms(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("page") int page);

    //@GET("movie/top_rated?api_key={api_key}&language={language}&page={page}")
    @GET("movie/top_rated")
    Call<FilmListBean> getTopRatedFilms(@Query("api_key") String apiKey,
                                        @Query("language") String language,
                                        @Query("page") int page);
}
