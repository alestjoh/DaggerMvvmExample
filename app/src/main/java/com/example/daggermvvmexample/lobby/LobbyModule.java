package com.example.daggermvvmexample.lobby;

import com.example.daggermvvmexample.common.domain.interactors.LoadCommonGreetingUseCase;
import com.example.daggermvvmexample.rx.SchedulersFacade;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyActivity-specific dependencies here.
 */
@Module
public class LobbyModule {

    @Provides
    LobbyGreetingRepository provideLobbyGreetingRepository() {
        return new LobbyGreetingRepository();
    }

    @Provides
    LobbyViewModelFactory provideLobbyViewModelFactory(
            LoadCommonGreetingUseCase loadCommonGreetingUseCase,
            LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
            SchedulersFacade schedulersFacade) {
        return new LobbyViewModelFactory(
                loadCommonGreetingUseCase,
                loadLobbyGreetingUseCase,
                schedulersFacade);
    }
}
