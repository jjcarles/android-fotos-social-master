package com.jocajica.gotocar.lib.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.jocajica.gotocar.lib.CloudinaryImageStorage;
import com.jocajica.gotocar.lib.GlideImageLoader;
import com.jocajica.gotocar.lib.GreenRobotEventBus;
import com.jocajica.gotocar.lib.base.EventBus;
import com.jocajica.gotocar.lib.base.ImageLoader;
import com.jocajica.gotocar.lib.base.ImageStorage;

/**
 * Created by ykro.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);
        return imageStorage;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }
}
