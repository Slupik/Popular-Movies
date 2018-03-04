package io.github.slupik.popularmovies.dagger.view.detail;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.view.detail.DetailPresenter;
import io.github.slupik.popularmovies.view.detail.DetailPresenterImpl;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module(includes = {ContextModule.class})
class PresenterModule {

    @Provides
    DetailPresenter providePresenter(Context context){
        return new DetailPresenterImpl(context);
    }
}
