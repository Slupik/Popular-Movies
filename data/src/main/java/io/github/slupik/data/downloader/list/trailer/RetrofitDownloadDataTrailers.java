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

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public TrailerListDownloader.Data setLanguage(String language) {
        this.language = language;
        return this;
    }

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public TrailerListDownloader.Data setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    @Override
    public String getMovieId() {
        return movieId;
    }

    @Override
    public TrailerListDownloader.Data setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }
}
