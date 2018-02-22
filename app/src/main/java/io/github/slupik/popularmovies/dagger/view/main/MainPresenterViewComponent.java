package io.github.slupik.popularmovies.dagger.view.main;

import dagger.Component;
import io.github.slupik.popularmovies.view.main.MainActivity;

/**
 * Created by Sebastian Witasik on 21.02.2018.
 * E-mail: Sebastian Witasik
 * All rights reserved & copyright ©
 */
@Component(modules = {PresentedViewModule.class})
public interface MainPresenterViewComponent {
    void inject(MainActivity activity);
}
