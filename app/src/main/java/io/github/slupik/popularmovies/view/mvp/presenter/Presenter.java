package io.github.slupik.popularmovies.view.mvp.presenter;

import io.github.slupik.popularmovies.view.mvp.presented.PresentedView;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface Presenter<V extends PresentedView> {
    void onAttach(V view);
    void onDetach();
    boolean isViewAttached();
}
