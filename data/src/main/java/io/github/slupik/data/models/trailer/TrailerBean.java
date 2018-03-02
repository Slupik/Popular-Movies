package io.github.slupik.data.models.trailer;

import com.google.gson.annotations.SerializedName;

import io.github.slupik.popularmovies.domain.models.trailer.Trailer;

/**
 * Created by Sebastian Witasik on 02.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class TrailerBean implements Trailer {
    @SerializedName("id")
    private String id;
    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;
    @SerializedName("site")
    private String site;
    @SerializedName("size")
    private String size;
    @SerializedName("type")
    private String type;

    public String getId() {
        return id;
    }

    public Trailer setId(String id) {
        this.id = id;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Trailer setKey(String key) {
        this.key = key;
        return this;
    }

    public String getName() {
        return name;
    }

    public Trailer setName(String name) {
        this.name = name;
        return this;
    }

    public String getSite() {
        return site;
    }

    public Trailer setSite(String site) {
        this.site = site;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Trailer setSize(String size) {
        this.size = size;
        return this;
    }

    public String getType() {
        return type;
    }

    public Trailer setType(String type) {
        this.type = type;
        return this;
    }
}
