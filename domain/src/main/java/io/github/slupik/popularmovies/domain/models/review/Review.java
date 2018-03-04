package io.github.slupik.popularmovies.domain.models.review;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface Review {
    String getId();
    Review setId(String id);

    String getAuthor();
    void setAuthor(String author);

    String getContent();
    void setContent(String content);

    String getUrl();
    void setUrl(String url);
}
