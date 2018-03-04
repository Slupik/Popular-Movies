package io.github.slupik.data.downloader.list.film;

import javax.inject.Inject;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.downloader.list.RetrofitDownloader;
import io.github.slupik.data.models.film.FilmListBean;
import io.github.slupik.popularmovies.domain.downloader.list.film.FilmListDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class FilmListRetrofitDownloader implements FilmListDownloader<FilmListDownloader.Data> {

    @Inject
    RetrofitDownloader downloader;

    public FilmListRetrofitDownloader(){
        DaggerFilmRetrofitDownloaderComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void downloadPopular(final Callback callback, FilmListDownloader.Data data) {
        Call<FilmListBean> call = downloader.getPopularFilms(
                data.getApiKey(),
                data.getLanguage(),
                data.getPageOfRanking());
        call.enqueue(new FilmListRetrofitCallback(callback));
    }

    @Override
    public void downloadTopRated(final Callback callback, FilmListDownloader.Data data) {
        Call<FilmListBean> call = downloader.getTopRatedFilms(
                data.getApiKey(),
                data.getLanguage(),
                data.getPageOfRanking());
        call.enqueue(new FilmListRetrofitCallback(callback));
    }
}
