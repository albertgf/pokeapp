package com.albertgf.pokeapp.di.modules;

import android.content.Context;

import com.albertgf.data.executor.JobExecutor;
import com.albertgf.data.repository.PokemonDataRepository;
import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.repository.PokemonRepository;
import com.albertgf.pokeapp.PokeApp;
import com.albertgf.pokeapp.UIThread;
import com.albertgf.pokeapp.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertgf on 4/11/17.
 */
@Module
public class ApplicationModule {
    private final PokeApp application;

    public ApplicationModule(PokeApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    PokemonRepository providePokemonRepository(PokemonDataRepository repository) {
        return repository;
    }
}
