package io.github.slupik.data.film;

import com.google.gson.annotations.SerializedName;

import io.github.slupik.popularmovies.domain.film.SavedFilm;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class SavedFilmBean extends FilmBean implements SavedFilm {
    @SerializedName("id")
    private int localId = -1;

    @Override
    public SavedFilm setLocalId(int id) {
        localId = id;
        return this;
    }

    @Override
    public int getLocalId() {
        return localId;
    }
}
