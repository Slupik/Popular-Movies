package io.github.slupik.popularmovies.view.main.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    private static final String PATH = "t/p/";
    private static final String IMAGE_SIZE = TheMovieDbUtils.PosterSizes.W_342.CODE;

    @BindView(R.id.iv_film_list_item)
    ImageView ivPoster;

    @BindView(R.id.tv_holder_id)
    TextView title;

    ViewHolderFilm(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(final Context context, final Film film) {
        ivPoster.post(new Runnable() {
            @Override
            public void run() {
                title.setText(film.getTitle());
                if(ivPoster.getWidth()>0) {
                    Picasso
                            .with(context)
                            .load(getImageUrl(film))
                            .resize(ivPoster.getWidth(), 0)
//                        .fit().centerCrop()
                            .into(ivPoster);
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ivPoster.post(new Runnable() {
                                @Override
                                public void run() {
                                    Picasso
                                            .with(context)
                                            .load(getImageUrl(film))
                                            .resize(ivPoster.getWidth(), 0)
//                        .fit().centerCrop()
                                            .into(ivPoster);
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }

    private String getImageUrl(Film film) {
        String url = IMAGE_BASE_URL;
        url += PATH;
        url += IMAGE_SIZE;
        url += film.getPosterPath();
        return url;
    }

    void showDownLoader() {

    }
}
