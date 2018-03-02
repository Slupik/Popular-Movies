package io.github.slupik.popularmovies.dagger.view;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.downloader.list.film.FilmListRetrofitDownloader;
import io.github.slupik.data.downloader.list.trailer.TrailersRetrofitDownloader;
import io.github.slupik.popularmovies.domain.downloader.list.film.FilmListDownloader;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
@Module
public class DownloaderModule {
    @Provides
    public FilmListDownloader getListDownloader(){
        return new FilmListRetrofitDownloader();
    }

    @Provides
    public TrailersRetrofitDownloader getTrailerDownloader(){
        return new TrailersRetrofitDownloader();
    }
}
