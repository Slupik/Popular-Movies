package io.github.slupik.popularmovies.domain.downloader.list.trailer;

import io.github.slupik.popularmovies.domain.downloader.FilmDownloadError;
import io.github.slupik.popularmovies.domain.models.film.FilmList;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface TrailerListDownloader<D extends TrailerListDownloader.Data> {
    void downloadTrailers(Callback callback, D data);

    interface Callback {
        void onSuccess(FilmList data);
        void onFail(FilmDownloadError error);
        void onFail(Throwable error);
    }

    interface Data {
    }
}
