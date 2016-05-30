package ru.nekit.android.vl_architecture.presentation.di;

import dagger.Subcomponent;
import ru.nekit.android.vl_architecture.cleanArchitecture.presenter.IHasPresenter;
import ru.nekit.android.vl_architecture.presentation.di.modules.BuildingListModule;
import ru.nekit.android.vl_architecture.presentation.di.scopes.BuildingListScope;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.BuildingListPresenter;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.view.BuildingListFragment;

/**
 * Created by ru.nekit.android on 06.04.16.
 */
@Subcomponent(modules = {BuildingListModule.class})
@BuildingListScope
public interface BuildingListComponent extends IHasPresenter<BuildingListPresenter> {
    void inject(BuildingListFragment value);
}
