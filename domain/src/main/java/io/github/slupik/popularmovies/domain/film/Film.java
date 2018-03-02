package io.github.slupik.popularmovies.domain.film;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface Film {
    Film setTitle(String title);
    String getTitle();

    Film setReleaseDate(String releaseDate);
    String getReleaseDate();

    Film setPosterPath(String posterUrl);
    String getPosterPath();

    Film setBackdropPath(String backdropUrl);
    String getBackdropPath();

    Film setVoteAverage(double average);
    double getVoteAverage();

    Film setOverview(String overview);
    String getOverview();

    Film setOnlineId(int id);
    int getOnlineId();

    Film setPosterImage(byte[] image);
    byte[] getPosterImage();

    Film setBackdropImage(byte[] image);
    byte[] getBackdropImage();

    Film setFavourite(boolean isFavourite);
    boolean isFavourite();
}
