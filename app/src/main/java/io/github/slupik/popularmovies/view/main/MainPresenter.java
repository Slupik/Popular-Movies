package io.github.slupik.popularmovies.view.main;

import io.github.slupik.popularmovies.view.mvp.presenter.Presenter;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface MainPresenter extends Presenter<MainPresentedView> {
    void switchFilmsType(FilmsType type);
    void downloadMoreData();
}
