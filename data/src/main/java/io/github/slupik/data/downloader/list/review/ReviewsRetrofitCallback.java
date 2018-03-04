package io.github.slupik.data.downloader.list.review;

import android.support.annotation.NonNull;

import io.github.slupik.data.models.review.ReviewListBean;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

class ReviewsRetrofitCallback implements retrofit2.Callback<ReviewListBean> {
    private ReviewsRetrofitDownloader.Callback callback;

    ReviewsRetrofitCallback(ReviewsRetrofitDownloader.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<ReviewListBean> call, @NonNull Response<ReviewListBean> response) {
        if(response.isSuccessful()) {
            ReviewListBean body = response.body();
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
    public void onFailure(@NonNull Call<ReviewListBean> call, @NonNull Throwable t) {
        callback.onFail(t);
    }
}
