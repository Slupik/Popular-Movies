package io.github.slupik.popularmovies.view.detail;

import android.view.View;

import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.view.mvp.presented.PresentedView;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

interface DetailPresentedView extends PresentedView {
    void makeViewAsFavourite(boolean isFavourite);
    void populateFields(Film film);
    void addTrailerView(View view);
}
