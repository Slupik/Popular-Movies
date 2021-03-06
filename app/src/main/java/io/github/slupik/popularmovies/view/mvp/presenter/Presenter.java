package io.github.slupik.popularmovies.view.mvp.presenter;

import io.github.slupik.popularmovies.view.mvp.presented.PresentedView;
import io.github.slupik.popularmovies.view.utils.Restoreable;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface Presenter<V extends PresentedView> extends Restoreable {
    void onAttach(V view);
    void onDetach();
    boolean isViewAttached();
}
