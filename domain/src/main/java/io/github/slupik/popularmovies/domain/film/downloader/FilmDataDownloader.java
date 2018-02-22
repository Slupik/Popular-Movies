package io.github.slupik.popularmovies.domain.film.downloader;

import io.github.slupik.popularmovies.domain.film.list.FilmList;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmDataDownloader<D extends DataForDownloader> {
    void downloadPopular(Callback callback, D data);
    void downloadTopRated(Callback callback, D data);

    interface Callback {
        void onSuccess(FilmList data);
        void onFail(FilmDownloadError error);
        void onFail(Throwable error);
    }
}
