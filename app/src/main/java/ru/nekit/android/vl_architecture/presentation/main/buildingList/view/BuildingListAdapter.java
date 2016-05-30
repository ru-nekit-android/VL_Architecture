package ru.nekit.android.vl_architecture.presentation.main.buildingList.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.nekit.android.vl_architecture.R;
import ru.nekit.android.vl_architecture.presentation.common.model.IImageLoader;
import ru.nekit.android.vl_architecture.presentation.main.buildingList.model.IBuildingListViewModel;

public class BuildingListAdapter extends RecyclerView.Adapter<BuildingViewHolder> {

    @NonNull
    private final IBuildingListViewModel model;
    @NonNull
    private final IImageLoader imageLoader;
    @Nullable
    private View.OnClickListener onItemClickListener;

    public BuildingListAdapter(@NonNull IBuildingListViewModel model, @NonNull IImageLoader imageLoader) {
        this.model = model;
        this.imageLoader = imageLoader;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_item_layout, parent, false);
        return new BuildingViewHolder(convertView, onItemClickListener, imageLoader);
    }

    @Override
    public void onBindViewHolder(BuildingViewHolder holder, int position) {
        holder.bind(model.get(position));
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public void update() {
        notifyDataSetChanged();
    }
}
