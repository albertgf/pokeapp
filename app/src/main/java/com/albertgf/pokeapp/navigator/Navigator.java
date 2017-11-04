package com.albertgf.pokeapp.navigator;

import android.app.Activity;
import android.content.Intent;

import com.albertgf.pokeapp.activity.GenderActivity;
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
}
