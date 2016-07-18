package com.jocajica.gotocar.login.di;

import javax.inject.Singleton;

import dagger.Component;

import com.jocajica.gotocar.PhotoFeedAppModule;
import com.jocajica.gotocar.domain.di.DomainModule;
import com.jocajica.gotocar.lib.di.LibsModule;
import com.jocajica.gotocar.login.ui.LoginActivity;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
