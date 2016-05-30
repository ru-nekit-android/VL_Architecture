package ru.nekit.android.vl_architecture.domain.buildingList;

/**
 * Created by ru.nekit.android on 16.05.16.
 */
public class BuildingImageEntity {

    private String url;
    private String caption;
    private String description;

    public BuildingImageEntity(String url, String caption, String description) {
        this.url = url;
        this.caption = caption;
        this.description = description;
    }

    public String getCaption() {
        return caption;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
