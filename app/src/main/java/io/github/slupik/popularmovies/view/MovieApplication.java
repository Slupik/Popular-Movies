package io.github.slupik.popularmovies.view;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.github.slupik.popularmovies.dagger.view.app.DaggerAppComponent;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class MovieApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
