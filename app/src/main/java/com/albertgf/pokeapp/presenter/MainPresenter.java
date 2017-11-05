package com.albertgf.pokeapp.presenter;

import com.albertgf.apiclient.exception.ApiException;
import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.usecase.CatchPokemonUseCase;
import com.albertgf.domain.usecase.DefaultCallback;
import com.albertgf.domain.usecase.GetPokemonUseCase;
import com.albertgf.pokeapp.di.PerActivity;

import java.util.Random;

import javax.inject.Inject;

import static com.albertgf.apiclient.Constants.CODE_NOT_FOUND;

/**
 * Created by albertgf on 4/11/17.
 */
@PerActivity
public class MainPresenter implements Presenter {

    private final GetPokemonUseCase pokemonUseCase;
    private final CatchPokemonUseCase catchPokemonUseCase;
    private View view;

    private PokemonModelView pokemon;

    @Inject
    public MainPresenter(GetPokemonUseCase pokemonUseCase, CatchPokemonUseCase catchPokemonUseCase) {
        this.pokemonUseCase = pokemonUseCase;
        this.catchPokemonUseCase = catchPokemonUseCase;
    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;
    }

    @Override public void onViewDetached() {

    }

    public void searchPokemon() {
        pokemonUseCase.execute(new GetPokemonCallback(), GetPokemonUseCase.Params.forPokemon(new Random().nextInt
                (1000)));
    }

    public void leavePokemon() {
        pokemon = null;
        view.hidePokemon();
    }

    public void catchPokemon() {
        catchPokemonUseCase.execute(new CatchPokemonCallback(), CatchPokemonUseCase.Params.forPokemon(pokemon));
    }

    public interface View extends PresenterView {
        void bindPokemon(PokemonModelView pokemon);
        void hidePokemon();
        void showNotFoundError();
        void showCatched();
    }

    private class GetPokemonCallback extends DefaultCallback<PokemonModelView> {
        @Override
        public void onNext(PokemonModelView pokemonModel) {
            pokemon = pokemonModel;
            view.bindPokemon(pokemon);
        }

        @Override
        public void onComplete() {
            super.onComplete();

        }

        @Override
        public void onError(Throwable exception) {
            ApiException api = (ApiException) exception;

            switch (api.getHttpCode()) {
                case CODE_NOT_FOUND:
                    view.showNotFoundError();
            }
        }
    }

    private class CatchPokemonCallback extends DefaultCallback<Object> {
        @Override
        public void onNext(Object object) {
            view.showCatched();
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable exception) {

        }
    }
}
