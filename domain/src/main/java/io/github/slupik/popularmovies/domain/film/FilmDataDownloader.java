package io.github.slupik.popularmovies.domain.film;

import java.util.List;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmDataDownloader {
    void downloadPopular(Callback callback);
    void downloadTopRated(Callback callback);

    interface Callback {
        void onSuccess(List<Film> data);
        void onFail(FilmDownloadError error);
        void onFail(Throwable error);
    }
}
