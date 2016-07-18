package com.jocajica.gotocar.photomap.ui;

import com.jocajica.gotocar.entities.Photo;

/**
 * Created by ykro.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
