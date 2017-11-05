package com.albertgf.pokeapp.presenter;

import com.albertgf.domain.model.PokemonModelView;
import com.albertgf.domain.usecase.DefaultCallback;
import com.albertgf.domain.usecase.GetPokemonListUseCase;
import com.albertgf.pokeapp.di.PerActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */
@PerActivity
public class ListPresenter implements Presenter {

    private final GetPokemonListUseCase listUseCase;
    private View view;

    @Inject
    public ListPresenter(GetPokemonListUseCase listUseCase) {
        this.listUseCase = listUseCase;
    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;

        listUseCase.execute(new GetPokemonCallback(), new GetPokemonListUseCase.Params());
    }

    @Override public void onViewDetached() {

    }


    public interface View extends PresenterView {
        void bindPokemons(List<PokemonModelView> list);
    }

    private class GetPokemonCallback extends DefaultCallback<List<PokemonModelView>> {
        @Override
        public void onNext(List<PokemonModelView> list) {
            view.bindPokemons(list);
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
