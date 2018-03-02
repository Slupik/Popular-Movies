package io.github.slupik.data.database.movies;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * Created by Sebastian Witasik on 01.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class SaverUtils {
    static int bulkInsert(SQLiteDatabase database, @NonNull ContentValues[] values){
        database.beginTransaction();
        int rowsInserted = 0;
        try {
            for (ContentValues value : values) {
                long _id = database.insert(MovieContract.MovieEntry.TABLE_NAME, null, value);
                if (_id != -1) {
                    rowsInserted++;
                }
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return rowsInserted;
    }
}
