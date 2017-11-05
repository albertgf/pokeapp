package com.albertgf.data.repository;

import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiModelPokemon;
import com.albertgf.data.datasource.CloudDataSource;
import com.albertgf.data.datasource.DataSourceFactory;
import com.albertgf.data.datasource.DiskDataSource;
import com.albertgf.data.mapper.PokemonDataMapper;
import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.repository.PokemonRepository;
import com.albertgf.domain.usecase.DefaultCallback;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by albertgf on 4/11/17.
 */

@Singleton
public class PokemonDataRepository implements PokemonRepository {

    private final DataSourceFactory dataSource;
    private final PokemonDataMapper dataMapper;

    @Inject
    protected PokemonDataRepository(DataSourceFactory dataStore, PokemonDataMapper dataMapper) {
        if (dataStore == null || dataMapper == null) {
            throw new IllegalArgumentException("Invalid null parameters in constructor!!!");
        }

        this.dataSource = dataStore;
        this.dataMapper = dataMapper;
    }

    @Override public void getPokemonById(int id, DefaultCallback<PokemonModelView> callback) {
        final DiskDataSource diskDataSource = this.dataSource.createDiskDataSource();
        final CloudDataSource cloudDataSource = this.dataSource.createCloudDataStore();

        try {
            ApiModelPokemon pokemon = cloudDataSource.getPokemon(id);
            callback.onNext(dataMapper.transform(pokemon));
        } catch (ServerApiException | NetworkApiException e) {
            callback.onError(e);
        }
    }
}
