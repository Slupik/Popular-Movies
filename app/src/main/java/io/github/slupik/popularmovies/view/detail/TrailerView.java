package io.github.slupik.popularmovies.view.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.data.downloader.YouTubeUrl;
import io.github.slupik.popularmovies.ApplicationUtils;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.models.trailer.Trailer;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class TrailerView {
    private View mView;
    private Trailer mTrailer;

    @BindView(R.id.iv_trailer_image)
    ImageView image;

    @BindView(R.id.iv_trailer_play)
    ImageView ivPlay;

    @BindView(R.id.iv_trailer_share)
    ImageView ivShare;

    TrailerView(Trailer trailer, Context context) {
        inflateThis(context);
        ButterKnife.bind(this, mView);
        mTrailer = trailer;
        populateData(context);

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityForThisTrailer();
            }
        });

        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLinkToTrailer(v.getContext());
            }
        });
    }

    private void shareLinkToTrailer(Context context) {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, ApplicationUtils.getApplicationName(context));
            i.putExtra(Intent.EXTRA_TEXT, getTrailerUrl());
            context.startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void inflateThis(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.trailer_item, null, false);
    }

    private void openActivityForThisTrailer() {
        mView.getContext().startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(getTrailerUrl())
                        ));
    }

    private String getTrailerUrl() {
        return YouTubeUrl.FILM_BASE+mTrailer.getKey();
    }

    private void populateData(Context context) {
        Picasso.with(context).load(getVideoThumbnail()).into(image);
    }

    public View getView() {
        return mView;
    }

    private String getVideoThumbnail() {
        return String.format(YouTubeUrl.FILM_THUMBNAIL, mTrailer.getKey());
    }
}
