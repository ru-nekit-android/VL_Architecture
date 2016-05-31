package ru.nekit.android.vl_architecture.cleanArchitecture.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import ru.nekit.android.vl_architecture.cleanArchitecture.model.IMVPViewModel;
import ru.nekit.android.vl_architecture.cleanArchitecture.view.IMVPView;

/**
 * Created by ru.nekit.android on 06.03.16.
 */
public interface IMVPPresenter<V extends IMVPView, VM extends IMVPViewModel, Router> {

    @UiThread
    void attachView(@NonNull V view);

    @UiThread
    void detachView();

    @UiThread
    @Nullable
    V getView();

    @Nullable
    VM getViewModel();

    @UiThread
    void onCreate(@Nullable Bundle savedInstanceState);

    @UiThread
    void onSaveInstanceState(@Nullable Bundle bundle);

    @UiThread
    void onDestroy();

    @UiThread
    void onAttachView(@NonNull V view);

    @Nullable
    Router getRouter();

    void setRouter(@Nullable Router router);
}
