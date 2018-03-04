package io.github.slupik.popularmovies.view.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.downloader.themovie.TheMovieDbUtils;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.models.review.ReviewList;
import io.github.slupik.popularmovies.view.detail.reviews.RecyclerViewReviewList;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

import static io.github.slupik.data.downloader.FilmConnectionUtils.IMAGE_BASE_URL;

public class DetailActivity extends BaseActivity implements DetailPresentedView {

    private static final boolean TEST_UX = false;

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

    @BindView(R.id.tv_reviews_label)
    TextView tvReviewsLbl;

    @BindView(R.id.ll_trailer_list)
    LinearLayout llTrailerList;

    @BindView(R.id.rv_reviews_list)
    RecyclerView rvReviewList;

    @Inject
    DetailPresenter presenter;

    private RecyclerViewReviewList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);

        presenter.onAttach(this);
        presenter.processIntent(getIntent());

        fbtnFavourite.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     presenter.onFavouriteAction(v);
                 }
             }
        );
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mAdapter = createReviewList();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvReviewList.setLayoutManager(manager);
        rvReviewList.setHasFixedSize(true);
        rvReviewList.setAdapter(mAdapter);
    }

    private RecyclerViewReviewList createReviewList() {
        RecyclerViewReviewList mAdapter;
        if(TEST_UX) {
            mAdapter = FakePresenterForUXTest.initRecycleView(this.getApplicationContext());
        } else {
            mAdapter = new RecyclerViewReviewList(presenter);
        }

        if(mAdapter.getContext()==null) {
            mAdapter.setContext(this);
        }
        return mAdapter;
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

    @Override
    public void addReviews(ReviewList data) {
        mAdapter.addItems(data.getList(), this);
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
