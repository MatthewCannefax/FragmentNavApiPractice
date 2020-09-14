package com.matthewcannefax.fragmentandapipractice;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class DrawableDiffCallback extends DiffUtil.ItemCallback<ImageItem> {

    @Override
    public boolean areItemsTheSame(@NonNull ImageItem oldItem, @NonNull ImageItem newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull ImageItem oldItem, @NonNull ImageItem newItem) {
        return oldItem.equals(newItem);
    }
}
