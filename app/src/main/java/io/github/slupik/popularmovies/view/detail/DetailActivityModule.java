package io.github.slupik.popularmovies.view.detail;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module
public class DetailActivityModule {
    @Provides
    DetailPresenter provideDetailPresenter(Context context) {
        return new DetailPresenterImpl(context);
    }
}
