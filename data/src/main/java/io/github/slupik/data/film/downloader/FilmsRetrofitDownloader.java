package io.github.slupik.data.film.downloader;

import java.util.List;

import javax.inject.Inject;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.film.FilmBean;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDataDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class FilmsRetrofitDownloader implements FilmDataDownloader<RetrofitDownloadData> {

    @Inject
    RetrofitDownloader downloader;

    public FilmsRetrofitDownloader(){
        DaggerFilmRetrofitDownloaderComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void downloadPopular(final Callback callback, RetrofitDownloadData data) {
        Call<List<FilmBean>> call = downloader.getPopularFilms(data.getApiKey(), data.getLanguage(), data.getPage());
        call.enqueue(new FilmListRetrofitCallback(callback));
    }

    @Override
    public void downloadTopRated(final Callback callback, RetrofitDownloadData data) {
        Call<List<FilmBean>> call = downloader.getTopRatedFilms(data.getApiKey(), data.getLanguage(), data.getPage());
        call.enqueue(new FilmListRetrofitCallback(callback));
    }
}
