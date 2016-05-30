package ru.nekit.android.vl_architecture.api;

import java.util.List;

import retrofit2.http.GET;
import ru.nekit.android.vl_architecture.buildingList.data.BuildingDTO;
import rx.Single;

/**
 * Created by ru.nekit.android on 23.05.16.
 */
public interface BuildingListApi {

    @GET("buildings/")
    Single<List<BuildingDTO>> getBuildings();

}
