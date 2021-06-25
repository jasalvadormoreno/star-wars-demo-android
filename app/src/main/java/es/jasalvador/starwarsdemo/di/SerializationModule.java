package es.jasalvador.starwarsdemo.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class SerializationModule {

    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }
}
