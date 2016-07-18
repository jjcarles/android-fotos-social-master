package com.jocajica.gotocar.photolist;

import com.jocajica.gotocar.entities.Photo;

/**
 * Created by ykro.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
