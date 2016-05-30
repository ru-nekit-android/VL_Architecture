package ru.nekit.android.vl_architecture.test;

import org.junit.Ignore;

import ru.nekit.android.vl_architecture.buildingList.presentation.view.BuildingListFragment;
import ru.nekit.android.vl_architecture.di.BuildingListComponent;
import ru.nekit.android.vl_architecture.di.modules.BuildingListModule;
import ru.nekit.android.vl_architecture.test.tools.BaseTest;

/**
 * Created by ru.nekit.android on 24.05.16.
 */

@Ignore
public class BuildingListFragmentTest extends BaseTest {

    private BuildingListFragment buildingListFragment;
    private BuildingListComponent component;

    @Override
    public void setUp() {
        buildingListFragment = BuildingListFragment.newInstance();
        component = buildingListFragment.getApplicationComponent().plus(new BuildingListModule());
    }

    @Override
    public void tearDown() {

    }
}
