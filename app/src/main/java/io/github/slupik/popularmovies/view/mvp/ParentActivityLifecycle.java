package io.github.slupik.popularmovies.view.mvp;

/**
 * Created by Sebastian Witasik on 08.02.2018.
 * E-mail: SebastianWitasik@gmail.com
 * All rights reserved & copyright ©
 */

public interface ParentActivityLifecycle {
	void onCreate();
	void onStart();
	void onResume();
	void onPause();
	void onStop();
	void onDestroy();
}
