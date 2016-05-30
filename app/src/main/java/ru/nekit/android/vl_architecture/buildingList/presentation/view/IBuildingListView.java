package ru.nekit.android.vl_architecture.buildingList.presentation.view;

import ru.nekit.android.vl_architecture.buildingList.presentation.model.IBuildingListViewModel;
import ru.nekit.android.vl_architecture.cleanArchitecture.view.ILCEView;

/**
 * Created by ru.nekit.android on 05.03.16.
 */
public interface IBuildingListView extends ILCEView<IBuildingListViewModel, Throwable> {

    void showEmptyList();
}

