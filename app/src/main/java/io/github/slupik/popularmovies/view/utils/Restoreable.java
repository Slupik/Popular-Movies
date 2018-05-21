package io.github.slupik.popularmovies.view.utils;

import android.os.Bundle;

/**
 * Created by Sebastian Witasik on 12.03.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface Restoreable {
    Bundle onSave();
    void onRestore(Bundle bundle);
}
