package com.albertgf.domain.usecase;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.repository.PokemonRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */

public class GetPokemonListUseCase extends UseCase<List<PokemonModelView>, GetPokemonListUseCase.Params> {
    private final PokemonRepository repository;

    @Inject
    public GetPokemonListUseCase(PokemonRepository repository, ThreadExecutor executor,
                                 PostExecutionThread postExecution) {
        super(executor, postExecution);
        this.repository = repository;
    }

    @Override
    public void run() {
        this.repository.getPokemons(new RepositoryCallback());
    }

    @Override
    void buildUseCaseCallback(Params params) {
        this.params = params;
    }

    public static final class Params {

    }
}
