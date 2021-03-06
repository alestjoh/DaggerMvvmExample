package com.example.daggermvvmexample.common.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.example.daggermvvmexample.common.viewmodel.Status.ERROR;
import static com.example.daggermvvmexample.common.viewmodel.Status.LOADING;
import static com.example.daggermvvmexample.common.viewmodel.Status.SUCCESS;

public class Response {
    public final Status status;

    @Nullable
    public final String data;

    @Nullable
    public final Throwable error;

    private Response(Status status, @Nullable String data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Response loading() {
        return new Response(LOADING, null, null);
    }

    public static Response success(@NonNull String data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(ERROR, null, error);
    }
}
