package io.github.slupik.data.database.movies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

/**
 * Created by Sebastian Witasik on 07.01.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

class MovieDbHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "movielist.db";
	private static final int DATABASE_VERSION = 1;
	private static MovieDbHelper sInstance;

	private MovieDbHelper(@NonNull Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	static synchronized MovieDbHelper getInstance(Context context) {
		if (sInstance == null) {
			sInstance = new MovieDbHelper(context.getApplicationContext());
		}
		return sInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		final String SQL_CREATE_MOVIELIST_TABLE = "CREATE TABLE " +
				MovieContract.MovieEntry.TABLE_NAME + " (" +
				MovieContract.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				MovieContract.MovieEntry.COLUMN_ONLINE_ID + " INTEGER NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_TITLE + " VARCHAR(200) NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_POSTER_PATH + " VARCHAR(50) NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_BACKDROP_PATH + " VARCHAR(50) NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_VOTE_AVERAGE + " DOUBLE NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_OVERVIEW + " TEXT NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_RELEASE_DATE + " VARCHAR(20) NOT NULL, " +
				MovieContract.MovieEntry.COLUMN_FAVOURITE + " BOOLEAN NOT NULL DEFAULT 0, " +
				MovieContract.MovieEntry.COLUMN_IMAGE_POSTER + " BLOB, " +
				MovieContract.MovieEntry.COLUMN_IMAGE_BACKDROP + " BLOB" +
				");";
		sqLiteDatabase.execSQL(SQL_CREATE_MOVIELIST_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
	    /*
		It's bad practice but in this project there is no need to change this because
		the database will not be changed
		 */
		sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ MovieContract.MovieEntry.TABLE_NAME);
		onCreate(sqLiteDatabase);
	}

	@Override
	public synchronized void close() {
		super.close();
		sInstance = null;
	}
}
