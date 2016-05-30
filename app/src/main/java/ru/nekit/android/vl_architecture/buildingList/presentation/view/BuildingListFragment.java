package ru.nekit.android.vl_architecture.buildingList.presentation.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.Bind;
import ru.nekit.android.vl_architecture.R;
import ru.nekit.android.vl_architecture.buildingList.presentation.BuildingListPresenter;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.BuildingItemVO;
import ru.nekit.android.vl_architecture.buildingList.presentation.model.IBuildingListViewModel;
import ru.nekit.android.vl_architecture.di.BuildingListComponent;
import ru.nekit.android.vl_architecture.di.modules.BuildingListModule;
import ru.nekit.android.vl_architecture.di.scopes.BuildingListScope;
import ru.nekit.android.vl_architecture.model.IImageLoader;
import ru.nekit.android.vl_architecture.ui.fragment.BaseFragment;
import timber.log.Timber;

@BuildingListScope
public class BuildingListFragment extends BaseFragment<BuildingListComponent, BuildingListPresenter>
        implements IBuildingListView {

    @Inject
    protected IImageLoader imageLoader;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private BuildingListAdapter mAdapter;

    @NonNull
    public static BuildingListFragment newInstance() {
        return new BuildingListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_building_list, container, false);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mAdapter = new BuildingListAdapter(getPresenter().getViewModel(), imageLoader);
        mAdapter.setOnItemClickListener(inView -> Timber.d("Building was clicked: " + ((BuildingItemVO) inView.getTag()).getTitle()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected BuildingListComponent onCreateNonConfigurationComponent() {
        return getApplicationComponent().plus(new BuildingListModule());
    }

    @Override
    public void showEmptyList() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showContent(IBuildingListViewModel content) {
        mAdapter.update();
    }

    @Override
    public void hideContent() {

    }

    @Override
    public void showError(Throwable throwable) {

    }
}
