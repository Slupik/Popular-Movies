package io.github.slupik.data.downloader.list.review;

import android.support.annotation.NonNull;

import io.github.slupik.data.models.film.FilmListBean;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.film.FilmList;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class ReviewsRetrofitCallback implements retrofit2.Callback<FilmListBean> {
    private ReviewsRetrofitDownloader.Callback callback;

    ReviewsRetrofitCallback(ReviewsRetrofitDownloader.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<FilmListBean> call, @NonNull Response<FilmListBean> response) {
        if(response.isSuccessful()) {
            FilmList body = response.body();
            if(body!=null){
                callback.onSuccess(body);
            } else {
                callback.onFail(TheMovieDbDownloadError.EMPTY_BODY);
            }
        } else {
            callback.onFail(TheMovieDbDownloadError.UNKNOWN);
        }
    }

    @Override
    public void onFailure(@NonNull Call<FilmListBean> call, @NonNull Throwable t) {
        callback.onFail(t);
    }
}
