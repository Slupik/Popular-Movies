package io.github.slupik.popularmovies.dagger.view.detail;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.database.movies.MovieRepository;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.domain.film.database.FilmRepository;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module(includes = {ContextModule.class})
class FilmRepositoryModule {
    @Provides
    FilmRepository filmRepository(Context context){
        return new MovieRepository(context);
    }
}
