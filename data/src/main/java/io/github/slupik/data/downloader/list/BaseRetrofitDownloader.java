package io.github.slupik.data.downloader.list;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public abstract class BaseRetrofitDownloader {

    private static RetrofitDownloader downloader;

    protected static RetrofitDownloader getDownloader(){
        if(downloader==null){
            downloader = DaggerFilmRetrofitDownloaderComponent.builder()
                    .build()
                    .getDownloader();
        }
        return downloader;
    }
}
