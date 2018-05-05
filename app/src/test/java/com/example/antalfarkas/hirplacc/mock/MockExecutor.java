package com.example.antalfarkas.hirplacc.mock;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class MockExecutor implements Executor {
    private Handler mHandler;

    public MockExecutor() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }
}
