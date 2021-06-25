package es.jasalvador.starwarsdemo;

import timber.log.Timber;

public class App extends BaseApp {

    @Override
    void setupTimber() {
        Timber.plant(new ReleaseTree());
    }
}
