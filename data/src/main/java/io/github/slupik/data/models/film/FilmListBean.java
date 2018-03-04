package io.github.slupik.data.models.film;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.popularmovies.domain.models.film.Film;
import io.github.slupik.popularmovies.domain.models.film.FilmList;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class FilmListBean implements FilmList {
    @SerializedName("page")
    protected int page = -1;
    @SerializedName("total_results")
    protected int totalResults = -1;
    @SerializedName("total_pages")
    protected int totalPages = -1;
    @SerializedName("results")
    protected List<Film> list = new ArrayList<>();

    @Override
    public List<Film> getList() {
        return list;
    }

    @Override
    public FilmList setList(List<Film> list) {
        this.list.removeAll(list);
        this.list.addAll(list);
        return this;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public FilmList setPage(int page) {
        this.page = page;
        return this;
    }

    @Override
    public int getTotalResults() {
        return totalResults;
    }

    @Override
    public FilmList setTotalResults(int totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public FilmList setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }
}
