package com.jocajica.gotocar.main.di;

import javax.inject.Singleton;

import dagger.Component;
import com.jocajica.gotocar.PhotoFeedAppModule;
import com.jocajica.gotocar.domain.di.DomainModule;
import com.jocajica.gotocar.lib.di.LibsModule;
import com.jocajica.gotocar.main.ui.MainActivity;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
