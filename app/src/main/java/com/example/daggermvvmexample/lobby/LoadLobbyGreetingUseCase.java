package com.example.daggermvvmexample.lobby;

import com.example.daggermvvmexample.common.domain.interactors.LoadGreetingUseCase;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoadLobbyGreetingUseCase implements LoadGreetingUseCase {
    private final LobbyGreetingRepository greetingRepository;

    @Inject
    LoadLobbyGreetingUseCase(LobbyGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Single<String> execute() {
        return greetingRepository.getGreeting();
    }
}
