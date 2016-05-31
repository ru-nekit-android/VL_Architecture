package ru.nekit.android.vl_architecture.presentation.main;

import ru.nekit.android.vl_architecture.cleanArchitecture.router.IRouter;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingItemVO;

public interface IMainRouter extends IRouter {

    void showBuildingDetails(BuildingItemVO building);
}
