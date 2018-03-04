package io.github.slupik.data.database.movies;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.List;

import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.models.repository.FilmRepository;

import static android.provider.BaseColumns._ID;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_BACKDROP_PATH;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_IMAGE_BACKDROP;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_IMAGE_POSTER;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_ONLINE_ID;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_OVERVIEW;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_POSTER_PATH;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_RELEASE_DATE;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_TITLE;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.COLUMN_VOTE_AVERAGE;
import static io.github.slupik.data.database.movies.MovieContract.MovieEntry.CONTENT_URI;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class MovieRepository implements FilmRepository {
    private Context context;

    public MovieRepository(Context context) {
        this.context = context;
    }

    @Override
    public boolean isFavourite(Film film) {
        String stringId = Integer.toString(film.getOnlineId());
        Uri uri = CONTENT_URI;
        uri = uri.buildUpon().appendPath(stringId).build();
        Cursor cursor = getContentResolver().query(uri,
                null,
                null,
                null,
                COLUMN_TITLE);
        List<Film> list = CursorConverter.convertToFilmList(cursor);
        return list.size()>0;
    }

    @Override
    public List<Film> getFavouriteList() {
        Cursor cursor = getContentResolver().query(CONTENT_URI,
                null,
                null,
                null,
                COLUMN_TITLE);
        return CursorConverter.convertToFilmList(cursor);
    }

    @Override
    public void addFilm(Film film) {
        ContentValues value = new ContentValues();
        value.put(COLUMN_BACKDROP_PATH, film.getBackdropPath());
        value.put(COLUMN_POSTER_PATH, film.getPosterPath());
        value.put(COLUMN_OVERVIEW, film.getOverview());
        value.put(COLUMN_RELEASE_DATE, film.getReleaseDate());
        value.put(COLUMN_TITLE, film.getTitle());
        value.put(COLUMN_VOTE_AVERAGE, film.getVoteAverage());
        value.put(COLUMN_IMAGE_BACKDROP, film.getBackdropImage());
        value.put(COLUMN_IMAGE_POSTER, film.getPosterImage());
        value.put(COLUMN_ONLINE_ID, film.getOnlineId());
        value.put(_ID, film.getOnlineId());
        getContentResolver().insert(CONTENT_URI,  value);
    }

    @Override
    public void deleteFilm(Film film) {
        String stringId = Integer.toString(film.getOnlineId());
        Uri uri = CONTENT_URI;
        uri = uri.buildUpon().appendPath(stringId).build();
        getContentResolver().delete(uri,
                null,
                null);
    }

    private ContentResolver getContentResolver(){
        return context.getContentResolver();
    }
}
