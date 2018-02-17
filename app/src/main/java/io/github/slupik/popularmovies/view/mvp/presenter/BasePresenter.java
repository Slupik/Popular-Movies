package io.github.slupik.popularmovies.view.mvp.presenter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;

import io.github.slupik.popularmovies.view.mvp.ParentActivityLifecycle;
import io.github.slupik.popularmovies.view.mvp.presented.PresentedView;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public abstract class BasePresenter<V extends PresentedView>
        implements Presenter<V>, ParentActivityLifecycle {
    protected final Context context;
    protected V presented;

    public BasePresenter(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    @CallSuper
    public void onAttach(V presented) {
        this.presented = presented;
    }

    @Override
    @CallSuper
    public void onDetach(){
        if(null!= presented) {
            presented = null;
        }
    }

    @Override
    public boolean isViewAttached() {
        return this.presented != null;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @CallSuper
    @Override
    public void onDestroy() {
        onDetach();
    }

    protected String getString(@StringRes int source) {
        return context.getString(source);
    }
}
