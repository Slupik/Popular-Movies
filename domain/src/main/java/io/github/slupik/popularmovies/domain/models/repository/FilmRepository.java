package io.github.slupik.popularmovies.domain.models.repository;

import java.util.List;

import io.github.slupik.popularmovies.domain.models.film.Film;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface FilmRepository {
    List<Film> getFavouriteList();
    boolean isFavourite(Film film);

    void addFilm(Film film);

    void deleteFilm(Film film);
}
