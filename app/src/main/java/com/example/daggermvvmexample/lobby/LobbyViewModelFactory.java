package com.example.daggermvvmexample.lobby;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.daggermvvmexample.common.domain.interactors.LoadCommonGreetingUseCase;
import com.example.daggermvvmexample.rx.SchedulersFacade;

public class LobbyViewModelFactory implements ViewModelProvider.Factory {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;
    private final LoadLobbyGreetingUseCase loadLobbyGreetingUseCase;
    private final SchedulersFacade schedulersFacade;

    public LobbyViewModelFactory(
            LoadCommonGreetingUseCase loadCommonGreetingUseCase,
            LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
            SchedulersFacade schedulersFacade) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.loadLobbyGreetingUseCase = loadLobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LobbyViewModel.class)) {
            return (T) new LobbyViewModel(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
