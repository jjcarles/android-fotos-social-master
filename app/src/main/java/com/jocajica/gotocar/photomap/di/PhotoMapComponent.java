package com.jocajica.gotocar.photomap.di;

import javax.inject.Singleton;

import dagger.Component;
import com.jocajica.gotocar.PhotoFeedAppModule;
import com.jocajica.gotocar.domain.di.DomainModule;
import com.jocajica.gotocar.lib.di.LibsModule;
import com.jocajica.gotocar.photomap.ui.PhotoMapFragment;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}
