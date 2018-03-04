package io.github.slupik.popularmovies.domain.downloader;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public enum TheMovieDbDownloadError {
    OTHER,
    UNKNOWN,
    WRONG_API_KEY,
    NO_PERMISSION,
    EMPTY_BODY, NO_INTERNET_CONNECTION
}
