package io.github.slupik.popularmovies.view.detail;

import android.content.Intent;
import android.view.View;

import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.view.mvp.presenter.Presenter;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface DetailPresenter extends Presenter<DetailPresentedView> {
    void processIntent(Intent intent);
    void onFavouriteAction(View view);
    void downloadMoreReviews(String id);
    Film getFilm();
}
