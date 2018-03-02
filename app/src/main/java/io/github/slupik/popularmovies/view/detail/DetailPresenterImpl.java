package io.github.slupik.popularmovies.view.detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.github.slupik.data.film.FilmBean;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.dagger.view.detail.DaggerDetailPresenterComponent;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.database.FilmRepository;
import io.github.slupik.popularmovies.view.mvp.presenter.BasePresenter;

import static io.github.slupik.popularmovies.view.detail.DetailActivity.BUNDLE_NAME_WITH_MOVIE_DATA;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class DetailPresenterImpl extends BasePresenter<DetailPresentedView> implements DetailPresenter {

    @Inject
    FilmRepository repository;

    @Inject
    Gson jsonConverter;

    private Film film;

    public DetailPresenterImpl(Context context) {
        super(context);
        DaggerDetailPresenterComponent.builder().contextModule(new ContextModule(context)).build().inject(this);
    }

    @Override
    public void processIntent(Intent intent) {
        film = getFilmFromData(intent);
        presented.populateFields(film);
        makeViewAsFavourite(isFavouriteFilm(film));
    }

    private Film getFilmFromData(Intent intent) {
        String json = intent.getStringExtra(BUNDLE_NAME_WITH_MOVIE_DATA);
        return jsonConverter.fromJson(json, FilmBean.class);
    }

    @Override
    public void onFavouriteAction(View view) {
        if(film.isFavourite()) {
            repository.deleteFilm(film);
            makeViewAsFavourite(false);
        } else {
            repository.addFilm(film);
            makeViewAsFavourite(true);
        }
    }

    private void makeViewAsFavourite(boolean isFavourite) {
        film.setFavourite(isFavourite);
        presented.makeViewAsFavourite(isFavourite);
    }

    private boolean isFavouriteFilm(Film film) {
        return repository.isFavourite(film);
    }
}
