package ru.nekit.android.vl_architecture.presentation.main;

import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingItemVO;

public interface MainRouter {
    void showBuildingDetails(BuildingItemVO building);
}
