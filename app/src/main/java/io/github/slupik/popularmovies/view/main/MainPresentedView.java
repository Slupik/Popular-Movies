package io.github.slupik.popularmovies.view.main;

import java.util.List;

import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.view.mvp.presented.PresentedView;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface MainPresentedView extends PresentedView {
    void addFilms(List<Film> list);
    void flushFilms();
    void changeSortIcons(FilmsType type);

    void errorUnknownSortType();

    void errorWhileDownloading(TheMovieDbDownloadError error);

    void errorUnknownWhileDownloading();
}
