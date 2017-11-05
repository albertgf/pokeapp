package com.albertgf.domain.usecase;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.repository.PokemonRepository;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */

public class CatchPokemonUseCase extends UseCase<Object, CatchPokemonUseCase.Params> {
    private final PokemonRepository repository;

    @Inject
    public CatchPokemonUseCase(PokemonRepository repository, ThreadExecutor executor,
                               PostExecutionThread postExecution) {
        super(executor, postExecution);
        this.repository = repository;
    }

    @Override
    public void run() {
        this.repository.catchPokemon(params.pokemon, new RepositoryCallback());
    }

    @Override
    void buildUseCaseCallback(Params params) {
        this.params = params;
    }

    public static final class Params {
        private final PokemonModelView pokemon;

        private Params(PokemonModelView pokemon) {
            this.pokemon = pokemon;
        }

        public static CatchPokemonUseCase.Params forPokemon(PokemonModelView pokemon) {
            return new CatchPokemonUseCase.Params(pokemon);
        }
    }
}
