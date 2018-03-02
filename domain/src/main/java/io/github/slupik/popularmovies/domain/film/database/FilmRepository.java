package io.github.slupik.popularmovies.domain.film.database;

import java.util.List;

import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.SavedFilm;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmRepository {
    List<SavedFilm> getFavouriteList();
    boolean isFavourite(Film film);
    SavedFilm getFilm(Film film);

    void addFilm(Film film);

    void deleteFilm(SavedFilm film);
}
