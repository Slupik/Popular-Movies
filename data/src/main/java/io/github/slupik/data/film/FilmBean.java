package io.github.slupik.data.film;

import com.google.gson.annotations.SerializedName;

import io.github.slupik.popularmovies.domain.film.Film;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class FilmBean implements Film {
    @SerializedName("title")
    private String title;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("thumbnail")
    private String posterUrl;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("overview")
    private String overview;

    @Override
    public Film setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Film setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public Film setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
        return this;
    }

    @Override
    public String getPosterUrl() {
        return posterUrl;
    }

    @Override
    public Film setVoteAverage(double average) {
        this.voteAverage = average;
        return this;
    }

    @Override
    public double getVoteAverage() {
        return voteAverage;
    }

    @Override
    public Film setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    @Override
    public String getOverview() {
        return overview;
    }
}
