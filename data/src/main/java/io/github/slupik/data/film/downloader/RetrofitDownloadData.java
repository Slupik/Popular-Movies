package io.github.slupik.data.film.downloader;

import io.github.slupik.popularmovies.domain.film.downloader.DataForDownloader;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class RetrofitDownloadData implements DataForDownloader {
    private int page = 1;
    private String language = "en-US";
    private String apiKey = "";

    public int getPage() {
        return page;
    }

    public RetrofitDownloadData setPage(int page) {
        this.page = page;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public RetrofitDownloadData setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public RetrofitDownloadData setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }
}
