package com.jocajica.gotocar.domain.di;

import javax.inject.Singleton;

import dagger.Component;
import com.jocajica.gotocar.PhotoFeedAppModule;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {
}
