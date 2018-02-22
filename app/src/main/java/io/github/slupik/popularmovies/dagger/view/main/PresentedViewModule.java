package io.github.slupik.popularmovies.dagger.view.main;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.view.main.MainPresenter;
import io.github.slupik.popularmovies.view.main.MainPresenterImpl;

/**
 * Created by Sebastian Witasik on 21.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
@Module(includes = {ContextModule.class})
class PresentedViewModule {
    @Provides
    MainPresenter presenter(Context context){
        return new MainPresenterImpl(context);
    }
}
