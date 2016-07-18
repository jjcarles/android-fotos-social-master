package com.jocajica.gotocar.main.ui;

/**
 * Created by ykro.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
