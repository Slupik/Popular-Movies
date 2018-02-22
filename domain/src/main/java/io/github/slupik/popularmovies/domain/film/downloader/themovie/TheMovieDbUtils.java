package io.github.slupik.popularmovies.domain.film.downloader.themovie;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class TheMovieDbUtils {
    public enum PosterSizes {
        W_92("w92"),
        W_154("w154"),
        W_185("w185"),
        W_342("w342"),
        W_500("w500"),
        W_780("w780"),
        ORIGINAL("original");

        public final String CODE;

        PosterSizes(String code) {
            CODE = code;
        }
    }
    public enum BackdropSizes {
        W_300("w92"),
        W_780("w780"),
        W_1280("w1280"),
        ORIGINAL("original");

        public final String CODE;

        BackdropSizes(String code) {
            CODE = code;
        }
    }
}
