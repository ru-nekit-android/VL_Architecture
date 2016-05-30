package ru.nekit.android.vl_architecture.cleanArchitecture.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ru.nekit.android.vl_architecture.cleanArchitecture.model.IMVPViewModel;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.viewState.IStateable;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.viewState.LceViewState;
import ru.nekit.android.vl_architecture.cleanArchitecture.view.IMVPView;

/**
 * Created by ru.nekit.android on 16.04.16.
 */
public abstract class LcePresenter<V extends IMVPView, VM extends IMVPViewModel> extends MVPPresenter<V, VM> implements IStateable<LceViewState> {

    private LceViewState mConfirmedState;

    @NonNull
    private LceViewState mState = LceViewState.EMPTY;

    protected LcePresenter(@Nullable VM model) {
        super(model);
        confirmViewState();
    }

    @Override
    @NonNull
    public LceViewState getViewState() {
        return mState;
    }

    @Override
    public void setViewState(@NonNull LceViewState state) {
        mState = state;
        tryToApplyViewState();
    }

    @Override
    public void attachView(@NonNull V view) {
        super.attachView(view);
        tryToApplyViewState();
    }

    private void confirmViewState() {
        mConfirmedState = mState;
    }

    private boolean viewStateIsConfirmed() {
        return mConfirmedState == mState;
    }

    private void tryToApplyViewState() {
        if (getView() != null && !viewStateIsConfirmed()) {
            onApplyViewState();
            confirmViewState();
        }
    }
}
