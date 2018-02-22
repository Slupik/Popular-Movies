package io.github.slupik.popularmovies.view.main.list;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import io.github.slupik.data.film.gson.FilmDeserializer;
import io.github.slupik.data.film.list.FilmListBean;
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
    public static final int NUMBER_OF_FILMS_BEFORE_DOWNLOAD = 4*NUMBER_OF_FILMS_IN_ROW;
    private static final boolean SHOULD_ATTACH_TO_PARENT_PERMANENTLY_DEFAULT = false;

    private final MainPresenter mPresenter;
    private List<Film> filmList = new ArrayList<>();
    private Context mContext;
    private boolean downloading = false;

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

    Parcelable recylerViewState;
    RecyclerView recyclerView;
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recylerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
        this.recyclerView = recyclerView;
    }

    private boolean onlyOnce = true;
    @Override
    public void onBindViewHolder(ViewHolderFilm holder, int position) {
        //TODO remove fake fill with position
//        position = position%2;
        System.out.println("SIZE filmList.size() = " + filmList.size());
        if(filmList.size()>position){
            holder.bind(mContext, filmList.get(position));
        }
        System.out.println("filmList = " + filmList.size());
        System.out.println("position = " + position);
        //TODO make add data when scrolling
        if(filmList.size()-2<position || onlyOnce){

            //TODO make load more data if position is smaller than size but not too small (UX is most important)
            holder.showDownLoader();
            loadMoreData();
            onlyOnce = false;
        }
    }

    private int lastId = 0;

    public void loadMoreData() {
        synchronized (this) {
            if(downloading) {
                return;
            }
            downloading = true;
        }
        //In future to uncomment
//        mPresenter.downloadMoreData();

        //TODO implement downloading data
        //FAKE DATA
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                try {
                    //TODO aktualnie wpływa to również na wątek główny - do poprawy
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("RVFilmList", "End sleep");
                List<Film> list = getMockedFilms().getList();
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
                list.addAll(getMockedFilms().getList());
//              list.addAll(getMockedFilms().getList());
//              list.addAll(getMockedFilms().getList());
                System.out.println("list.size() = " + list.size());
                Log.d("RVFilmList", "Before ADD");
                addFilms(list);
                Log.d("RVFilmList", "After ADD");
            }
        }).start();
///////////////////////////////////////////////
    }
    private FilmListBean getMockedFilms() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Film.class, new FilmDeserializer())
                .setLenient()
                .create();
        FilmListBean list = gson.fromJson(PLAIN_JSON, FilmListBean.class);
        for(Film bean:list.getList()) {
            bean.setTitle(bean.getTitle()+randomString(10));
            bean.setTitle(Integer.toString(lastId++));
        }
        return list;
    }
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();
    private static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public void addFilms(final List<Film> list) {
        filmList.addAll(list);
        final Handler handler = new Handler(mContext.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        final int x = recyclerView.getScrollX();
                        final int y = recyclerView.getScrollY();
//                        recylerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
                        notifyDataSetChanged();
//                        recyclerView.getLayoutManager().onRestoreInstanceState(recylerViewState);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.scrollTo(x, y);
//                                recyclerView.setScrollX(x);
//                                recyclerView.setScrollY(y);
                                downloading = false;
                            }
                        }, 100);
                    }
                });
            }
        }).start();
    }

    public void addFilmsSync(final List<Film> list) {
        filmList.addAll(list);
        downloading = false;
    }

    public void flushFilms() {
        filmList.clear();
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    private static final int PAGE = 1;
    private static final int TOTAL_RESULTS = 19629;
    private static final int TOTAL_PAGES = 982;

    private static final String FILM_0_TITLE = "Suicide Squad";
    private static final String FILM_1_TITLE = "Jason Bourne";
    public static final String PLAIN_JSON = "{\n" +
            "  \"page\": "+PAGE+",\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"poster_path\": \"/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.\",\n" +
            "      \"release_date\": \"2016-08-03\",\n" +
            "      \"genre_ids\": [\n" +
            "        14,\n" +
            "        28,\n" +
            "        80\n" +
            "      ],\n" +
            "      \"id\": 297761,\n" +
            "      \"original_title\": \""+ FILM_0_TITLE +"\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"title\": \"Suicide Squad\",\n" +
            "      \"backdrop_path\": \"/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg\",\n" +
            "      \"popularity\": 48.261451,\n" +
            "      \"vote_count\": 1466,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.91\n" +
            "    },\n" +
            "    {\n" +
            "      \"poster_path\": \"/lFSSLTlFozwpaGlO31OoUeirBgQ.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"The most dangerous former operative of the CIA is drawn out of hiding to uncover hidden truths about his past.\",\n" +
            "      \"release_date\": \"2016-07-27\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"id\": 324668,\n" +
            "      \"original_title\": \""+ FILM_1_TITLE +"\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"title\": \"Jason Bourne\",\n" +
            "      \"backdrop_path\": \"/AoT2YrJUJlg5vKE3iMOLvHlTd3m.jpg\",\n" +
            "      \"popularity\": 30.690177,\n" +
            "      \"vote_count\": 649,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.25\n" +
            "    }\n" +
            "  ],\n" +
            "  \"total_results\": "+TOTAL_RESULTS+",\n" +
            "  \"total_pages\": "+TOTAL_PAGES+"\n" +
            "}";
}
