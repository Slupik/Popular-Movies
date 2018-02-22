package io.github.slupik.popularmovies.dagger.view;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Sebastian Witasik on 21.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module
public class ContextModule {
    private Context mContext;

    public ContextModule(Context context) {
        mContext = context.getApplicationContext();
    }

    @Provides
    Context getContext() {
        return mContext;
    }
}
