package ru.nekit.android.vl_architecture.buildingList.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ru.nekit.android.vl_architecture.cleanArchitecture.mapper.BaseMapper;
import ru.nekit.android.vl_architecture.buildingList.domain.BuildingEntity;
import ru.nekit.android.vl_architecture.buildingList.domain.BuildingImageEntity;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class BuildingDTOToBuildingEntityMapper extends BaseMapper<BuildingDTO, BuildingEntity> {
    @NonNull
    @Override
    protected BuildingEntity convert(BuildingDTO value) {
        List<BuildingImageEntity> images = null;
        if (value.getImages() != null) {
            images = new ArrayList<>(value.getImages().size());
            for (int i = 0; i < value.getImages().size(); i++) {
                BuildingImageDTO imageDTO = value.getImages().get(i);
                images.add(new BuildingImageEntity(imageDTO.getUrl(), imageDTO.getCaption(), imageDTO.getDescription()));
            }
        }
        return new BuildingEntity(Integer.parseInt(value.getId()), value.getName(), value.getUrl(), value.getImage(), value.getDescription(), value.getAuthor(), images);
    }
}
