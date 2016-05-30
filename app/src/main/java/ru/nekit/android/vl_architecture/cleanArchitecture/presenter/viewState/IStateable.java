package ru.nekit.android.vl_architecture.cleanArchitecture.presenter.viewState;

import android.support.annotation.NonNull;

/**
 * Created by ru.nekit.android on 18.03.16.
 */
public interface IStateable<T extends ViewState> {

    void onApplyViewState();

    @NonNull
    T getViewState();

    void setViewState(@NonNull T value);

}
