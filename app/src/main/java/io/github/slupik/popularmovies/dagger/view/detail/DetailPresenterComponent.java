package io.github.slupik.popularmovies.dagger.view.detail;

import dagger.Component;
import io.github.slupik.data.dagger.film.downloader.GsonModule;
import io.github.slupik.popularmovies.dagger.view.DownloaderModule;
import io.github.slupik.popularmovies.view.detail.DetailPresenterImpl;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Component(modules = {GsonModule.class, FilmRepositoryModule.class, DownloaderModule.class})
public interface DetailPresenterComponent {
    void inject(DetailPresenterImpl presenter);
}
