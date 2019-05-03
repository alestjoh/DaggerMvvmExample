package com.example.daggermvvmexample.di;

import com.example.daggermvvmexample.lobby.LobbyActivity;
import com.example.daggermvvmexample.lobby.LobbyModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = LobbyModule.class)
    abstract LobbyActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}
