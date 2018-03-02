package io.github.slupik.data.downloader.list.trailer;

import javax.inject.Inject;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.downloader.list.RetrofitDownloader;
import io.github.slupik.data.models.trailer.TrailerListBean;
import io.github.slupik.popularmovies.domain.downloader.list.trailer.TrailerListDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class TrailersRetrofitDownloader implements TrailerListDownloader<RetrofitDownloadDataTrailers> {

    @Inject
    RetrofitDownloader downloader;

    public TrailersRetrofitDownloader(){
        //TODO move this boilerplate code to root of downloader
        downloader = DaggerFilmRetrofitDownloaderComponent.builder()
                .build()
                .getDownloader();
    }

    @Override
    public void downloadTrailers(Callback callback, RetrofitDownloadDataTrailers data) {
        Call<TrailerListBean> call = downloader.getTrailers(
                data.getMovieId(),
                data.getApiKey(),
                data.getLanguage());
        call.enqueue(new TrailersRetrofitCallback(callback));
    }
}
