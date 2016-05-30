package ru.nekit.android.vl_architecture.presentation.main.buildingList.view;

import ru.nekit.android.vl_architecture.cleanArchitecture.view.ILCEView;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.IBuildingListViewModel;

/**
 * Created by ru.nekit.android on 05.03.16.
 */
public interface IBuildingListView extends ILCEView<IBuildingListViewModel, Throwable> {

    void showEmptyList();
}

