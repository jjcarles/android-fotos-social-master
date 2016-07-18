package com.jocajica.gotocar.lib.di;

import javax.inject.Singleton;

import dagger.Component;
import com.jocajica.gotocar.PhotoFeedAppModule;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {LibsModule.class, PhotoFeedAppModule.class})
public interface LibsComponent {
}
