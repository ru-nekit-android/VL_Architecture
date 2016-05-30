package ru.nekit.android.vl_architecture.cleanArchitecture.presenter;

/**
 * Created by ru.nekit.android on 14.04.16.
 */
public interface IHasPresenter<P extends IMVPPresenter> {

    P getPresenter();
}
