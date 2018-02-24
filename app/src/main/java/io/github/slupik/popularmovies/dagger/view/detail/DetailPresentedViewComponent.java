package io.github.slupik.popularmovies.dagger.view.detail;

import dagger.Component;
import io.github.slupik.data.dagger.film.downloader.GsonModule;
import io.github.slupik.popularmovies.view.detail.DetailActivity;

/**
 * Created by Sebastian Witasik on 24.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Component(modules = GsonModule.class)
public interface DetailPresentedViewComponent {
    void inject(DetailActivity activity);
}
