package com.example.daggermvvmexample.lobby;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.daggermvvmexample.common.domain.interactors.LoadCommonGreetingUseCase;
import com.example.daggermvvmexample.common.domain.interactors.LoadGreetingUseCase;
import com.example.daggermvvmexample.common.viewmodel.Response;
import com.example.daggermvvmexample.rx.SchedulersFacade;

import io.reactivex.disposables.CompositeDisposable;

public class LobbyViewModel extends ViewModel {

    private final LoadCommonGreetingUseCase loadCommonGreetingUseCase;
    private final LoadLobbyGreetingUseCase loadLobbyGreetingUseCase;
    private final SchedulersFacade schedulersFacade;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final MutableLiveData<Response> response = new MutableLiveData<>();

    public LobbyViewModel(LoadCommonGreetingUseCase loadCommonGreetingUseCase,
                          LoadLobbyGreetingUseCase loadLobbyGreetingUseCase,
                          SchedulersFacade schedulersFacade) {
        this.loadCommonGreetingUseCase = loadCommonGreetingUseCase;
        this.loadLobbyGreetingUseCase = loadLobbyGreetingUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        disposable.clear();
    }

    void loadCommonGreeting() {
        loadGreeting(loadCommonGreetingUseCase);
    }

    void loadLobbyGreeting() {
        loadGreeting(loadLobbyGreetingUseCase);
    }

    LiveData<Response> response() {
        return response;
    }

    private void loadGreeting(LoadGreetingUseCase loadGreetingUseCase) {
        disposable.add(loadGreetingUseCase.execute()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        greeting -> response.setValue(Response.success(greeting)),
                        throwable -> response.setValue(Response.error(throwable))
                )
        );
    }
}
