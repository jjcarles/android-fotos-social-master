package com.jocajica.gotocar.main;

import android.location.Location;

/**
 * Created by ykro.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
