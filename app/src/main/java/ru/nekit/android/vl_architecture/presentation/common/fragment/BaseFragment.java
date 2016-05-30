package ru.nekit.android.vl_architecture.presentation.common.fragment;

import ru.nekit.android.vl_architecture.VLBuildingsApplication;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.IHasPresenter;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.IMVPPresenter;
import ru.nekit.android.vl_architecture.cleanArchitecture.view.fragment.MVPFragment;
import ru.nekit.android.vl_architecture.presentation.di.ApplicationComponent;

/**
 * Created by ru.nekit.android on 14.04.16.
 */
public abstract class BaseFragment<C extends IHasPresenter<P>, P extends IMVPPresenter> extends MVPFragment<C, P> {

    public ApplicationComponent getApplicationComponent() {
        return VLBuildingsApplication.get(getContext()).getApplicationComponent();
    }
}
