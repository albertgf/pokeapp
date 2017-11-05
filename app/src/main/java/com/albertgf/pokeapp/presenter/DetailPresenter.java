package com.albertgf.pokeapp.presenter;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.usecase.DefaultCallback;
import com.albertgf.domain.usecase.GetPokemonListUseCase;
import com.albertgf.domain.usecase.GetPokemonUseCase;
import com.albertgf.pokeapp.di.PerActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */
@PerActivity
public class DetailPresenter implements Presenter {

    private final GetPokemonUseCase getPokemonUseCase;
    private View view;

    @Inject
    public DetailPresenter(GetPokemonUseCase useCase) {
        this.getPokemonUseCase = useCase;
    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;
    }

    @Override public void onViewDetached() {

    }

    public void setPokemonId(int id) {
        getPokemonUseCase.execute(new GetPokemonCallback(), GetPokemonUseCase.Params.forPokemon(id));
    }

    public interface View extends PresenterView {
        void bindPokemon(PokemonModelView pokemon);
    }

    private class GetPokemonCallback extends DefaultCallback<PokemonModelView> {
        @Override
        public void onNext(PokemonModelView pokemon) {
            view.bindPokemon(pokemon);
        }

        @Override
        public void onComplete() {
            super.onComplete();

        }

        @Override
        public void onError(Throwable exception) {
        }
    }
}
