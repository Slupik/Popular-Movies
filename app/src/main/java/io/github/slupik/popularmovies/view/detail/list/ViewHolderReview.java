package io.github.slupik.popularmovies.view.detail.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.models.review.Review;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class ViewHolderReview extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_review_author)
    TextView tvAuthor;
    @BindView(R.id.tv_review_content)
    TextView tvContent;

    private Review mReview;

    ViewHolderReview(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public String getActualReviewUrl() {
        return mReview.getUrl();
    }

    public void bind(Review review) {
        mReview = review;
        tvAuthor.setText(review.getAuthor());
        tvContent.setText(review.getContent());
    }
}
