package es.jasalvador.starwarsdemo;

import androidx.multidex.MultiDexApplication;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public abstract class BaseApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        setupTimber();
    }

    abstract void setupTimber();
}
