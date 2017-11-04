package com.albertgf.pokeapp.presenter;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.usecase.DefaultCallback;
import com.albertgf.domain.usecase.GetPokemonUseCase;
import com.albertgf.pokeapp.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */
@PerActivity
public class MainPresenter implements Presenter {

    private final GetPokemonUseCase pokemonUseCase;
    private View view;

    @Inject
    public MainPresenter(GetPokemonUseCase pokemonUseCase) {
        this.pokemonUseCase = pokemonUseCase;
    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;
        pokemonUseCase.execute(new GetPokemonCallback(), GetPokemonUseCase.Params.forPokemon(0));
    }

    @Override public void onViewDetached() {

    }

    public interface View extends PresenterView {

    }

    private class GetPokemonCallback extends DefaultCallback<PokemonModelView> {
        @Override
        public void onNext(PokemonModelView pokemon) {

        }

        @Override
        public void onComplete() {
            super.onComplete();

        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }
}
