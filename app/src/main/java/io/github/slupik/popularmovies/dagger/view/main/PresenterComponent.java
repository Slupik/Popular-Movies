package io.github.slupik.popularmovies.dagger.view.main;

import dagger.Component;
import io.github.slupik.popularmovies.view.main.MainPresenterImpl;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Component(modules = {DownloaderModule.class})
public interface PresenterComponent {
    void inject(MainPresenterImpl presenter);
}