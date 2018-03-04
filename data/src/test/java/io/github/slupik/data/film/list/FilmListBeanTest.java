package io.github.slupik.data.film.list;

import com.google.gson.Gson;

import junit.framework.Assert;

import org.junit.Test;

import io.github.slupik.data.dagger.film.downloader.DaggerFilmRetrofitDownloaderComponent;
import io.github.slupik.data.dagger.film.downloader.FilmRetrofitDownloaderComponent;
import io.github.slupik.data.models.film.FilmListBean;
import io.github.slupik.popularmovies.domain.models.film.FilmList;

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

    @Test
    public void testNewGson(){
        Gson gson = getGsonForRetrofit();
        FilmList list = gson.fromJson(NEW_PLAIN_JSON, FilmListBean.class);
        Assert.assertEquals(20, list.getList().size());
    }

    private Gson getGsonForRetrofit() {
        FilmRetrofitDownloaderComponent downloader = DaggerFilmRetrofitDownloaderComponent.builder()
                .build();
        return downloader.getGson();
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

    private static final String NEW_PLAIN_JSON = "{\n" +
            "  \"page\": 1,\n" +
            "  \"total_results\": 19330,\n" +
            "  \"total_pages\": 967,\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"vote_count\": 5802,\n" +
            "      \"id\": 211672,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.4,\n" +
            "      \"title\": \"Minions\",\n" +
            "      \"popularity\": 294.455777,\n" +
            "      \"poster_path\": \"/q0R4crx2SehcEEQEkYObktdeFy.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Minions\",\n" +
            "      \"genre_ids\": [\n" +
            "        10751,\n" +
            "        16,\n" +
            "        12,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/qLmdjn2fv0FV2Mh4NBzMArdA0Uu.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.\",\n" +
            "      \"release_date\": \"2015-06-17\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 7007,\n" +
            "      \"id\": 198663,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"title\": \"The Maze Runner\",\n" +
            "      \"popularity\": 283.794957,\n" +
            "      \"poster_path\": \"/coss7RgL0NH6g4fC2s5atvf3dFO.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Maze Runner\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        9648,\n" +
            "        878,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/lkOZcsXcOLZYeJ2YxJd3vSldvU4.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow “runners” for a shot at escape.\",\n" +
            "      \"release_date\": \"2014-09-10\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 7284,\n" +
            "      \"id\": 321612,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.8,\n" +
            "      \"title\": \"Beauty and the Beast\",\n" +
            "      \"popularity\": 218.924299,\n" +
            "      \"poster_path\": \"/tWqifoYuwLETmmasnGHO7xBjEtt.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Beauty and the Beast\",\n" +
            "      \"genre_ids\": [\n" +
            "        10751,\n" +
            "        14,\n" +
            "        10749\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/6aUWe0GSl69wMTSWWexsorMIvwU.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"A live-action adaptation of Disney's version of the classic tale of a cursed prince and a beautiful young woman who helps him break the spell.\",\n" +
            "      \"release_date\": \"2017-03-16\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 6826,\n" +
            "      \"id\": 245891,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"title\": \"John Wick\",\n" +
            "      \"popularity\": 176.515824,\n" +
            "      \"poster_path\": \"/5vHssUeVe25bMrof1HyaPyWgaP.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"John Wick\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\n" +
            "      \"release_date\": \"2014-10-22\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 6173,\n" +
            "      \"id\": 269149,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.7,\n" +
            "      \"title\": \"Zootopia\",\n" +
            "      \"popularity\": 172.438976,\n" +
            "      \"poster_path\": \"/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Zootopia\",\n" +
            "      \"genre_ids\": [\n" +
            "        16,\n" +
            "        12,\n" +
            "        10751,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.\",\n" +
            "      \"release_date\": \"2016-02-11\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 343,\n" +
            "      \"id\": 268531,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.1,\n" +
            "      \"title\": \"Captain Underpants: The First Epic Movie\",\n" +
            "      \"popularity\": 164.46309,\n" +
            "      \"poster_path\": \"/AjHZIkzhPXrRNE4VSLVWx6dirK9.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Captain Underpants: The First Epic Movie\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        16,\n" +
            "        35,\n" +
            "        10751\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/4F2np8VZjzNJh0SXvVyG4xph9eO.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"Two mischievous kids hypnotize their mean elementary school principal and turn him into their comic book creation, the kind-hearted and elastic-banded Captain Underpants.\",\n" +
            "      \"release_date\": \"2017-06-01\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 8199,\n" +
            "      \"id\": 99861,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.3,\n" +
            "      \"title\": \"Avengers: Age of Ultron\",\n" +
            "      \"popularity\": 154.84872,\n" +
            "      \"poster_path\": \"/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Avengers: Age of Ultron\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        878\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/vXIrvKadue7GdySiVh3huoQZiMi.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.\",\n" +
            "      \"release_date\": \"2015-04-22\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 2977,\n" +
            "      \"id\": 258489,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.6,\n" +
            "      \"title\": \"The Legend of Tarzan\",\n" +
            "      \"popularity\": 153.353572,\n" +
            "      \"poster_path\": \"/6FxOPJ9Ysilpq0IgkrMJ7PubFhq.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Legend of Tarzan\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/pWNBPN8ghaKtGLcQBMwNyM32Wbm.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment.\",\n" +
            "      \"release_date\": \"2016-06-29\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 124,\n" +
            "      \"id\": 335777,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.8,\n" +
            "      \"title\": \"The Nut Job 2: Nutty by Nature\",\n" +
            "      \"popularity\": 142.272944,\n" +
            "      \"poster_path\": \"/xOfdQHNF9TlrdujyAjiKfUhxSXy.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Nut Job 2: Nutty by Nature\",\n" +
            "      \"genre_ids\": [\n" +
            "        10751,\n" +
            "        16,\n" +
            "        12,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/bd1X5nNrrAHVGG0MxsAeCOPPh1w.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"When the evil mayor of Oakton decides to bulldoze Liberty Park and build a dangerous amusement park in its place, Surly Squirrel and his ragtag group of animal friends need to band together to save their home, defeat the mayor, and take back the park.\",\n" +
            "      \"release_date\": \"2017-08-11\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 2725,\n" +
            "      \"id\": 343668,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"title\": \"Kingsman: The Golden Circle\",\n" +
            "      \"popularity\": 140.699589,\n" +
            "      \"poster_path\": \"/34xBL6BXNYFqtHO9zhcgoakS4aP.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Kingsman: The Golden Circle\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        12,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/uExPmkOHJySrbJyJDJylHDqaT58.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"When an attack on the Kingsman headquarters takes place and a new villain rises, Eggsy and Merlin are forced to work together with the American agency known as the Statesman to save the world.\",\n" +
            "      \"release_date\": \"2017-09-20\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 4858,\n" +
            "      \"id\": 374720,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.4,\n" +
            "      \"title\": \"Dunkirk\",\n" +
            "      \"popularity\": 132.474819,\n" +
            "      \"poster_path\": \"/ebSnODDg9lbsMIaWg2uAbjn7TO5.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Dunkirk\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        18,\n" +
            "        36,\n" +
            "        53,\n" +
            "        10752\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/4yjJNAgXBmzxpS6sogj4ftwd270.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"The story of the miraculous evacuation of Allied soldiers from Belgium, Britain, Canada and France, who were cut off and surrounded by the German army from the beaches and harbour of Dunkirk between May 26th and June 4th 1940 during World War II.\",\n" +
            "      \"release_date\": \"2017-07-19\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 6590,\n" +
            "      \"id\": 346364,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.1,\n" +
            "      \"title\": \"It\",\n" +
            "      \"popularity\": 132.343602,\n" +
            "      \"poster_path\": \"/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"It\",\n" +
            "      \"genre_ids\": [\n" +
            "        18,\n" +
            "        27,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.\",\n" +
            "      \"release_date\": \"2017-09-05\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 2997,\n" +
            "      \"id\": 98566,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.8,\n" +
            "      \"title\": \"Teenage Mutant Ninja Turtles\",\n" +
            "      \"popularity\": 119.340293,\n" +
            "      \"poster_path\": \"/oDL2ryJ0sV2bmjgshVgJb3qzvwp.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Teenage Mutant Ninja Turtles\",\n" +
            "      \"genre_ids\": [\n" +
            "        878,\n" +
            "        28,\n" +
            "        12,\n" +
            "        14,\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/OqCXGt5nl1cHPeotxCDvXLLe6p.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"The city needs heroes. Darkness has settled over New York City as Shredder and his evil Foot Clan have an iron grip on everything from the police to the politicians. The future is grim until four unlikely outcast brothers rise from the sewers and discover their destiny as Teenage Mutant Ninja Turtles. The Turtles must work with fearless reporter April and her wise-cracking cameraman Vern Fenwick to save the city and unravel Shredder's diabolical plan.\",\n" +
            "      \"release_date\": \"2014-08-07\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 3507,\n" +
            "      \"id\": 254128,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6,\n" +
            "      \"title\": \"San Andreas\",\n" +
            "      \"popularity\": 118.419813,\n" +
            "      \"poster_path\": \"/qey0tdcOp9kCDdEZuJ87yE3crSe.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"San Andreas\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        18,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/cUfGqafAVQkatQ7N4y08RNV3bgu.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"In the aftermath of a massive earthquake in California, a rescue-chopper pilot makes a dangerous journey across the state in order to rescue his estranged daughter.\",\n" +
            "      \"release_date\": \"2015-05-27\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 2165,\n" +
            "      \"id\": 339964,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.6,\n" +
            "      \"title\": \"Valerian and the City of a Thousand Planets\",\n" +
            "      \"popularity\": 118.119615,\n" +
            "      \"poster_path\": \"/jfIpMh79fGRqYJ6PwZLCntzgxlF.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Valerian and the City of a Thousand Planets\",\n" +
            "      \"genre_ids\": [\n" +
            "        12,\n" +
            "        878,\n" +
            "        28\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/7WjMTRF6LDa4latRUIDM25xnDO0.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"In the 28th century, Valerian and Laureline are special operatives charged with keeping order throughout the human territories. On assignment from the Minister of Defense, the two undertake a mission to Alpha, an ever-expanding metropolis where species from across the universe have converged over centuries to share knowledge, intelligence, and cultures. At the center of Alpha is a mysterious dark force which threatens the peaceful existence of the City of a Thousand Planets, and Valerian and Laureline must race to identify the menace and safeguard not just Alpha, but the future of the universe.\",\n" +
            "      \"release_date\": \"2017-07-20\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 7279,\n" +
            "      \"id\": 240832,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.2,\n" +
            "      \"title\": \"Lucy\",\n" +
            "      \"popularity\": 115.497313,\n" +
            "      \"poster_path\": \"/rwn876MeqienhOVSSjtUPnwxn0Z.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Lucy\",\n" +
            "      \"genre_ids\": [\n" +
            "        28,\n" +
            "        878\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/eCgIoGvfNXrbSiQGqQHccuHjQHm.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"A woman, accidentally caught in a dark deal, turns the tables on her captors and transforms into a merciless warrior evolved beyond human logic.\",\n" +
            "      \"release_date\": \"2014-07-25\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 812,\n" +
            "      \"id\": 399404,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7.2,\n" +
            "      \"title\": \"Darkest Hour\",\n" +
            "      \"popularity\": 115.492017,\n" +
            "      \"poster_path\": \"/xa6G3aKlysQeVg9wOb0dRcIGlWu.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Darkest Hour\",\n" +
            "      \"genre_ids\": [\n" +
            "        18,\n" +
            "        36\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/zXwFJMwvQcJFitP9GcHZvHAHGe8.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"A thrilling and inspiring true story begins on the eve of World War II as, within days of becoming Prime Minister of Great Britain, Winston Churchill must face one of his most turbulent and defining trials: exploring a negotiated peace treaty with Nazi Germany, or standing firm to fight for the ideals, liberty and freedom of a nation. As the unstoppable Nazi forces roll across Western Europe and the threat of invasion is imminent, and with an unprepared public, a skeptical King, and his own party plotting against him, Churchill must withstand his darkest hour, rally a nation, and attempt to change the course of world history.\",\n" +
            "      \"release_date\": \"2017-11-22\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 492,\n" +
            "      \"id\": 345938,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 7,\n" +
            "      \"title\": \"The Shack\",\n" +
            "      \"popularity\": 115.438044,\n" +
            "      \"poster_path\": \"/doAzav9kfdtsoSdw1MDFvjKq3J4.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"The Shack\",\n" +
            "      \"genre_ids\": [\n" +
            "        18,\n" +
            "        14\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/un7pVnJC2el8YxdIOg6YrSmBTlO.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"After suffering a family tragedy, Mack Phillips spirals into a deep depression causing him to question his innermost beliefs. Facing a crisis of faith, he receives a mysterious letter urging him to an abandoned shack deep in the Oregon wilderness. Despite his doubts, Mack journeys to the shack and encounters an enigmatic trio of strangers led by a woman named Papa. Through this meeting, Mack finds important truths that will transform his understanding of his tragedy and change his life forever.\",\n" +
            "      \"release_date\": \"2017-03-03\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 2176,\n" +
            "      \"id\": 38365,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 6.1,\n" +
            "      \"title\": \"Grown Ups\",\n" +
            "      \"popularity\": 114.711762,\n" +
            "      \"poster_path\": \"/t6Yj2UlqsrHHK6kJO1FWepR6mEd.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Grown Ups\",\n" +
            "      \"genre_ids\": [\n" +
            "        35\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/q4s8RTQFyLrEn2S8akWGMmc8mYX.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"After their high school basketball coach passes away, five good friends and former teammates reunite for a Fourth of July holiday weekend.\",\n" +
            "      \"release_date\": \"2010-06-24\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"vote_count\": 4217,\n" +
            "      \"id\": 216015,\n" +
            "      \"video\": false,\n" +
            "      \"vote_average\": 5.3,\n" +
            "      \"title\": \"Fifty Shades of Grey\",\n" +
            "      \"popularity\": 112.039431,\n" +
            "      \"poster_path\": \"/jV8wnk3Jgz6f7degmT3lHNGI2tK.jpg\",\n" +
            "      \"original_language\": \"en\",\n" +
            "      \"original_title\": \"Fifty Shades of Grey\",\n" +
            "      \"genre_ids\": [\n" +
            "        18,\n" +
            "        10749,\n" +
            "        53\n" +
            "      ],\n" +
            "      \"backdrop_path\": \"/zAd0MjURkOvJynIsqmLMBcICxUt.jpg\",\n" +
            "      \"adult\": false,\n" +
            "      \"overview\": \"When college senior Anastasia Steele steps in for her sick roommate to interview prominent businessman Christian Grey for their campus paper, little does she realize the path her life will take. Christian, as enigmatic as he is rich and powerful, finds himself strangely drawn to Ana, and she to him. Though sexually inexperienced, Ana plunges headlong into an affair -- and learns that Christian's true sexual proclivities push the boundaries of pain and pleasure.\",\n" +
            "      \"release_date\": \"2015-02-11\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}