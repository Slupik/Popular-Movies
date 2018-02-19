package io.github.slupik.popularmovies.view.mvp.presented;

import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements PresentedView {

    protected void showErrorDialog(@StringRes int title, @StringRes int message){
        showErrorDialog(getString(title), getString(message));
    }
    protected void showErrorDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message)
                .setTitle(title);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
