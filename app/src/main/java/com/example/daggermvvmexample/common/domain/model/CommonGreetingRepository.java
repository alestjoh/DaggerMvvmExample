package com.example.daggermvvmexample.common.domain.model;

import io.reactivex.Single;

public class CommonGreetingRepository {
    public Single<String> getGreeting() {
        return Single.just("Yo, what's up, this is CommonGreetingRepository " +
                "and I think dogs should learn how to READ");
    }
}
