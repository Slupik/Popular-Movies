package io.github.slupik.data.downloader.list.trailer;

import io.github.slupik.data.downloader.list.BaseRetrofitDownloader;
import io.github.slupik.data.models.trailer.TrailerListBean;
import io.github.slupik.popularmovies.domain.downloader.list.trailer.TrailerListDownloader;
import retrofit2.Call;

/**
 * Created by Sebastian Witasik on 17.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class TrailersRetrofitDownloader extends BaseRetrofitDownloader implements TrailerListDownloader<TrailerListDownloader.Data> {

    @Override
    public void downloadTrailers(Callback callback, TrailerListDownloader.Data data) {
        Call<TrailerListBean> call = getDownloader().getTrailers(
                data.getMovieId(),
                data.getApiKey(),
                data.getLanguage());
        call.enqueue(new TrailersRetrofitCallback(callback));
    }
}
