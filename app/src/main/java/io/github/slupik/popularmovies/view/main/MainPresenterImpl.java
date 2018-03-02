package io.github.slupik.popularmovies.view.main;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import io.github.slupik.data.downloader.list.film.RetrofitDownloadDataList;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.dagger.view.main.DaggerPresenterComponent;
import io.github.slupik.popularmovies.domain.downloader.list.film.FilmListDownloader;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.film.FilmList;
import io.github.slupik.popularmovies.view.mvp.presenter.BasePresenter;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class MainPresenterImpl extends BasePresenter<MainPresentedView> implements MainPresenter, FilmListDownloader.Callback {
    private FilmsType mActualType = FilmsType.POPULAR;
    @Inject
    FilmListDownloader mDownloader;
    private int page = 1;
    private RetrofitDownloadDataList mDownloadData = new RetrofitDownloadDataList();

    public MainPresenterImpl(Context context) {
        super(context);
        DaggerPresenterComponent.builder().build().inject(this);
        //TODO move this boilerplate to dagger
        String apiKey = context.getString(R.string.key_themoviedb);
        mDownloadData.setApiKey(apiKey);
    }

    @Override
    public void switchFilmsType(FilmsType type) {
        if(mActualType==type){
            return;
        }
        mActualType = type;
        presented.flushFilms();
        page = 1;
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

    public RetrofitDownloadDataList getData() {
        return mDownloadData
                .setPageOfRanking(page++);
    }

    @Override
    public void onSuccess(FilmList data) {
        presented.addFilms(data.getList());
    }

    @Override
    public void onFail(TheMovieDbDownloadError error) {
        Log.e(MainPresenterImpl.class.getName(), "Error while downloading: "+error.name());
        page--;
        presented.errorWhileDownloading(error);
    }

    @Override
    public void onFail(Throwable error) {
        error.printStackTrace();
        page--;
        presented.errorUnknownWhileDownloading();
    }
}
