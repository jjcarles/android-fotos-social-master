package com.jocajica.gotocar.photomap.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.jocajica.gotocar.domain.FirebaseAPI;
import com.jocajica.gotocar.lib.base.EventBus;
import com.jocajica.gotocar.photomap.PhotoMapInteractor;
import com.jocajica.gotocar.photomap.PhotoMapInteractorImpl;
import com.jocajica.gotocar.photomap.PhotoMapPresenter;
import com.jocajica.gotocar.photomap.PhotoMapPresenterImpl;
import com.jocajica.gotocar.photomap.PhotoMapRepository;
import com.jocajica.gotocar.photomap.PhotoMapRepositoryImpl;
import com.jocajica.gotocar.photomap.ui.PhotoMapView;

/**
 * Created by ykro.
 */
@Module
public class PhotoMapModule {
    PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides @Singleton
    PhotoMapView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoMapPresenter providesPhotoContentPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoMapInteractor providesPhotoContentInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoMapRepository providesPhotoContentRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoMapRepositoryImpl(firebase, eventBus);
    }
}
