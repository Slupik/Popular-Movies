package io.github.slupik.data.film.downloader;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.data.film.FilmBean;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDataDownloader;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDownloadError;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class FilmListRetrofitCallback implements retrofit2.Callback<List<FilmBean>> {
    private FilmDataDownloader.Callback callback;

    FilmListRetrofitCallback(FilmDataDownloader.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<List<FilmBean>> call, @NonNull Response<List<FilmBean>> response) {
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
            callback.onFail(FilmDownloadError.UNKNOWN);
        }
    }

    @Override
    public void onFailure(@NonNull Call<List<FilmBean>> call, @NonNull Throwable t) {
        callback.onFail(t);
    }
}
