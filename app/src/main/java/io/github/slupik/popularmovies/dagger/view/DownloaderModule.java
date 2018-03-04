package io.github.slupik.popularmovies.dagger.view;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.github.slupik.data.downloader.list.film.FilmListRetrofitDownloader;
import io.github.slupik.data.downloader.list.film.RetrofitDownloadDataList;
import io.github.slupik.data.downloader.list.review.RetrofitDownloadDataReviews;
import io.github.slupik.data.downloader.list.review.ReviewsRetrofitDownloader;
import io.github.slupik.data.downloader.list.trailer.RetrofitDownloadDataTrailers;
import io.github.slupik.data.downloader.list.trailer.TrailersRetrofitDownloader;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.downloader.list.film.FilmListDownloader;
import io.github.slupik.popularmovies.domain.downloader.list.review.ReviewListDownloader;
import io.github.slupik.popularmovies.domain.downloader.list.trailer.TrailerListDownloader;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
@Module(includes = ContextModule.class)
public class DownloaderModule {

    @Provides
    FilmListDownloader getListDownloader(){
        return new FilmListRetrofitDownloader();
    }

    @Provides
    FilmListDownloader.Data filmsData(Context context){
        RetrofitDownloadDataList data = new RetrofitDownloadDataList();
        String apiKey = getApiKey(context);
        data.setApiKey(apiKey);
        return data;
    }

    @Provides
    TrailersRetrofitDownloader getTrailerDownloader(){
        return new TrailersRetrofitDownloader();
    }

    @Provides
    TrailerListDownloader.Data trailersData(Context context){
        RetrofitDownloadDataTrailers data = new RetrofitDownloadDataTrailers();
        String apiKey = getApiKey(context);
        data.setApiKey(apiKey);
        return data;
    }

    @Provides
    ReviewsRetrofitDownloader getReviewsDownloader(){
        return new ReviewsRetrofitDownloader();
    }

    @Provides
    ReviewListDownloader.Data reviewsData(Context context){
        RetrofitDownloadDataReviews data = new RetrofitDownloadDataReviews();
        String apiKey = getApiKey(context);
        data.setApiKey(apiKey);
        return data;
    }

    private String getApiKey(Context context){
        return context.getString(R.string.key_themoviedb);
    }
}
