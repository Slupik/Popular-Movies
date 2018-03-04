package io.github.slupik.popularmovies.domain.models.trailer;

import java.util.List;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface TrailerList {
    List<Trailer> getList();
    TrailerList setList(List<Trailer> list);

    int getId();
    TrailerList setId(int id);
}
