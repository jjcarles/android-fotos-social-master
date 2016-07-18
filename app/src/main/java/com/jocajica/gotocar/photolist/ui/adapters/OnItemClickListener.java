package com.jocajica.gotocar.photolist.ui.adapters;

import android.widget.ImageView;

import com.jocajica.gotocar.entities.Photo;

/**
 * Created by ykro.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
