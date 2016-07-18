package com.jocajica.gotocar.login;

import com.jocajica.gotocar.login.events.LoginEvent;

/**
 * Created by ykro.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
