package io.github.slupik.popularmovies.view.main.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.view.main.MainPresenter;
import io.github.slupik.popularmovies.view.utils.LoadableRecyclerView;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class RecycleViewFilmList extends LoadableRecyclerView<ViewHolderFilm, Film> {
    public static final int NUMBER_OF_FILMS_IN_ROW = 2;
    public static final int NUMBER_OF_FILMS_BEFORE_DOWNLOAD = 6*NUMBER_OF_FILMS_IN_ROW;
    private static final boolean SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT = false;

    private final MainPresenter mPresenter;

    public RecycleViewFilmList(MainPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    protected ViewHolderFilm buildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.film_list_item, parent, SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT);
        return new ViewHolderFilm(view);
    }

    @Override
    protected int getHowManyItemsToDownload() {
        return NUMBER_OF_FILMS_BEFORE_DOWNLOAD;
    }

    @Override
    public void onViewRecycled(ViewHolderFilm holder) {
        super.onViewRecycled(holder);
        holder.onRemoveFromList();
    }

    @Override
    protected void bindHolder(ViewHolderFilm holder, Film value) {
        holder.bind(mContext, value);
    }

    @Override
    protected void downloadMoreData() {
        mPresenter.downloadMoreData();
    }
}
