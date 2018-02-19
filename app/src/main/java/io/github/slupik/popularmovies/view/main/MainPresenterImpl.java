package io.github.slupik.popularmovies.view.main;

import android.content.Context;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.github.slupik.data.film.downloader.RetrofitDownloadData;
import io.github.slupik.popularmovies.dagger.view.main.DaggerPresenterComponent;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDataDownloader;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDownloadError;
import io.github.slupik.popularmovies.view.mvp.presenter.BasePresenter;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class MainPresenterImpl extends BasePresenter<MainPresentedView> implements MainPresenter, FilmDataDownloader.Callback {
    private FilmsType mActualType = FilmsType.POPULAR;
    @Inject
    FilmDataDownloader mDownloader;
    private int page = 1;
    private RetrofitDownloadData mDownloadData = new RetrofitDownloadData();

    public MainPresenterImpl(Context context) {
        super(context);
        DaggerPresenterComponent.builder().build().inject(this);
    }

    @Override
    public void switchFilmsType(FilmsType type) {
        mActualType = type;
        presented.flushFilms();
        downloadMoreData();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void downloadMoreData() {
        if(mActualType==FilmsType.POPULAR) {
            mDownloader.downloadPopular(this, getData());
        } else if(mActualType==FilmsType.TOP_RATED) {
            mDownloader.downloadTopRated(this, getData());
        } else {
            presented.errorUnknownSortType();
        }
    }

    public RetrofitDownloadData getData() {
        return mDownloadData
                .setPage(page++);
    }

    @Override
    public void onSuccess(List<Film> data) {
        presented.addFilms(data);
    }

    @Override
    public void onFail(FilmDownloadError error) {
        Log.e(MainPresenterImpl.class.getName(), "Error while downloading: "+error.name());
        presented.errorWhileDownloading(error);
    }

    @Override
    public void onFail(Throwable error) {
        error.printStackTrace();
        presented.errorUnknownWhileDownloading();
    }
}
