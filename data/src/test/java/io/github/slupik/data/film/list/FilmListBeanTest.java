package io.github.slupik.data.film.list;

import com.google.gson.Gson;

import junit.framework.Assert;

import org.junit.Test;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.dagger.film.downloader.FilmRetrofitDownloaderComponent;
import io.github.slupik.popularmovies.domain.film.list.FilmList;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
public class FilmListBeanTest {
    private static final int PAGE = 1;
    private static final int TOTAL_RESULTS = 19629;
    private static final int TOTAL_PAGES = 982;

    private static final String FILM_0_TITLE = "Suicide Squad";
    private static final String FILM_1_TITLE = "Jason Bourne";

    @Test
    public void testGson(){
        Gson gson = getGsonForRetrofit();
        FilmList list = gson.fromJson(PLAIN_JSON, FilmListBean.class);

        Assert.assertTrue(list.getList().size()>0);
        Assert.assertEquals(PAGE, list.getPage());
        Assert.assertEquals(TOTAL_PAGES, list.getTotalPages());
        Assert.assertEquals(TOTAL_RESULTS, list.getTotalResults());

        Assert.assertEquals(FILM_0_TITLE, list.getList().get(0).getTitle());
        Assert.assertEquals(FILM_1_TITLE, list.getList().get(1).getTitle());
    }

    private static final String PLAIN_JSON = "{\n" +
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

    private Gson getGsonForRetrofit() {
        FilmRetrofitDownloaderComponent downloader = DaggerFilmRetrofitDownloaderComponent.builder()
                .build();
        return downloader.getGson();
    }
}