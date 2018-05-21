package io.github.slupik.popularmovies.view.main;

/**
 * Created by Sebastian Witasik on 19.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

enum FilmsType {
    UNKNOWN(-1),
    POPULAR(0),
    FAVOURITE(1),
    TOP_RATED(2);

    public final int ID;

    FilmsType(int id) {
        ID = id;
    }

    public static FilmsType fromId(int id){
        for(FilmsType type:values()) {
            if(type.ID==id) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
