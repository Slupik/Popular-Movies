package io.github.slupik.data.dagger.film.downloader;

import com.google.gson.Gson;

import dagger.Component;
import io.github.slupik.data.downloader.list.RetrofitDownloader;
import io.github.slupik.data.downloader.list.film.FilmListRetrofitDownloader;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Component(modules = {RetrofitModule.class, GsonModule.class})
public interface FilmRetrofitDownloaderComponent {
    void inject(FilmListRetrofitDownloader downloader);

    Gson getGson();
    RetrofitDownloader getDownloader();
}
