package io.github.slupik.data.downloader.list.trailer;

import android.support.annotation.NonNull;

import io.github.slupik.data.models.trailer.TrailerListBean;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.trailer.TrailerList;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

class TrailersRetrofitCallback implements retrofit2.Callback<TrailerListBean> {
    private TrailersRetrofitDownloader.Callback callback;

    TrailersRetrofitCallback(TrailersRetrofitDownloader.Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<TrailerListBean> call, @NonNull Response<TrailerListBean> response) {
        if(response.isSuccessful()) {
            TrailerList body = response.body();
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
    public void onFailure(@NonNull Call<TrailerListBean> call, @NonNull Throwable t) {
        callback.onFail(t);
    }
}
