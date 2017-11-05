package com.albertgf.pokeapp.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.albertgf.pokeapp.activity.DetailActivity;
import com.albertgf.pokeapp.activity.GenderActivity;
import com.albertgf.pokeapp.activity.ListActivity;
import com.albertgf.pokeapp.activity.MainActivity;

/**
 * Created by albertgf on 4/11/17.
 */

public class Navigator {
    public void navigateToMain(Activity context) {
        if (context != null) {
            Intent intentToLaunch = MainActivity.getCallingIntent(context);
            intentToLaunch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToGender(Activity context) {
        if (context != null) {
            Intent intentToLaunch = GenderActivity.getCallingIntent(context);
            intentToLaunch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToList(Activity context) {
        if (context != null) {
            Intent intentToLaunch = ListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToDetail(Activity context, View view, int id, String url) {
        if (context != null) {
            Intent intentToLaunch = DetailActivity.getCallingIntent(context, id, ViewCompat.getTransitionName(view),
                    url);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context,
                    view,
                    ViewCompat.getTransitionName(view));

            context.startActivity(intentToLaunch, options.toBundle());
        }
    }
}
