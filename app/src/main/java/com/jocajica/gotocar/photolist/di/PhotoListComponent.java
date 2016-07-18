package com.jocajica.gotocar.photolist.di;

import javax.inject.Singleton;

import dagger.Component;
import com.jocajica.gotocar.PhotoFeedAppModule;
import com.jocajica.gotocar.domain.di.DomainModule;
import com.jocajica.gotocar.lib.di.LibsModule;
import com.jocajica.gotocar.photolist.ui.PhotoListFragment;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
