package io.github.slupik.popularmovies.domain.models.review;

import java.util.List;

import io.github.slupik.popularmovies.domain.models.trailer.Trailer;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface ReviewList {
    List<Review> getList();
    ReviewList setList(List<Review> list);

    int getId();
    ReviewList setId(int id);

    int getPage();
    ReviewList setPage(int page);

    int getTotalResults();
    ReviewList setTotalResults(int totalResults);

    int getTotalPages();
    ReviewList setTotalPages(int totalPages);
}
