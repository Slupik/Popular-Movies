package io.github.slupik.popularmovies.domain.film.downloader;

import java.util.List;

import io.github.slupik.popularmovies.domain.film.Film;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmDataDownloader<D extends DataForDownloader> {
    void downloadPopular(Callback callback, D data);
    void downloadTopRated(Callback callback, D data);

    interface Callback {
        void onSuccess(List<Film> data);
        void onFail(FilmDownloadError error);
        void onFail(Throwable error);
    }
}
