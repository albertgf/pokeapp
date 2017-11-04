package com.albertgf.pokeapp.di.modules;

import android.app.Activity;

import com.albertgf.pokeapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertgf on 4/11/17.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
