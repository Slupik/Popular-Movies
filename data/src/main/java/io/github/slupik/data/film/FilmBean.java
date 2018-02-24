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
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("poster_path")
    private String posterUrl;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("overview")
    private String overview;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("local_favourite")
    private boolean favourite = false;

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
    public Film setPosterPath(String posterUrl) {
        this.posterUrl = posterUrl;
        return this;
    }

    @Override
    public String getPosterPath() {
        return posterUrl;
    }

    @Override
    public Film setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    @Override
    public String getBackdropPath() {
        return backdropPath;
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

    @Override
    public Film setFavourite(boolean isFavourite) {
        this.favourite = isFavourite;
        return this;
    }

    @Override
    public boolean isFavourite() {
        return favourite;
    }
}
