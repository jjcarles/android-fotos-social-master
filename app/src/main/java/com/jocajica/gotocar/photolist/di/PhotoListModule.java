package com.jocajica.gotocar.photolist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.jocajica.gotocar.domain.FirebaseAPI;
import com.jocajica.gotocar.domain.Util;
import com.jocajica.gotocar.entities.Photo;
import com.jocajica.gotocar.lib.base.EventBus;
import com.jocajica.gotocar.lib.base.ImageLoader;
import com.jocajica.gotocar.photolist.PhotoListInteractor;
import com.jocajica.gotocar.photolist.PhotoListInteractorImpl;
import com.jocajica.gotocar.photolist.PhotoListPresenter;
import com.jocajica.gotocar.photolist.PhotoListPresenterImpl;
import com.jocajica.gotocar.photolist.PhotoListRepository;
import com.jocajica.gotocar.photolist.PhotoListRepositoryImpl;
import com.jocajica.gotocar.photolist.ui.PhotoListView;
import com.jocajica.gotocar.photolist.ui.adapters.OnItemClickListener;
import com.jocajica.gotocar.photolist.ui.adapters.PhotoListAdapter;

/**
 * Created by ykro.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }

}
