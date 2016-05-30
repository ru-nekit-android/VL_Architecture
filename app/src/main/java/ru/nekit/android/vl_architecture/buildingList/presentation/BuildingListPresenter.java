package ru.nekit.android.vl_architecture.buildingList.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import ru.nekit.android.vl_architecture.buildingList.domain.RequestBuildingListUseCase;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingEntityToItemVOMapper;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingItemVO;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.IBuildingListViewModel;
import ru.nekit.android.vl_architecture.buildingList.presentation.view.IBuildingListView;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.LcePresenter;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.viewState.LceViewState;
import ru.nekit.android.vl_architecture.cleanArchitecture.utils.rx.RxTransformers;
import ru.nekit.android.vl_architecture.di.scopes.BuildingListScope;

/**
 * Created by ru.nekit.android on 02.03.16.
 */
@BuildingListScope
public class BuildingListPresenter extends LcePresenter<IBuildingListView, IBuildingListViewModel> {

    private final BuildingEntityToItemVOMapper mMapper;
    private final RequestBuildingListUseCase mInteractor;

    @Inject
    public BuildingListPresenter(@NonNull IBuildingListViewModel model, @NonNull RequestBuildingListUseCase interactor, @NonNull BuildingEntityToItemVOMapper mapper) {
        super(model);
        mInteractor = interactor;
        mMapper = mapper;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performLoad();
    }

    private void performLoad() {
        addSubscriber(mInteractor.execute().map(mMapper)
                .compose(
                        RxTransformers.applyOperationBeforeAndAfter(this::onBeforeLoad, this::onAfterLoad)
                )
                .subscribe(this::onResult, this::onError));
    }

    private void onBeforeLoad() {
        setViewState(LceViewState.LOADING);
    }

    private void onAfterLoad() {
    }

    private void onResult(List<BuildingItemVO> result) {
        //one view model - many lists
        withViewModel(model ->
                model.setBuildings(result)
        );
        setViewState(LceViewState.CONTENT);
    }

    private void onError(Throwable error) {
        withViewModel(model -> model.setError(error));
        setViewState(LceViewState.ERROR);
    }

    @Override
    public void onApplyViewState() {
        withViewAndModel((view, model) -> {
            LceViewState state = getViewState();

            switch (state) {
                case CONTENT:

                    view.hideLoading();
                    view.showContent(model);

                    break;

                case EMPTY:

                    view.hideLoading();
                    view.showEmptyList();

                    break;

                case LOADING:

                    view.hideContent();
                    view.showLoading();

                    break;

                case ERROR:

                    view.hideLoading();
                    view.showEmptyList();
                    view.showError(model.getError());

                    break;

                default:
                    break;

            }
        });
    }
}
