package com.matthewcannefax.fragmentandapipractice;

import android.graphics.drawable.Drawable;

import java.util.Objects;

public class ImageItem {
    private Drawable drawable;
    private int id;

    public ImageItem(Drawable drawable, int id) {
        this.drawable = drawable;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageItem imageItem = (ImageItem) o;
        return id == imageItem.id &&
                Objects.equals(drawable, imageItem.drawable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drawable, id);
    }
}
