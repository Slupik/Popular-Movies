package io.github.slupik.popularmovies.domain.models.film;

import io.github.slupik.popularmovies.domain.models.ParcelableModel;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface Film extends ParcelableModel {
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
