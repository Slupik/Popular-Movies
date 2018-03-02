package io.github.slupik.popularmovies.view.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.dagger.view.detail.DaggerDetailPresentedViewComponent;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.downloader.themovie.TheMovieDbUtils;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

import static io.github.slupik.data.downloader.FilmConnectionUtils.IMAGE_BASE_URL;

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

    @BindView(R.id.tv_trailers_label)
    TextView tvTrailersLbl;

    @BindView(R.id.ll_trailer_list)
    LinearLayout llTrailerList;

    @Inject
    DetailPresenter presenter;

    //TODO 3 add section for reviews (/movie/{id}/reviews)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        DaggerDetailPresentedViewComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build().inject(this);

        presenter.onAttach(this);
        presenter.processIntent(getIntent());

        fbtnFavourite.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     presenter.onFavouriteAction(v);
                 }
             }
        );
    }

    @Override
    @SuppressLint("SetTextI18n")
    public void populateFields(final Film film) {
        Picasso.
                with(getApplicationContext())
                .load(getImageUrl(film))
                .into(image);
        overview.setText(film.getOverview());
        title.setText(film.getTitle());
        releaseDate.setText(film.getReleaseDate());
        userRating.setText(Double.toString(film.getVoteAverage()));
    }

    @Override
    public void addTrailerView(View view) {
        llTrailerList.addView(view);
    }

    private String getImageUrl(Film film) {
        String url = IMAGE_BASE_URL;
        url += IMAGE_SIZE;
        url += film.getBackdropPath();
        return url;
    }

    @Override
    public void makeViewAsFavourite(boolean isFavourite) {
        if(isFavourite) {
            fbtnFavourite.setImageResource(R.drawable.favourite_star_is);
        } else {
            fbtnFavourite.setImageResource(R.drawable.favourite_star_not);
        }
    }
}
