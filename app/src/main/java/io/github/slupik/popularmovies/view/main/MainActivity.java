package io.github.slupik.popularmovies.view.main;

import android.os.Bundle;

import io.github.slupik.popularmovies.R;
import io.github.slupik.popularmovies.view.mvp.presented.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
