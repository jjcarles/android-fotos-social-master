package com.jocajica.gotocar.photolist;

import com.jocajica.gotocar.entities.Photo;
import com.jocajica.gotocar.photolist.events.PhotoListEvent;

/**
 * Created by ykro.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
