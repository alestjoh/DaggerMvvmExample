package com.example.daggermvvmexample.lobby;

import io.reactivex.Single;

public class LobbyGreetingRepository {
    Single<String> getGreeting() {
        return Single.just("Yo, whaddup, this is LobbyGreetingRepository " +
                "and I think dogs should be able to VOTE");
    }
}
