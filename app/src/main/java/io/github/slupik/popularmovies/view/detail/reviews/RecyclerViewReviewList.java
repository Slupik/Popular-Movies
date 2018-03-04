package io.github.slupik.popularmovies.view.detail.reviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.models.review.Review;
import io.github.slupik.popularmovies.view.detail.DetailPresenter;
import io.github.slupik.popularmovies.view.utils.LoadableRecyclerView;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class RecyclerViewReviewList extends LoadableRecyclerView<ViewHolderReview, Review> {
    public static final int NUMBER_OF_REVIEWS_BEFORE_DOWNLOAD = 10;
    private static final boolean SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT = false;

    private final DetailPresenter mPresenter;

    public RecyclerViewReviewList(DetailPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    protected ViewHolderReview buildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.review_item, parent, SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT);
        return new ViewHolderReview(view);
    }

    @Override
    protected void bindHolder(ViewHolderReview holder, Review value) {
        holder.bind(value);
    }

    @Override
    protected int getHowManyItemsToDownload() {
        return NUMBER_OF_REVIEWS_BEFORE_DOWNLOAD;
    }

    @Override
    protected void downloadMoreData() {
        mPresenter.downloadMoreReviews(Integer.toString(mPresenter.getFilm().getOnlineId()));
    }
}
