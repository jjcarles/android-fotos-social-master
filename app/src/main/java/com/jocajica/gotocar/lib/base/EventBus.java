package com.jocajica.gotocar.lib.base;

/**
 * Created by ykro.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
