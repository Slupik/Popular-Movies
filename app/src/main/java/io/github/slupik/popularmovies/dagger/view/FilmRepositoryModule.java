package io.github.slupik.popularmovies.dagger.view;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.database.movies.MovieRepository;
import io.github.slupik.popularmovies.domain.models.repository.FilmRepository;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

@Module(includes = {ContextModule.class})
public class FilmRepositoryModule {
    @Provides
    public FilmRepository filmRepository(Context context){
        return new MovieRepository(context);
    }
}
