package ru.nekit.android.vl_architecture.di;

import dagger.Subcomponent;
import ru.nekit.android.vl_architecture.buildingList.presentation.BuildingListPresenter;
import ru.nekit.android.vl_architecture.buildingList.presentation.view.BuildingListFragment;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.IHasPresenter;
import ru.nekit.android.vl_architecture.di.modules.BuildingListModule;
import ru.nekit.android.vl_architecture.di.scopes.BuildingListScope;

/**
 * Created by ru.nekit.android on 06.04.16.
 */
@Subcomponent(modules = {BuildingListModule.class})
@BuildingListScope
public interface BuildingListComponent extends IHasPresenter<BuildingListPresenter> {
    void inject(BuildingListFragment value);
}
