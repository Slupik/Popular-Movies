package io.github.slupik.popularmovies.view.detail.list;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.models.review.Review;
import io.github.slupik.popularmovies.view.detail.DetailActivity;
import io.github.slupik.popularmovies.view.detail.DetailPresenter;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class RecyclerViewReviewList extends RecyclerView.Adapter<ViewHolderReview> {
    public static final int NUMBER_OF_REVIEWS_BEFORE_DOWNLOAD = 10;
    private static final boolean SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT = false;

    private final DetailPresenter mPresenter;
    private Context mContext;
    private List<Review> reviewList = new ArrayList<>();
    private boolean downloading = false;
    private RecyclerView recyclerView;
    private DetailActivity context;

    public RecyclerViewReviewList(DetailPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
        loadMoreData();
    }

    @Override
    public ViewHolderReview onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null) {
            mContext = parent.getContext();
        }
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.review_item, parent, SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT);
        final ViewHolderReview holder = new ViewHolderReview(view);

        //TODO add share option
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityForReview(holder.getActualReviewUrl());
            }
        });
        return holder;
    }

    private void openActivityForReview(String url) {
        mContext.startActivity(
                new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                ));
    }

    @Override
    public void onBindViewHolder(ViewHolderReview holder, int position) {
        if(reviewList.size()>position){
            holder.bind(reviewList.get(position));
        }
        if((reviewList.size()-NUMBER_OF_REVIEWS_BEFORE_DOWNLOAD)<position){
            loadMoreData();
        }
    }

    public void loadMoreData() {
        synchronized (this) {
            if(downloading) {
                return;
            }
            downloading = true;
        }
        mPresenter.downloadMoreReviews(Integer.toString(mPresenter.getFilm().getOnlineId()));
    }

    //TODO move this data to root of recycler view with loadable data
    public void addReviews(final List<Review> list) {
        addReviews(list, mContext);
    }

    public void addReviews(final List<Review> list, Context context) {
        reviewList.addAll(list);
        final Handler handler = new Handler(context.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                final int x = recyclerView.getScrollX();
                final int y = recyclerView.getScrollY();
                notifyDataSetChanged();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.scrollTo(x, y);
                        downloading = false;
                    }
                }, 100);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(DetailActivity context) {
        this.context = context;
    }
}
