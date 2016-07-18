package com.jocajica.gotocar.main;

import android.location.Location;

/**
 * Created by ykro.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
