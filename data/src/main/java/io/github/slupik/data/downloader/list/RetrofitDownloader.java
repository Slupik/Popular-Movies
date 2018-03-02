package io.github.slupik.data.downloader.list;

import io.github.slupik.data.models.film.FilmListBean;
import io.github.slupik.data.models.review.ReviewListBean;
import io.github.slupik.data.models.trailer.TrailerListBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    //@GET("movie/{movie_id}/videos?api_key=<<api_key>>&language=en-US")
    @GET("movie/{movie_id}/videos")
    Call<TrailerListBean> getTrailers(@Path("movie_id") String movieId,
                                      @Query("api_key") String apiKey,
                                      @Query("language") String language);

    //@GET("movie/{movie_id}/reviews?api_key=<<api_key>>&language=en-US&page=1")
    @GET("movie/{movie_id}/reviews")
    Call<ReviewListBean> getReviews(
                                    @Path("movie_id") String movieId,
                                    @Query("api_key") String apiKey,
                                    @Query("language") String language,
                                    @Query("page") int page);
}
