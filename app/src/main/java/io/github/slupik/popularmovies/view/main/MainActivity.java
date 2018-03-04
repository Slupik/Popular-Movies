package io.github.slupik.popularmovies.view.main;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.domain.downloader.TheMovieDbDownloadError;
import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.view.main.list.RecycleViewFilmList;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static io.github.slupik.popularmovies.view.main.list.RecycleViewFilmList.NUMBER_OF_FILMS_IN_ROW;

public class MainActivity extends BaseActivity implements MainPresentedView {

    private static final boolean TEST_UX = false;

    @BindView(R.id.rv_film_list)
    RecyclerView rvFilmList;

    @BindView(R.id.btn_download_again)
    Button btnDownloadAgain;

    @Inject
    MainPresenter presenter;

    private RecycleViewFilmList mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        presenter.onAttach(this);

        setupDownloadingButton();
        setupRecyclerView();
    }

    private void setupDownloadingButton() {
        btnDownloadAgain.setVisibility(View.GONE);
        btnDownloadAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.downloadMoreData();
            }
        });
    }

    private void setupRecyclerView() {
        mAdapter = createFilmList();
        RecyclerView.LayoutManager manager;
        if(getResources().getConfiguration().orientation==ORIENTATION_LANDSCAPE) {
            manager = new GridLayoutManager(this, NUMBER_OF_FILMS_IN_ROW*2);
        } else {
            manager = new GridLayoutManager(this, NUMBER_OF_FILMS_IN_ROW);
        }
        rvFilmList.setLayoutManager(manager);
        rvFilmList.setHasFixedSize(true);
        rvFilmList.setAdapter(mAdapter);
    }

    private RecycleViewFilmList createFilmList() {
        RecycleViewFilmList mAdapter;
        if(TEST_UX) {
            mAdapter = FakePresenterForUXTest.initRecycleView(getApplicationContext());
        } else {
            mAdapter = new RecycleViewFilmList(presenter);
        }
        if(mAdapter.getContext()==null) {
            mAdapter.setContext(getApplicationContext());
        }
        return mAdapter;
    }


    private MenuItem miFavourite;
    private MenuItem miPopular;
    private MenuItem miRate;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);

        miFavourite = menu.findItem(R.id.sort_by_favourite);
        miPopular = menu.findItem(R.id.sort_by_popular);
        miRate = menu.findItem(R.id.sort_by_rate);
        presenter.onMenuCreate();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_popular: {
                presenter.switchFilmsType(FilmsType.POPULAR);
                return true;
            }
            case R.id.sort_by_rate: {
                presenter.switchFilmsType(FilmsType.TOP_RATED);
                return true;
            }
            case R.id.sort_by_favourite: {
                presenter.switchFilmsType(FilmsType.FAVOURITE);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeSortIcons(FilmsType type) {
        miFavourite.setIcon(R.drawable.favourite_off);
        miRate.setIcon(R.drawable.top_rated_off);
        miPopular.setIcon(R.drawable.best_off);

        if(FilmsType.POPULAR == type) {
            miPopular.setIcon(R.drawable.best_on);
        } else if(FilmsType.FAVOURITE == type) {
            miFavourite.setIcon(R.drawable.favourite_on);
        } else if(FilmsType.TOP_RATED == type) {
            miRate.setIcon(R.drawable.top_rated_on);
        }
    }

    @Override
    public void addFilms(List<Film> list) {
        mAdapter.addItems(list);
        if (list.size() > 0) {
            btnDownloadAgain.setVisibility(View.GONE);
        }
    }

    @Override
    public void flushFilms() {
        mAdapter.clearList();
    }

    @Override
    public void errorUnknownSortType() {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.unknown_film_sort_type);
        btnDownloadAgain.setVisibility(View.VISIBLE);
        addFilms(new ArrayList<Film>());
    }

    @Override
    public void errorWhileDownloading(TheMovieDbDownloadError error) {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.connection_error_check_connection);
        btnDownloadAgain.setVisibility(View.VISIBLE);
        addFilms(new ArrayList<Film>());
    }

    @Override
    public void errorUnknownWhileDownloading() {
        showErrorDialog(R.string.connection_to_database_error_title, R.string.connection_unknown_error);
        btnDownloadAgain.setVisibility(View.VISIBLE);
        addFilms(new ArrayList<Film>());
    }
}
