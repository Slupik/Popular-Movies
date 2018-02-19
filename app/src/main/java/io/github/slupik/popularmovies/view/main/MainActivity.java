package io.github.slupik.popularmovies.view.main;

import android.os.Bundle;

import java.util.List;

import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDownloadError;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

public class MainActivity extends BaseActivity implements MainPresentedView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void addFilms(List<Film> list) {

    }

    @Override
    public void flushFilms() {

    }

    @Override
    public void errorUnknownSortType() {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.unknown_film_sort_type);
    }

    @Override
    public void errorWhileDownloading(FilmDownloadError error) {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.connection_error_check_connection);
    }

    @Override
    public void errorUnknownWhileDownloading() {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.connection_unknown_error);
    }
}
