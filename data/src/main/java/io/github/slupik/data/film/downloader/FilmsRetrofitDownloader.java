package io.github.slupik.data.film.downloader;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.dagger.film.downloader.TheMovieDbApi;
import io.github.slupik.data.film.FilmBean;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.FilmDataDownloader;
import io.github.slupik.popularmovies.domain.film.FilmDownloadError;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class FilmsRetrofitDownloader implements FilmDataDownloader {

    @Inject
    RetrofitDownloader downloader;

    public FilmsRetrofitDownloader(){
        DaggerFilmRetrofitDownloaderComponent.builder()
                //TODO add Api Key
                .theMovieDbApi(new TheMovieDbApi(""))
                .build()
                .inject(this);
    }

    @Override
    public void downloadPopular(final Callback callback) {
        Call<List<FilmBean>> call = downloader.getPopularFilms();
        call.enqueue(new retrofit2.Callback<List<FilmBean>>() {
            @Override
            public void onResponse(@ParametersAreNonnullByDefault Call<List<FilmBean>> call,
                                   @ParametersAreNonnullByDefault Response<List<FilmBean>> response) {
                if(response.isSuccessful()) {
                    List<FilmBean> body = response.body();
                    if(body!=null){
                        List<Film> data = new ArrayList<>();
                        data.addAll(body);
                        callback.onSuccess(data);
                    } else {
                        callback.onFail(FilmDownloadError.EMPTY_BODY);
                    }
                } else {
                    callback.onFail(FilmDownloadError.UNKNOW);
                }
            }

            @Override
            public void onFailure(Call<List<FilmBean>> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }

    @Override
    public void downloadTopRated(final Callback callback) {
        Call<List<FilmBean>> call = downloader.getTopRatedFilms();
        call.enqueue(new retrofit2.Callback<List<FilmBean>>() {
            @Override
            public void onResponse(@ParametersAreNonnullByDefault Call<List<FilmBean>> call,
                                   @ParametersAreNonnullByDefault Response<List<FilmBean>> response) {
                if(response.isSuccessful()) {
                    List<FilmBean> body = response.body();
                    if(body!=null){
                        List<Film> data = new ArrayList<>();
                        data.addAll(body);
                        callback.onSuccess(data);
                    } else {
                        callback.onFail(FilmDownloadError.EMPTY_BODY);
                    }
                } else {
                    callback.onFail(FilmDownloadError.UNKNOW);
                }
            }

            @Override
            public void onFailure(Call<List<FilmBean>> call, Throwable t) {
                callback.onFail(t);
            }
        });
    }
}
