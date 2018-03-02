package io.github.slupik.popularmovies.domain.film;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface SavedFilm extends Film {
    SavedFilm setLocalId(int id);
    int getLocalId();
}
