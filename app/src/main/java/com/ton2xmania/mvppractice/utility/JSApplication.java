package com.ton2xmania.mvppractice.utility;

import android.app.Application;
import android.content.ContextWrapper;

/**
 * Created by ton2xmania on 17/10/16.
 */

public class JSApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new com.pixplicity.easyprefs.library.Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }
}
