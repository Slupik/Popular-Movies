package io.github.slupik.popularmovies.view.utils;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public abstract class LoadableRecyclerView<H extends RecyclerView.ViewHolder, V> extends RecyclerView.Adapter<H> {

    protected Context mContext;

    private List<V> itemList = new ArrayList<>();
    private boolean downloading = false;
    private RecyclerView recyclerView;

    @CallSuper
    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null) {
            mContext = parent.getContext();
        }
        return buildViewHolder(parent, viewType);
    }

    protected abstract H buildViewHolder(ViewGroup parent, int viewType);

    @CallSuper
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
        loadMoreData();
    }

    @CallSuper
    @Override
    public void onBindViewHolder(H holder, int position) {
        if (itemList.size() > position) {
            bindHolder(holder, itemList.get(position));
        }
        if((itemList.size()-getHowManyItemsToDownload())<position){
            loadMoreData();
        }
    }

    protected abstract void bindHolder(H holder, V value);

    protected abstract int getHowManyItemsToDownload();

    private void loadMoreData() {
        synchronized (this) {
            if(downloading) {
                return;
            }
            downloading = true;
        }
        downloadMoreData();
    }

    protected abstract void downloadMoreData();

    public void addItems(final List<V> list) {
        addItems(list, mContext);
    }

    public void addItems(final List<V> list, Context context) {
        itemList.addAll(list);
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
        return itemList.size();
    }

    public void clearList() {
        itemList.clear();
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
}
