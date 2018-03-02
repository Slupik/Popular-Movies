package io.github.slupik.popularmovies.view.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.data.film.FilmBean;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.dagger.view.detail.DaggerDetailPresentedViewComponent;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.SavedFilm;
import io.github.slupik.popularmovies.domain.film.database.FilmRepository;
import io.github.slupik.popularmovies.domain.film.downloader.themovie.TheMovieDbUtils;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

import static io.github.slupik.data.film.FilmConnectionUtils.IMAGE_BASE_URL;

public class DetailActivity extends BaseActivity implements DetailPresentedView {

    public static final String BUNDLE_NAME_WITH_MOVIE_DATA = "movie_data";
    private static final String IMAGE_SIZE = TheMovieDbUtils.BackdropSizes.W_1280.CODE;

    @BindView(R.id.iv_backdrop)
    ImageView image;

    @BindView(R.id.tv_overview)
    TextView overview;

    @BindView(R.id.tv_user_rating)
    TextView userRating;

    @BindView(R.id.tv_release_date)
    TextView releaseDate;

    @BindView(R.id.tv_title)
    TextView title;

    @BindView(R.id.fab_favourite)
    FloatingActionButton fbtnFavourite;

    @Inject
    FilmRepository repository;

    @Inject
    Gson jsonConverter;

    private boolean isFavourite = false;

    //TODO 2 apply MVP
    //TODO 3 add section for reviews (/movie/{id}/reviews)
    //TODO 4 add section for films (/movie/{id}/videos)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        DaggerDetailPresentedViewComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build().inject(this);

        final Film film = getInitData();
        populateFields(film);

        fbtnFavourite.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(isFavourite) {
                         SavedFilm savedFilm = repository.getFilm(film);
                         if(savedFilm!=null) {
                             repository.deleteFilm(savedFilm);
                         }
                         makeViewAsFavourite(false);
                     } else {
                         repository.addFilm(film);
                         makeViewAsFavourite(true);
                     }
                 }
             }
        );
    }

    private Film getInitData() {
        Intent intent = getIntent();
        String json = intent.getStringExtra(BUNDLE_NAME_WITH_MOVIE_DATA);
        return jsonConverter.fromJson(json, FilmBean.class);
    }

    @SuppressLint("SetTextI18n")
    private void populateFields(final Film film) {
        Picasso.
                with(getApplicationContext())
                .load(getImageUrl(film))
                .into(image);
        overview.setText(film.getOverview());
        title.setText(film.getTitle());
        releaseDate.setText(film.getReleaseDate());
        userRating.setText(Double.toString(film.getVoteAverage()));
        makeViewAsFavourite(isFavouriteFilm(film));
    }

    private boolean isFavouriteFilm(Film film) {
        return repository.isFavourite(film);
    }

    private void makeViewAsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
        if(isFavourite) {
            fbtnFavourite.setImageResource(R.drawable.favourite_star_is);
        } else {
            fbtnFavourite.setImageResource(R.drawable.favourite_star_not);
        }
    }

    private String getImageUrl(Film film) {
        String url = IMAGE_BASE_URL;
        url += IMAGE_SIZE;
        url += film.getBackdropPath();
        return url;
    }
}
