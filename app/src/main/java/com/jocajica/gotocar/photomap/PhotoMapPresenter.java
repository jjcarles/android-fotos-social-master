package com.jocajica.gotocar.photomap;

import com.jocajica.gotocar.photomap.events.PhotoMapEvent;

/**
 * Created by ykro.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
