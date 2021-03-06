package com.albertgf.pokeapp.di.components;

import com.albertgf.pokeapp.activity.DetailActivity;
import com.albertgf.pokeapp.activity.GenderActivity;
import com.albertgf.pokeapp.activity.ListActivity;
import com.albertgf.pokeapp.activity.MainActivity;
import com.albertgf.pokeapp.activity.SplashActivity;
import com.albertgf.pokeapp.di.PerActivity;
import com.albertgf.pokeapp.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by albertgf on 4/11/17.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface BaseComponent {
    void inject(SplashActivity activity);
    void inject(GenderActivity activity);
    void inject(MainActivity activity);
    void inject(ListActivity activity);
    void inject(DetailActivity activity);
}
