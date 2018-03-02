package io.github.slupik.popularmovies.domain.downloader.list.film;

import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.film.FilmList;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmListDownloader<D extends FilmListDownloader.Data> {
    void downloadPopular(Callback callback, D data);
    void downloadTopRated(Callback callback, D data);

    interface Callback {
        void onSuccess(FilmList data);
        void onFail(TheMovieDbDownloadError error);
        void onFail(Throwable error);
    }

    interface Data {
    }
}
