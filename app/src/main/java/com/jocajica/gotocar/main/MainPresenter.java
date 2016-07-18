package com.jocajica.gotocar.main;

import android.location.Location;

import com.jocajica.gotocar.main.events.MainEvent;

/**
 * Created by ykro.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
