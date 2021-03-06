package ru.nekit.android.vl_architecture.presentation.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.nekit.android.vl_architecture.R;
import ru.nekit.android.vl_architecture.presentation.common.activity.BaseActivity;
import ru.nekit.android.vl_architecture.presentation.di.BuildingListComponent;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingItemVO;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.view.BuildingListFragment;

public class BuildingActivity extends BaseActivity<BuildingListComponent> implements IMainRouter {

    private static final String TAG = "fragmentTag";
    @Nullable
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private FragmentManager fragmentManager;

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) {
            replaceFragment(BuildingListFragment.newInstance(), false);
        }
    }

    private void replaceFragment(@NonNull Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public void showBuildingDetails(BuildingItemVO building) {

    }
}
