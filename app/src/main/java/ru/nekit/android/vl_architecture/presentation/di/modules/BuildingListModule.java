package ru.nekit.android.vl_architecture.presentation.di.modules;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.nekit.android.vl_architecture.domain.buildingList.IBuildingsRepository;
import ru.nekit.android.vl_architecture.domain.buildingList.RequestBuildingListUseCase;
import ru.nekit.android.vl_architecture.presentation.di.scopes.BuildingListScope;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingListViewModel;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.IBuildingListViewModel;

/**
 * Created by ru.nekit.android on 08.03.16.
 */

@Module
@BuildingListScope
public class BuildingListModule {

    @Provides
    @NonNull
    public RequestBuildingListUseCase provideRequestBuildingListUseCase(IBuildingsRepository repository) {
        return new RequestBuildingListUseCase(repository);
    }

    @Provides
    @NonNull
    public IBuildingListViewModel provideIBuildingListViewModel() {
        return new BuildingListViewModel();
    }

}
