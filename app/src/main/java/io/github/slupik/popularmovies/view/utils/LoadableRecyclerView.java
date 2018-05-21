package io.github.slupik.popularmovies.view.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.github.slupik.popularmovies.dagger.view.utils.DaggerLoadableRecyclerViewComponent;
import io.github.slupik.popularmovies.domain.models.ParcelableModel;

/**
 * Created by Sebastian Witasik on 04.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public abstract class LoadableRecyclerView<H extends RecyclerView.ViewHolder, V extends ParcelableModel>
        extends RecyclerView.Adapter<H>
        implements Restoreable {

    protected Context mContext;

    private Gson gson;

    private List<V> itemList = new ArrayList<>();
    private boolean downloading = false;
    private RecyclerView recyclerView;

    protected LoadableRecyclerView(){
        gson = DaggerLoadableRecyclerViewComponent.builder().build().getGson();
    }

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
                final Parcelable parcel = recyclerView.getLayoutManager().onSaveInstanceState();
                notifyDataSetChanged();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.getLayoutManager().onRestoreInstanceState(parcel);
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

    /*
            SAVE AND RESTORE
     */

    private static final String ITEM_LIST_NAME = "itemList";
    private static final String LIST_STATE_KEY = "listStateKey";
    @Override
    public Bundle onSave(){
        Bundle bundle = new Bundle();
        bundle.putString(ITEM_LIST_NAME, gson.toJson(itemList));
        bundle.putParcelable(LIST_STATE_KEY, recyclerView.getLayoutManager().onSaveInstanceState());
        return bundle;
    }

    @Override
    public void onRestore(Bundle bundle){
        List<V> list = gson.fromJson(
                bundle.getString(ITEM_LIST_NAME), getItemType()
        );
        itemList.clear();
        itemList.addAll(list);

        Parcelable parcel = bundle.getParcelable(LIST_STATE_KEY);
        recyclerView.getLayoutManager().onRestoreInstanceState(parcel);
    }

    protected abstract Type getItemType();
}
