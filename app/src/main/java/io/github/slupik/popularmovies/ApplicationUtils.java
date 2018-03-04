package io.github.slupik.popularmovies;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by Sebastian Witasik on 03.03.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */

public class ApplicationUtils {
    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }
}
