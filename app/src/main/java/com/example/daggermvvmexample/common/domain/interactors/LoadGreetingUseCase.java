package com.example.daggermvvmexample.common.domain.interactors;

import io.reactivex.Single;

public interface LoadGreetingUseCase {
    Single<String> execute();
}
