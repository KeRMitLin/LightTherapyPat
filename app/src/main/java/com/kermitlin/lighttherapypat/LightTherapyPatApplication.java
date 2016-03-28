package com.kermitlin.lighttherapypat;

import com.firebase.client.Firebase;

public class LightTherapyPatApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
