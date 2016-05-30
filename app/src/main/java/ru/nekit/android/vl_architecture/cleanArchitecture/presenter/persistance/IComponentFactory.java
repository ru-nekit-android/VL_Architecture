package ru.nekit.android.vl_architecture.cleanArchitecture.presenter.persistance;

import android.support.annotation.NonNull;

public interface IComponentFactory<C> {

    @NonNull
    C createComponent();
}
