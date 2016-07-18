package com.jocajica.gotocar.photolist;

import com.jocajica.gotocar.entities.Photo;

/**
 * Created by ykro.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}
