package ru.nekit.android.vl_architecture.buildingList.presentation.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

/**
 * Created by ru.nekit.android on 24.05.16.
 */
public class BuildingListViewModel implements IBuildingListViewModel {

    @NonNull
    private List<BuildingItemVO> mList = emptyList();

    @Nullable
    private Throwable mError;

    public BuildingListViewModel() {
        //no-op
    }

    //TODO: Only for unit testing
    public BuildingListViewModel(@NonNull List<BuildingItemVO> list) {
        mList = list;
    }

    @NonNull
    public List<BuildingItemVO> getBuildings() {
        return mList;
    }

    public void setBuildings(@NonNull List<BuildingItemVO> value) {
        mList = unmodifiableList(value);// Prevent possible side-effects.
    }

    @NonNull
    public BuildingItemVO get(int position) {
        return mList.get(position);
    }

    public int size() {
        return mList.size();
    }

    @Override
    public Throwable getError() {
        return mError;
    }

    @Override
    public void setError(Throwable error) {
        mError = error;
    }
}
