package ru.nekit.android.vl_architecture.buildingList.presentation.model;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import ru.nekit.android.vl_architecture.cleanArchitecture.mapper.BaseMapper;
import ru.nekit.android.vl_architecture.buildingList.domain.BuildingEntity;

/**
 * Created by ru.nekit.android on 24.05.16.
 */
public class BuildingEntityToItemVOMapper extends BaseMapper<BuildingEntity, BuildingItemVO> {

    @Inject
    public BuildingEntityToItemVOMapper() {
        //empty constructor for injection
    }

    @NonNull
    @Override
    protected BuildingItemVO convert(@NonNull BuildingEntity entity) {
        return new BuildingItemVO(entity.getId(), entity.getName(), entity.getImage());
    }
}
