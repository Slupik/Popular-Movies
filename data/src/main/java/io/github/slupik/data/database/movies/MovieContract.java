package io.github.slupik.data.database.movies;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Sebastian Witasik on 07.01.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

class MovieContract {
	static final String AUTHORITY = "io.github.slupik.popularmovies";
	static final Uri BASE_CONTENT_URI = Uri.parse("content://"+AUTHORITY);
	static final String PATH_MOVIES = "movies";
	static final String PATH_MOVIES_ONLINE = "moviesonline";

	static final class MovieEntry implements BaseColumns {

	    static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_MOVIES).build();
	    static final Uri CONTENT_ONLINE_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_MOVIES_ONLINE).build();

		static final String TABLE_NAME = "movielist";

        static final String COLUMN_TITLE = "title";
		static final String COLUMN_RELEASE_DATE = "releaseDate";
		static final String COLUMN_POSTER_PATH = "posterPath";
		static final String COLUMN_BACKDROP_PATH = "backdropPath";
		static final String COLUMN_VOTE_AVERAGE = "voteAverage";
		static final String COLUMN_OVERVIEW = "overview";
		static final String COLUMN_FAVOURITE = "favourite";
		static final String COLUMN_IMAGE_POSTER = "posterImage";
		static final String COLUMN_IMAGE_BACKDROP = "backdropImage";
		static final String COLUMN_ONLINE_ID = "onlineId";
	}
}
