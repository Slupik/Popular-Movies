package io.github.slupik.data.models.trailer;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.github.slupik.popularmovies.domain.models.trailer.Trailer;
import io.github.slupik.popularmovies.domain.models.trailer.TrailerList;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class TrailerListBean implements TrailerList {
    @SerializedName("id")
    protected int id = -1;
    @SerializedName("results")
    protected List<Trailer> list = new ArrayList<>();

    @Override
    public List<Trailer> getList() {
        return list;
    }

    @Override
    public TrailerList setList(List<Trailer> list) {
        this.list.removeAll(list);
        this.list.addAll(list);
        return this;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public TrailerList setId(int id) {
        this.id = id;
        return this;
    }
}
