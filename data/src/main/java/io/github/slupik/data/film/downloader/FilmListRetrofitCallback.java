package io.github.slupik.data.film.downloader;

import android.support.annotation.NonNull;

import io.github.slupik.data.film.list.FilmListBean;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDataDownloader;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDownloadError;
import io.github.slupik.popularmovies.domain.film.list.FilmList;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class FilmListRetrofitCallback implements retrofit2.Callback<FilmListBean> {
    private FilmDataDownloader.Callback callback;

    FilmListRetrofitCallback(FilmDataDownloader.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<FilmListBean> call, @NonNull Response<FilmListBean> response) {
        if(response.isSuccessful()) {
            FilmList body = response.body();
            if(body!=null){
                callback.onSuccess(body);
            } else {
                callback.onFail(FilmDownloadError.EMPTY_BODY);
            }
        } else {
            callback.onFail(FilmDownloadError.UNKNOWN);
        }
    }

    @Override
    public void onFailure(@NonNull Call<FilmListBean> call, @NonNull Throwable t) {
        callback.onFail(t);
    }
}
