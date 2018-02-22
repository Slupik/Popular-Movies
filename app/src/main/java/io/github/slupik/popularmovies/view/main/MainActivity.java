package io.github.slupik.popularmovies.view.main;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.slupik.data.film.gson.FilmDeserializer;
import io.github.slupik.data.film.list.FilmListBean;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.dagger.view.ContextModule;
import io.github.slupik.popularmovies.dagger.view.main.DaggerMainPresenterViewComponent;
import io.github.slupik.popularmovies.domain.film.Film;
import io.github.slupik.popularmovies.domain.film.downloader.FilmDownloadError;
import io.github.slupik.popularmovies.view.main.list.RecycleViewFilmList;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

import static io.github.slupik.popularmovies.view.main.list.RecycleViewFilmList.NUMBER_OF_FILMS_IN_ROW;
import static io.github.slupik.popularmovies.view.main.list.RecycleViewFilmList.PLAIN_JSON;

public class MainActivity extends BaseActivity implements MainPresentedView {

    @BindView(R.id.rv_film_list)
    RecyclerView rvFilmList;

    @Inject
    MainPresenter presenter;

    private RecycleViewFilmList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainPresenterViewComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build()
                .inject(this);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mAdapter = new RecycleViewFilmList(presenter);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, NUMBER_OF_FILMS_IN_ROW);
        rvFilmList.setLayoutManager(manager);
        rvFilmList.setHasFixedSize(true);
        rvFilmList.setAdapter(mAdapter);


        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Film.class, new FilmDeserializer())
                .setLenient()
                .create();
        FilmListBean list = gson.fromJson(PLAIN_JSON, FilmListBean.class);
        mAdapter.addFilmsSync(list.getList());
    }

    @Override
    public void addFilms(List<Film> list) {
        mAdapter.addFilms(list);
    }

    @Override
    public void flushFilms() {
        mAdapter.clearList();
    }

    @Override
    public void errorUnknownSortType() {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.unknown_film_sort_type);
        addFilms(new ArrayList<Film>());
    }

    @Override
    public void errorWhileDownloading(FilmDownloadError error) {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.connection_error_check_connection);
        addFilms(new ArrayList<Film>());
    }

    @Override
    public void errorUnknownWhileDownloading() {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.connection_unknown_error);
        addFilms(new ArrayList<Film>());
    }
}
