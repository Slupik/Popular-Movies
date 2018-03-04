package io.github.slupik.data.dagger.film.downloader;

import com.google.gson.Gson;

import dagger.Component;
import io.github.slupik.data.downloader.list.BaseRetrofitDownloader;
import io.github.slupik.data.downloader.list.RetrofitDownloader;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

@Component(modules = {RetrofitModule.class, GsonModule.class})
public interface FilmRetrofitDownloaderComponent {
    void inject(BaseRetrofitDownloader downloader);

    Gson getGson();
    RetrofitDownloader getDownloader();
}
