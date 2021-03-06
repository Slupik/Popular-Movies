package io.github.slupik.popularmovies.domain.downloader.list.review;

import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.review.ReviewList;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface ReviewListDownloader<D extends ReviewListDownloader.Data> {
    void downloadReviews(Callback callback, D data);

    interface Callback {
        void onSuccess(ReviewList data);
        void onFail(TheMovieDbDownloadError error);
        void onFail(Throwable error);
    }

    interface Data {
        String getLanguage();
        Data setLanguage(String language);
        String getApiKey();
        Data setApiKey(String apiKey);
        String getMovieId();
        Data setMovieId(String movieId);
        int getPageOfReviews();
        void setPageOfReviews(int pageOfReviews);
    }
}
