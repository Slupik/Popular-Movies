package io.github.slupik.data.downloader.list.film;

import io.github.slupik.data.downloader.list.BaseRetrofitDownloader;
import io.github.slupik.data.models.film.FilmListBean;
import io.github.slupik.popularmovies.domain.downloader.list.film.FilmListDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class FilmListRetrofitDownloader extends BaseRetrofitDownloader implements FilmListDownloader<FilmListDownloader.Data> {

    @Override
    public void downloadPopular(final Callback callback, FilmListDownloader.Data data) {
        Call<FilmListBean> call = getDownloader().getPopularFilms(
                data.getApiKey(),
                data.getLanguage(),
                data.getPageOfRanking());
        call.enqueue(new FilmListRetrofitCallback(callback));
    }

    @Override
    public void downloadTopRated(final Callback callback, FilmListDownloader.Data data) {
        Call<FilmListBean> call = getDownloader().getTopRatedFilms(
                data.getApiKey(),
                data.getLanguage(),
                data.getPageOfRanking());
        call.enqueue(new FilmListRetrofitCallback(callback));
    }
}
