package com.matthewcannefax.fragmentandapipractice;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends ListAdapter<ImageItem, ViewPagerAdapter.ImageViewHolder> {

    public ViewPagerAdapter() {
        super(new DrawableDiffCallback());
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bind(getItem(position).getDrawable());
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
        }

        public void bind(Drawable drawable) {
            imageView.setImageDrawable(drawable);
        }
    }
}
