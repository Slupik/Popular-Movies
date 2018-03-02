package io.github.slupik.popularmovies.domain.downloader.list.review;

import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.film.FilmList;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface ReviewListDownloader<D extends ReviewListDownloader.Data> {
    void downloadReviews(Callback callback, D data);

    interface Callback {
        void onSuccess(FilmList data);
        void onFail(TheMovieDbDownloadError error);
        void onFail(Throwable error);
    }

    interface Data {
    }
}
