package io.github.slupik.popularmovies.view.main;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.data.gson.film.FilmDeserializer;
import io.github.slupik.data.models.film.FilmListBean;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.utils.Randomizer;
import io.github.slupik.popularmovies.view.main.list.RecycleViewFilmList;
import io.github.slupik.popularmovies.view.mvp.presenter.BasePresenter;

/**
 * Created by Sebastian Witasik on 22.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

class FakePresenterForUXTest extends BasePresenter<MainPresentedView> implements MainPresenter {

    private static final int AMOUNT_OF_BASIC_DATA = 10;
    private static final int SLEEP_TIME = 5000;

    private RecycleViewFilmList rvList;
    private FakeDownloading downloader = new FakeDownloading();

    private FakePresenterForUXTest(Context context) {
        super(context);
    }

    static RecycleViewFilmList initRecycleView(Context context){
        FakePresenterForUXTest fake = new FakePresenterForUXTest(context);
        RecycleViewFilmList mAdapter = new RecycleViewFilmList(fake);
        fake.setRvList(mAdapter);
        fake.insertInitData();
        return mAdapter;
    }

    @Override
    public void downloadMoreData() {
        downloader.start();
    }

    @Override
    public void onMenuCreate() {

    }

    private void insertInitData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Film.class, new FilmDeserializer())
                        .setLenient()
                        .create();
                FilmListBean list = gson.fromJson(PLAIN_JSON, FilmListBean.class);
                rvList.addFilms(list.getList(), context);
            }
        }).start();
    }

    @Override
    @Deprecated
    public void switchFilmsType(FilmsType type) {

    }

    private class FakeDownloading implements Runnable {

        void start() {
            new Thread(this).start();
        }

        @Override
        @Deprecated
        public void run() {
            sleep(SLEEP_TIME);
            List<Film> completedList = new ArrayList<>();
            for(int i=0;i<AMOUNT_OF_BASIC_DATA;i++) {
                completedList.addAll(getSingleFilmList());
            }
            rvList.addFilms(completedList);
        }

        private int lastId = 0;
        private List<Film> getSingleFilmList(){
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Film.class, new FilmDeserializer())
                    .setLenient()
                    .create();
            FilmListBean list = gson.fromJson(PLAIN_JSON, FilmListBean.class);
            for(Film bean:list.getList()) {
                bean.setTitle(bean.getTitle()+ Randomizer.randomStandardString(10));
                bean.setTitle(Integer.toString(lastId++));
            }
            return list.getList();
        }

        private void sleep(int waitTime) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private FakePresenterForUXTest setRvList(RecycleViewFilmList rvList) {
        this.rvList = rvList;
        return this;
    }

    private static final String PLAIN_JSON = "{\n" +
            "  \"page\": 1,\n" +
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
            "      \"original_title\": \"Suicide Squad\",\n" +
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
            "      \"original_title\": \"Jason Bourne\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"title\": \"Jason Bourne\",\n" +
            "      \"backdrop_path\": \"/AoT2YrJUJlg5vKE3iMOLvHlTd3m.jpg\",\n" +
            "      \"popularity\": 30.690177,\n" +
            "      \"vote_count\": 649,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.25\n" +
            "    }\n" +
            "  ],\n" +
            "  \"total_results\": 19629,\n" +
            "  \"total_pages\": 982\n" +
            "}";
}
