package io.github.slupik.popularmovies.view.detail.reviews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.models.review.Review;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: SebastianWitasik@gmail.com
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
        setClickListener(itemView);
    }

    private void setClickListener(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityForReview(v.getContext(), getActualReviewUrl());
            }
        });
    }

    private void openActivityForReview(Context context, String url) {
        context.startActivity(
                new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                ));
    }

    private String getActualReviewUrl() {
        return mReview.getUrl();
    }

    void bind(Review review) {
        mReview = review;
        tvAuthor.setText(review.getAuthor());
        tvContent.setText(review.getContent());
    }
}
