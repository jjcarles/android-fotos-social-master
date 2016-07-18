package com.jocajica.gotocar.login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.jocajica.gotocar.domain.FirebaseAPI;
import com.jocajica.gotocar.lib.base.EventBus;
import com.jocajica.gotocar.login.LoginInteractor;
import com.jocajica.gotocar.login.LoginInteractorImpl;
import com.jocajica.gotocar.login.LoginPresenter;
import com.jocajica.gotocar.login.LoginPresenterImpl;
import com.jocajica.gotocar.login.LoginRepository;
import com.jocajica.gotocar.login.LoginRepositoryImpl;
import com.jocajica.gotocar.login.SignupInteractor;
import com.jocajica.gotocar.login.SignupInteractorImpl;
import com.jocajica.gotocar.login.ui.LoginView;

/**
 * Created by ykro.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}
