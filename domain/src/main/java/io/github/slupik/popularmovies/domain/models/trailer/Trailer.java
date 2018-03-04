package io.github.slupik.popularmovies.domain.models.trailer;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public interface Trailer {
    String getId();
    Trailer setId(String id);

    String getKey();
    Trailer setKey(String key);

    String getName();
    Trailer setName(String name);

    String getSite();
    Trailer setSite(String site);

    String getSize();
    Trailer setSize(String size);

    String getType();
    Trailer setType(String type);
}
