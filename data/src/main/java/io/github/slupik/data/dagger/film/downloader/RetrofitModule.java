package io.github.slupik.data.dagger.film.downloader;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.downloader.list.RetrofitDownloader;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static io.github.slupik.data.downloader.FilmConnectionUtils.API_BASE_URL;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */
@Module(includes = {GsonModule.class})
class RetrofitModule {

    @Provides
    Retrofit retrofit(Gson gson){
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    RetrofitDownloader downloader(Retrofit retrofit) {
        return retrofit.create(RetrofitDownloader.class);
    }
}
