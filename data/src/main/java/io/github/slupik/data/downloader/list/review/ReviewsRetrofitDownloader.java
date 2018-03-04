package io.github.slupik.data.downloader.list.review;

import io.github.slupik.data.downloader.list.BaseRetrofitDownloader;
import io.github.slupik.data.models.review.ReviewListBean;
import io.github.slupik.popularmovies.domain.downloader.list.review.ReviewListDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class ReviewsRetrofitDownloader extends BaseRetrofitDownloader implements ReviewListDownloader<ReviewListDownloader.Data> {

    @Override
    public void downloadReviews(final Callback callback, ReviewListDownloader.Data data) {
        Call<ReviewListBean> call = getDownloader().getReviews(
                data.getMovieId(),
                data.getApiKey(),
                data.getLanguage(),
                data.getPageOfReviews());
        call.enqueue(new ReviewsRetrofitCallback(callback));
    }
}
