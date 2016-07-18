package com.jocajica.gotocar.photomap;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

import com.jocajica.gotocar.domain.FirebaseAPI;
import com.jocajica.gotocar.domain.FirebaseEventListenerCallback;
import com.jocajica.gotocar.entities.Photo;
import com.jocajica.gotocar.lib.base.EventBus;
import com.jocajica.gotocar.photomap.events.PhotoMapEvent;

/**
 * Created by ykro.
 */
public class PhotoMapRepositoryImpl implements PhotoMapRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;

    public PhotoMapRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void subscribe() {
        firebase.subscribe(new FirebaseEventListenerCallback() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                String email = firebase.getAuthEmail();

                boolean publishedByMy = photo.getEmail().equals(email);
                photo.setPublishedByMe(publishedByMy);
                post(PhotoMapEvent.READ_EVENT, photo);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                post(PhotoMapEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                post(error.getMessage());
            }
        });
    }

    @Override
    public void unsubscribe() {
        firebase.unsubscribe();
    }

    private void post(int type, Photo photo){
        post(type, photo, null);
    }

    private void post(String error){
        post(0, null, error);
    }

    private void post(int type, Photo photo, String error){
        PhotoMapEvent event = new PhotoMapEvent();
        event.setType(type);
        event.setError(error);
        event.setPhoto(photo);
        eventBus.post(event);
    }
}
