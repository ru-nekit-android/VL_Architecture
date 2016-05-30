package ru.nekit.android.vl_architecture.presentation.main.buildingList.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.nekit.android.vl_architecture.R;
import ru.nekit.android.vl_architecture.presentation.common.model.IImageLoader;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.BuildingItemVO;

/**
 * Created by ru.nekit.android on 30.05.16.
 */
public class BuildingViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.building_title)
    TextView buildingTitle;

    @Bind(R.id.building_image)
    ImageView buildingImage;

    public BuildingViewHolder(View itemView, View.OnClickListener onItemClickListener, IImageLoader imageLoader) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(onItemClickListener);
    }

    public void bind(BuildingItemVO building) {
        buildingTitle.setText(building.getTitle());
        itemView.setTag(building);
    }
}
