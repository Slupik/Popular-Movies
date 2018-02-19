package io.github.slupik.popularmovies.view.main;

import java.util.List;

import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDownloadError;
import io.github.slupik.popularmovies.view.mvp.presented.PresentedView;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

interface MainPresentedView extends PresentedView {
    void addFilms(List<Film> list);
    void flushFilms();

    void errorUnknownSortType();

    void errorWhileDownloading(FilmDownloadError error);

    void errorUnknownWhileDownloading();
}
