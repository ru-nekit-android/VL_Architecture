package ru.nekit.android.vl_architecture.presentation.main.buildingList.model;

import java.util.List;

import ru.nekit.android.vl_architecture.cleanArchitecture.model.IMVPViewModel;

/**
 * Created by ru.nekit.android on 08.03.16.
 */
public interface IBuildingListViewModel extends IMVPViewModel {

    List<BuildingItemVO> getBuildings();

    void setBuildings(List<BuildingItemVO> list);

    BuildingItemVO get(int position);

    int size();

    Throwable getError();

    void setError(Throwable error);
}
