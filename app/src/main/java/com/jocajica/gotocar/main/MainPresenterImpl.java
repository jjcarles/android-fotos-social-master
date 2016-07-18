package com.jocajica.gotocar.main;

import android.location.Location;

import org.greenrobot.eventbus.Subscribe;

import com.jocajica.gotocar.lib.base.EventBus;
import com.jocajica.gotocar.main.events.MainEvent;
import com.jocajica.gotocar.main.ui.MainView;

/**
 * Created by ykro.
 */
public class MainPresenterImpl implements MainPresenter{
    MainView view;
    EventBus eventBus;
    UploadInteractor uploadInteractor;
    SessionInteractor sessionInteractor;

    public MainPresenterImpl(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        this.view = view;
        this.eventBus = eventBus;
        this.uploadInteractor = uploadInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void uploadPhoto(Location location, String path) {
        uploadInteractor.execute(location, path);
    }

    @Override
    @Subscribe
    public void onEventMainThread(MainEvent event) {
        String error = event.getError();
        if (this.view != null) {
            switch (event.getType()) {
                case MainEvent.UPLOAD_INIT:
                    view.onUploadInit();
                    break;
                case MainEvent.UPLOAD_COMPLETE:
                    view.onUploadComplete();
                    break;
                case MainEvent.UPLOAD_ERROR:
                    view.onUploadError(error);
                    break;
            }
        }
    }

    @Override
    public void logout() {
        sessionInteractor.logout();
    }
}
