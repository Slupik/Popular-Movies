package io.github.slupik.popularmovies.view.main.list;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.view.main.MainPresenter;

/**
 * Created by Sebastian Witasik on 20.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class RecycleViewFilmList extends RecyclerView.Adapter<ViewHolderFilm> {
    public static final int NUMBER_OF_FILMS_IN_ROW = 2;
    public static final int NUMBER_OF_FILMS_BEFORE_DOWNLOAD = 6*NUMBER_OF_FILMS_IN_ROW;
    private static final boolean SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT = false;

    private final MainPresenter mPresenter;
    private List<Film> filmList = new ArrayList<>();
    private Context mContext;
    private boolean downloading = false;
    private RecyclerView recyclerView;

    public RecycleViewFilmList(MainPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public ViewHolderFilm onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.film_list_item, parent, SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
            }
        });
        return new ViewHolderFilm(view);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onBindViewHolder(ViewHolderFilm holder, int position) {
        if(filmList.size()>position){
            holder.bind(mContext, filmList.get(position));
        }
        if((filmList.size()-NUMBER_OF_FILMS_BEFORE_DOWNLOAD)<position){
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
        //In future to uncomment
        mPresenter.downloadMoreData();
    }

    public void addFilms(final List<Film> list) {
        addFilms(list, mContext);
    }

    public void addFilms(final List<Film> list, Context context) {
        filmList.addAll(list);
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

    public void clearList() {
        filmList.clear();
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
}
