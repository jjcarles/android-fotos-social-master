package com.jocajica.gotocar;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import com.jocajica.gotocar.domain.di.DomainModule;
import com.jocajica.gotocar.lib.di.LibsModule;
import com.jocajica.gotocar.login.di.DaggerLoginComponent;
import com.jocajica.gotocar.login.di.LoginComponent;
import com.jocajica.gotocar.login.di.LoginModule;
import com.jocajica.gotocar.login.ui.LoginView;
import com.jocajica.gotocar.main.di.DaggerMainComponent;
import com.jocajica.gotocar.main.di.MainComponent;
import com.jocajica.gotocar.main.di.MainModule;
import com.jocajica.gotocar.main.ui.MainView;
import com.jocajica.gotocar.photolist.di.DaggerPhotoListComponent;
import com.jocajica.gotocar.photolist.di.PhotoListComponent;
import com.jocajica.gotocar.photolist.di.PhotoListModule;
import com.jocajica.gotocar.photolist.ui.PhotoListView;
import com.jocajica.gotocar.photolist.ui.adapters.OnItemClickListener;
import com.jocajica.gotocar.photomap.di.DaggerPhotoMapComponent;
import com.jocajica.gotocar.photomap.di.PhotoMapComponent;
import com.jocajica.gotocar.photomap.di.PhotoMapModule;
import com.jocajica.gotocar.photomap.ui.PhotoMapView;

/**
 * Created by ykro.
 */
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private LibsModule libsModule;
    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        photoFeedAppModule = new PhotoFeedAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        libsModule.setFragment(fragment);

        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();

    }

    public PhotoMapComponent getPhotoMapComponent(Fragment fragment, PhotoMapView view) {
        libsModule.setFragment(fragment);

        return DaggerPhotoMapComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoMapModule(new PhotoMapModule(view))
                .build();

    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[]fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .mainModule(new MainModule(view, manager, fragments, titles))
                .build();
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }
}
