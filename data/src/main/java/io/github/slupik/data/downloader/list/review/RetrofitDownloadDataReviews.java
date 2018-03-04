package io.github.slupik.data.downloader.list.review;

import io.github.slupik.popularmovies.domain.downloader.list.review.ReviewListDownloader;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class RetrofitDownloadDataReviews implements ReviewListDownloader.Data {
    private String language = "en-US";
    private String apiKey = "apiKey";
    private String movieId = "-1";
    private int pageOfReviews = 1;

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public RetrofitDownloadDataReviews setLanguage(String language) {
        this.language = language;
        return this;
    }

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public RetrofitDownloadDataReviews setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    @Override
    public String getMovieId() {
        return movieId;
    }

    @Override
    public RetrofitDownloadDataReviews setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    @Override
    public int getPageOfReviews() {
        return pageOfReviews;
    }

    @Override
    public void setPageOfReviews(int pageOfReviews) {
        this.pageOfReviews = pageOfReviews;
    }
}
