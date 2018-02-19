package io.github.slupik.data.film;

import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.FilmPosterProvider;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class FilmPosterFromTheMovie implements FilmPosterProvider {
    @Override
    public String getThumbnailUrl(Film bean) {
        return null;
    }

    @Override
    public String getDetailUrl(Film bean) {
        return null;
    }
}
