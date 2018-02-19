package io.github.slupik.popularmovies.domain.film.list;

import java.util.List;

import io.github.slupik.popularmovies.domain.film.Film;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface FilmList {
    List<Film> getList();
    FilmList setList(List<Film> list);

    int getPage();
    FilmList setPage(int page);

    int getTotalResults();
    FilmList setTotalResults(int totalResults);

    int getTotalPages();
    FilmList setTotalPages(int totalPages);
}
