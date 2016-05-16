package ru.nekit.android.vl_architecture.domain.entity;

import java.util.List;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class BuildingEntity {

    private int id;
    private String name;
    private String description;
    private String author;
    private List<BuildingImageEntity> imageList;

    public BuildingEntity(int id, String name, String description, String author, List<BuildingImageEntity> imageList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.imageList = imageList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public List<BuildingImageEntity> getImages() {
        return imageList;
    }

}
