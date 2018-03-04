package io.github.slupik.popularmovies.view.detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.github.slupik.data.downloader.list.review.ReviewsRetrofitDownloader;
import io.github.slupik.data.downloader.list.trailer.TrailersRetrofitDownloader;
import io.github.slupik.data.models.film.FilmBean;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.dagger.view.detail.DaggerDetailPresenterComponent;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.downloader.list.review.ReviewListDownloader;
import io.github.slupik.popularmovies.domain.downloader.list.trailer.TrailerListDownloader;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.models.repository.FilmRepository;
import io.github.slupik.popularmovies.domain.models.review.ReviewList;
import io.github.slupik.popularmovies.domain.models.trailer.Trailer;
import io.github.slupik.popularmovies.domain.models.trailer.TrailerList;
import io.github.slupik.popularmovies.view.mvp.presenter.BasePresenter;

import static io.github.slupik.popularmovies.view.detail.DetailActivity.BUNDLE_NAME_WITH_MOVIE_DATA;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class DetailPresenterImpl extends BasePresenter<DetailPresentedView> implements DetailPresenter, TrailerListDownloader.Callback, ReviewListDownloader.Callback {

    @Inject
    FilmRepository repository;
    @Inject
    Gson jsonConverter;
    @Inject
    TrailersRetrofitDownloader mTrailersDownloader;
    @Inject
    ReviewsRetrofitDownloader mReviewsDownloader;
    @Inject
    TrailerListDownloader.Data mDownloadDataTrailers;
    @Inject
    ReviewListDownloader.Data mDownloadDataReviews;

    private int reviewsPage = 1;
    private int maxReviewsPages = 1;

    private Film film;

    public DetailPresenterImpl(Context context) {
        super(context);
    }

    @Override
    protected void useDagger() {
        DaggerDetailPresenterComponent.builder()
                .contextModule(new ContextModule(context))
                .build().inject(this);
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
        mTrailersDownloader.downloadTrailers(this, mDownloadDataTrailers);
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

    @Override
    public void downloadMoreReviews(String id) {
        if(reviewsPage>maxReviewsPages){
            return;
        }
        reviewsPage++;
        mDownloadDataReviews.setMovieId(id);
        mDownloadDataReviews.setPageOfReviews(reviewsPage);
        mReviewsDownloader.downloadReviews(this, mDownloadDataReviews);
    }

    @Override
    public Film getFilm() {
        return film;
    }

    private void makeViewAsFavourite(boolean isFavourite) {
        film.setFavourite(isFavourite);
        presented.makeViewAsFavourite(isFavourite);
    }

    private boolean isFavouriteFilm(Film film) {
        return repository.isFavourite(film);
    }

    private int amountOfTrailers = 0;
    @Override
    public void onSuccess(TrailerList data) {
        for(Trailer trailer:data.getList()){
            View view = new TrailerView(trailer, context).getView();
            presented.addTrailerView(view);
            amountOfTrailers++;
        }
        hideTrailersSectionIfNecessary();
    }

    private int amountOfReviews = 0;
    @Override
    public void onSuccess(ReviewList data) {
        presented.addReviews(data);
        maxReviewsPages = data.getTotalPages();
        amountOfReviews += data.getList().size();
        hideReviewsSectionIfNecessary();
    }

    @Override
    public void onFail(TheMovieDbDownloadError error) {
        System.out.println("error.toString() = " + error.toString());
        hideTrailersSectionIfNecessary();
        hideReviewsSectionIfNecessary();
    }

    @Override
    public void onFail(Throwable error) {
        error.printStackTrace();
        hideTrailersSectionIfNecessary();
        hideReviewsSectionIfNecessary();
    }

    private void hideTrailersSectionIfNecessary() {
        if(amountOfTrailers==0) {
            presented.hideTrailersSection();
        }
    }


    private void hideReviewsSectionIfNecessary() {
        if(amountOfReviews==0) {
            presented.hideReviewsSection();
        }
    }
}
