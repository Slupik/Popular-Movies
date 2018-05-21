package io.github.slupik.popularmovies.dagger.view.utils;

import com.google.gson.Gson;

import dagger.Component;
import io.github.slupik.data.dagger.film.downloader.GsonModule;

/**
 * Created by Sebastian Witasik on 12.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

@Component(modules = {GsonModule.class})
public interface LoadableRecyclerViewComponent {
    Gson getGson();
}
