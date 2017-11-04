package com.albertgf.pokeapp.di.components;

import android.content.Context;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.repository.PokemonRepository;
import com.albertgf.pokeapp.activity.BaseActivity;
import com.albertgf.pokeapp.di.modules.ApplicationModule;
import com.albertgf.pokeapp.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by albertgf on 4/11/17.
 */

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    Navigator Navigator();
    // ****** THREADS *************
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    // ****** REPOSITORIES ***********
    PokemonRepository pokemonRepository();
}
