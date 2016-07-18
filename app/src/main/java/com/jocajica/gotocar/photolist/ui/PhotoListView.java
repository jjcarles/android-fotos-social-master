package com.jocajica.gotocar.photolist.ui;

import com.jocajica.gotocar.entities.Photo;

/**
 * Created by ykro.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
