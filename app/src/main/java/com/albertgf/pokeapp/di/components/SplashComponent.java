package com.albertgf.pokeapp.di.components;

import com.albertgf.pokeapp.activity.SplashActivity;
import com.albertgf.pokeapp.di.PerActivity;
import com.albertgf.pokeapp.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by albertgf on 4/11/17.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
