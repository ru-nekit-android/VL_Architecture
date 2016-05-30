package ru.nekit.android.vl_architecture.buildingList.domain;

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
    private String url;
    private String image;

    public BuildingEntity(int id, String name, String url, String image, String description, String author, List<BuildingImageEntity> imageList) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.image = image;
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

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
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
