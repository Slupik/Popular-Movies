package io.github.slupik.popularmovies.dagger.view.main;

import dagger.Component;
import io.github.slupik.popularmovies.dagger.view.DownloaderModule;
import io.github.slupik.popularmovies.dagger.view.FilmRepositoryModule;
import io.github.slupik.popularmovies.view.main.MainPresenterImpl;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

@Component(modules = {DownloaderModule.class, FilmRepositoryModule.class})
public interface PresenterComponent {
    void inject(MainPresenterImpl presenter);
}
