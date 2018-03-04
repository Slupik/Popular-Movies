package io.github.slupik.popularmovies.dagger.view.app;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.github.slupik.popularmovies.view.detail.DetailActivity;
import io.github.slupik.popularmovies.view.detail.DetailActivityModule;
import io.github.slupik.popularmovies.view.main.MainActivity;
import io.github.slupik.popularmovies.view.main.MainActivityModule;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = DetailActivityModule.class)
    abstract DetailActivity bindDetailActivity();

}