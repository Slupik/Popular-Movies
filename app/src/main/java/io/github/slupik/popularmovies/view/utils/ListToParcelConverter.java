package io.github.slupik.popularmovies.view.utils;

import android.os.Parcel;

import org.parceler.Parcels;
import org.parceler.converter.ArrayListParcelConverter;

/**
 * Created by Sebastian Witasik on 12.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class ListToParcelConverter<T> extends ArrayListParcelConverter<T> {
    private ClassLoader loader;

    ListToParcelConverter(ClassLoader classLoader){
        this.loader = classLoader;
    }

    @Override
    public void itemToParcel(T input, Parcel parcel) {
        parcel.writeParcelable(Parcels.wrap(input), 0);
    }

    @Override
    public T itemFromParcel(Parcel parcel) {
        return Parcels.unwrap(parcel.readParcelable(loader));
    }
}
