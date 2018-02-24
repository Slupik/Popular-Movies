package io.github.slupik.popularmovies.view.main.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.data.dagger.film.downloader.GsonModule;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.themovie.TheMovieDbUtils;

import static io.github.slupik.data.film.FilmConnectionUtils.IMAGE_BASE_URL;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class ViewHolderFilm extends RecyclerView.ViewHolder {

    private static final String IMAGE_SIZE = TheMovieDbUtils.PosterSizes.W_185.CODE;
    private static final int TIME_INTERVAL = 100;
    private static final int MAX_WAITING_TIME_FOR_POSTER = TIME_INTERVAL*20;

    private Film actualFilm;

    @BindView(R.id.iv_film_list_item)
    ImageView ivPoster;

    @BindView(R.id.tv_holder_title)
    TextView title;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    ViewHolderFilm(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void onRemoveFromList() {
        pbLoading.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
    }

    void bind(final Context context, final Film film) {
        actualFilm = film;
        ivPoster.post(new Runnable() {
            @Override
            public void run() {
                ivPoster.setContentDescription(film.getTitle());
                title.setText(film.getTitle());
                if(ivPoster.getWidth()>0) {
                    setPosterHeight();
                    loadPosterWithPicasso(context, film);
                } else {
                    forceLoadPoster(context, film);
                }
            }
        });
    }

    private void forceLoadPoster(final Context context, final Film film) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitUntilLoad();
                setPosterHeight();
                ivPoster.post(new Runnable() {
                    @Override
                    public void run() {
                        loadPosterWithPicasso(context, film);
                    }
                });
            }

            private void waitUntilLoad() {
                int totalTime = 0;
                while(ivPoster.getWidth()==0 && MAX_WAITING_TIME_FOR_POSTER>totalTime){
                    try {
                        Thread.sleep(TIME_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    totalTime += TIME_INTERVAL;
                }
            }
        }).start();
    }

    private void loadPosterWithPicasso(Context context, Film film) {
        Picasso
                .with(context)
                .load(getImageUrl(film))
                .resize(ivPoster.getWidth(), (int)(ivPoster.getWidth()*1.5))
                .into(ivPoster, new Callback() {
                    @Override
                    public void onSuccess() {
                        pbLoading.setVisibility(View.GONE);
                        title.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError() {

                    }
                });
    }

    private String getImageUrl(Film film) {
        String url = IMAGE_BASE_URL;
        url += IMAGE_SIZE;
        url += film.getPosterPath();
        return url;
    }

    private void setPosterHeight() {
        ivPoster.post(new Runnable() {
            @Override
            public void run() {
                ivPoster.setMinimumHeight(getHeightOfPoster(ivPoster.getWidth()));
            }
        });
    }

    private static final double RATIO_FOR_POSTER_HEIGHT = 1.5;
    private int getHeightOfPoster(int width) {
        return (int) (width*RATIO_FOR_POSTER_HEIGHT);
    }

    String getActualFilmAsString() {
        Gson converter = new GsonModule().gson();
        return converter.toJson(actualFilm);
    }
}
