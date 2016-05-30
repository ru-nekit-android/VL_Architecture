package ru.nekit.android.vl_architecture.presentation.main.buildingList.model;

/**
 * Created by ru.nekit.android on 24.05.16.
 */
public class BuildingItemVO {

    private String title;
    private int id;
    private String image;

    public BuildingItemVO(int id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

}
