package io.github.slupik.popularmovies.view.detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.github.slupik.data.downloader.list.trailer.RetrofitDownloadDataTrailers;
import io.github.slupik.data.downloader.list.trailer.TrailersRetrofitDownloader;
import io.github.slupik.data.models.film.FilmBean;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.dagger.view.detail.DaggerDetailPresenterComponent;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.downloader.list.trailer.TrailerListDownloader;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.models.repository.FilmRepository;
import io.github.slupik.popularmovies.domain.models.trailer.Trailer;
import io.github.slupik.popularmovies.domain.models.trailer.TrailerList;
import io.github.slupik.popularmovies.view.mvp.presenter.BasePresenter;

import static io.github.slupik.popularmovies.view.detail.DetailActivity.BUNDLE_NAME_WITH_MOVIE_DATA;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class DetailPresenterImpl extends BasePresenter<DetailPresentedView> implements DetailPresenter, TrailerListDownloader.Callback {

    @Inject
    FilmRepository repository;

    @Inject
    Gson jsonConverter;

    @Inject
    TrailersRetrofitDownloader mDownloader;

//    private int reviewsPage = 1;
    private RetrofitDownloadDataTrailers mDownloadDataTrailers = new RetrofitDownloadDataTrailers();
//    private RetrofitDownloadDataTrailers mDownloadDataReviews = new RetrofitDownloadDataTrailers();

    private Film film;

    public DetailPresenterImpl(Context context) {
        super(context);
        DaggerDetailPresenterComponent.builder().contextModule(new ContextModule(context)).build().inject(this);
        String apiKey = context.getString(R.string.key_themoviedb);
        mDownloadDataTrailers.setApiKey(apiKey);
    }

    @Override
    public void processIntent(Intent intent) {
        film = getFilmFromData(intent);
        presented.populateFields(film);
        makeViewAsFavourite(isFavouriteFilm(film));
        mDownloadDataTrailers.setMovieId(Integer.toString(film.getOnlineId()));
        downloadTrailers();
    }

    private void downloadTrailers() {
        mDownloader.downloadTrailers(this, mDownloadDataTrailers);
    }

    private Film getFilmFromData(Intent intent) {
        String json = intent.getStringExtra(BUNDLE_NAME_WITH_MOVIE_DATA);
        return jsonConverter.fromJson(json, FilmBean.class);
    }

    @Override
    public void onFavouriteAction(View view) {
        if(film.isFavourite()) {
            repository.deleteFilm(film);
            makeViewAsFavourite(false);
        } else {
            repository.addFilm(film);
            makeViewAsFavourite(true);
        }
    }

    private void makeViewAsFavourite(boolean isFavourite) {
        film.setFavourite(isFavourite);
        presented.makeViewAsFavourite(isFavourite);
    }

    private boolean isFavouriteFilm(Film film) {
        return repository.isFavourite(film);
    }

    @Override
    public void onSuccess(TrailerList data) {
        for(Trailer trailer:data.getList()){
            View view = new TrailerView(trailer, context).getView();
            presented.addTrailerView(view);
        }
    }

    @Override
    public void onFail(TheMovieDbDownloadError error) {
        System.out.println("error.toString() = " + error.toString());
    }

    @Override
    public void onFail(Throwable error) {
        error.printStackTrace();
    }
}
