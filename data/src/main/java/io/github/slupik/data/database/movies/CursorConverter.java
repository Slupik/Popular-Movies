package io.github.slupik.data.database.movies;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.data.film.SavedFilmBean;
import io.github.slupik.popularmovies.domain.film.SavedFilm;

import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.*;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class CursorConverter {
    static final int TRUE = 1;
    static final int FALSE = 0;

    static List<SavedFilm> convertToFilmList(Cursor cursor) {
        List<SavedFilm> list = new ArrayList<>();
        if(cursor==null) return list;
        try {
            cursor.moveToFirst();
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                list.add(convertToFilm(cursor));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return list;
    }

    static SavedFilm convertToFilm(Cursor cursor) {
        SavedFilm value = new SavedFilmBean();
        value.setTitle(cursor.getString(
                cursor.getColumnIndex(COLUMN_TITLE)
        ));
        value.setBackdropPath(cursor.getString(
                cursor.getColumnIndex(COLUMN_BACKDROP_PATH)
        ));
        value.setPosterPath(cursor.getString(
                cursor.getColumnIndex(COLUMN_POSTER_PATH)
        ));
        value.setOverview(cursor.getString(
                cursor.getColumnIndex(COLUMN_OVERVIEW)
        ));
        value.setReleaseDate(cursor.getString(
                cursor.getColumnIndex(COLUMN_RELEASE_DATE)
        ));
        value.setVoteAverage(cursor.getDouble(
                cursor.getColumnIndex(COLUMN_VOTE_AVERAGE)
        ));
        value.setOnlineId(cursor.getInt(
                cursor.getColumnIndex(COLUMN_ONLINE_ID)
        ));
        value.setBackdropImage(cursor.getBlob(
                cursor.getColumnIndex(COLUMN_BACKDROP_PATH)
        ));
        value.setPosterImage(cursor.getBlob(
                cursor.getColumnIndex(COLUMN_IMAGE_POSTER)
        ));

        value.setLocalId(cursor.getInt(
                cursor.getColumnIndex(_ID)
        ));
        return value;
    }
}
