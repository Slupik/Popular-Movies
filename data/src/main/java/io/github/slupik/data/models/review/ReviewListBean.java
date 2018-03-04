package io.github.slupik.data.models.review;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.popularmovies.domain.models.review.Review;
import io.github.slupik.popularmovies.domain.models.review.ReviewList;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class ReviewListBean implements ReviewList {
    @SerializedName("id")
    protected int id = -1;
    @SerializedName("page")
    protected int page = -1;
    @SerializedName("total_results")
    protected int totalResults = -1;
    @SerializedName("total_pages")
    protected int totalPages = -1;
    @SerializedName("results")
    protected List<Review> list = new ArrayList<>();

    @Override
    public List<Review> getList() {
        return list;
    }

    @Override
    public ReviewList setList(List<Review> list) {
        this.list.removeAll(list);
        this.list.addAll(list);
        return this;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ReviewList setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public ReviewList setPage(int page) {
        this.page = page;
        return this;
    }

    @Override
    public int getTotalResults() {
        return totalResults;
    }

    @Override
    public ReviewList setTotalResults(int totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public ReviewList setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }
}
