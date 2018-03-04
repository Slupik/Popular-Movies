package io.github.slupik.popularmovies.domain.downloader.list.trailer;

import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.trailer.TrailerList;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface TrailerListDownloader<D extends TrailerListDownloader.Data> {
    void downloadTrailers(Callback callback, D data);

    interface Callback {
        void onSuccess(TrailerList data);
        void onFail(TheMovieDbDownloadError error);
        void onFail(Throwable error);
    }

    interface Data {
        String getLanguage();
        Data setLanguage(String language);
        String getApiKey();
        Data setApiKey(String apiKey);
        String getMovieId();
        Data setMovieId(String movieId);
    }
}
