package io.github.slupik.data.downloader.list.review;

import javax.inject.Inject;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.downloader.list.RetrofitDownloader;
import io.github.slupik.data.models.review.ReviewListBean;
import io.github.slupik.popularmovies.domain.downloader.list.review.ReviewListDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class ReviewsRetrofitDownloader implements ReviewListDownloader<RetrofitDownloadDataReviews> {

    @Inject
    RetrofitDownloader downloader;

    public ReviewsRetrofitDownloader(){
        downloader = DaggerFilmRetrofitDownloaderComponent.builder()
                .build()
                .getDownloader();
    }

    @Override
    public void downloadReviews(final Callback callback, RetrofitDownloadDataReviews data) {
        Call<ReviewListBean> call = downloader.getReviews(
                data.getMovieId(),
                data.getApiKey(),
                data.getLanguage(),
                data.getPageOfReviews());
        call.enqueue(new ReviewsRetrofitCallback(callback));
    }
}
