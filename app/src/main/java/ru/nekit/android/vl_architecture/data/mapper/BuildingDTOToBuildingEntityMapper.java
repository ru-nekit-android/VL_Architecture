package ru.nekit.android.vl_architecture.data.mapper;

import java.util.ArrayList;
import java.util.List;

import ru.nekit.android.vl_architecture.domain.core.BaseMapper;
import ru.nekit.android.vl_architecture.data.dto.BuildingDTO;
import ru.nekit.android.vl_architecture.data.dto.BuildingImageDTO;
import ru.nekit.android.vl_architecture.domain.entity.BuildingEntity;
import ru.nekit.android.vl_architecture.domain.entity.BuildingImageEntity;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class BuildingDTOToBuildingEntityMapper extends BaseMapper<BuildingDTO, BuildingEntity> {
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
        return new BuildingEntity(Integer.parseInt(value.getId()), value.getName(), value.getDescription(), value.getAuthor(), images);
    }
}
