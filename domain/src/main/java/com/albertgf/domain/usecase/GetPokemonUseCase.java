package com.albertgf.domain.usecase;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.repository.PokemonRepository;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */

public class GetPokemonUseCase extends UseCase<PokemonModelView, GetPokemonUseCase.Params> {
    private final PokemonRepository repository;

    @Inject
    public GetPokemonUseCase(PokemonRepository repository, ThreadExecutor executor,
                                      PostExecutionThread postExecution) {
        super(executor, postExecution);
        this.repository = repository;
    }

    @Override
    public void run() {
        this.repository.getPokemonById(params.id, new RepositoryCallback());
    }

    @Override
    void buildUseCaseCallback(Params params) {
        this.params = params;
    }

    public static final class Params {
        private final int id;

        private Params(int id) {
            this.id = id;
        }

        public static GetPokemonUseCase.Params forPokemon(int id) {
            return new GetPokemonUseCase.Params(id);
        }
    }
}
