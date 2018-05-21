package io.github.slupik.popularmovies.view.utils;


import android.os.Build;
import android.os.Parcel;
import android.support.annotation.RequiresApi;
import android.view.Display;

import org.parceler.Parcels;
import org.parceler.converter.ArrayListParcelConverter;

import io.github.slupik.popularmovies.domain.models.ParcelableModel;

/**
 * Created by Sebastian Witasik on 12.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public class ModelParcelConverter<T extends ParcelableModel> extends ArrayListParcelConverter<T> {

    @Override
    public void itemToParcel(T input, Parcel parcel) {
        parcel.writeParcelable(Parcels.wrap(input), 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public T itemFromParcel(Parcel parcel) {
          return Parcels.unwrap(parcel.readParcelable(Display.Mode.class.getClassLoader()));
    }
}
