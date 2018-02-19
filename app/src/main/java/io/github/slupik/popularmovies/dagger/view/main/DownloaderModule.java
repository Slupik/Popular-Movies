package io.github.slupik.popularmovies.dagger.view.main;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.film.downloader.FilmsRetrofitDownloader;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDataDownloader;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
@Module
class DownloaderModule {
    @Provides
    FilmDataDownloader getDownloader(){
        return new FilmsRetrofitDownloader();
    }
}
