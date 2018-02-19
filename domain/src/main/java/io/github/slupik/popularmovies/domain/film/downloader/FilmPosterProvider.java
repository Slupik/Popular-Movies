package io.github.slupik.popularmovies.domain.film.downloader;

import io.github.slupik.popularmovies.domain.film.Film;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmPosterProvider {
    String getThumbnailUrl(Film bean);
    String getDetailUrl(Film bean);
}
