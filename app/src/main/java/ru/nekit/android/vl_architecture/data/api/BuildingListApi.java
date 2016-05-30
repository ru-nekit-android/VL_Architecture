package ru.nekit.android.vl_architecture.data.api;

import java.util.List;

import retrofit2.http.GET;
import ru.nekit.android.vl_architecture.data.buildingList.BuildingDTO;
import rx.Single;

/**
 * Created by ru.nekit.android on 23.05.16.
 */
public interface BuildingListApi {

    @GET("buildings/")
    Single<List<BuildingDTO>> getBuildings();

}
