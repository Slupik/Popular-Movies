package io.github.slupik.data.downloader.list.film;

import io.github.slupik.popularmovies.domain.downloader.list.film.FilmListDownloader;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class RetrofitDownloadDataList implements FilmListDownloader.Data {
    private int pageOfRanking = 1;
    private String language = "en-US";
    private String apiKey = "";
    private String movieId;
    private int pageOfReviews;

    public int getPageOfRanking() {
        return pageOfRanking;
    }

    public RetrofitDownloadDataList setPageOfRanking(int page) {
        this.pageOfRanking = page;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public RetrofitDownloadDataList setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public RetrofitDownloadDataList setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public RetrofitDownloadDataList setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setPageOfReviews(int pageOfReviews) {
        this.pageOfReviews = pageOfReviews;
    }

    public int getPageOfReviews() {
        return pageOfReviews;
    }
}