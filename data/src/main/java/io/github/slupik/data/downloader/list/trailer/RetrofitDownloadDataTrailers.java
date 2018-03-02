package io.github.slupik.data.downloader.list.trailer;

import io.github.slupik.popularmovies.domain.downloader.list.trailer.TrailerListDownloader;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class RetrofitDownloadDataTrailers implements TrailerListDownloader.Data {
    private String language = "en-US";
    private String apiKey = "";
    private String movieId;

    public String getLanguage() {
        return language;
    }

    public RetrofitDownloadDataTrailers setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public RetrofitDownloadDataTrailers setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public RetrofitDownloadDataTrailers setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getMovieId() {
        return movieId;
    }
}
