package com.example.antalfarkas.hirplacc.interactor;

import com.example.antalfarkas.hirplacc.interactor.articles.DatabaseInteractor;
import com.example.antalfarkas.hirplacc.interactor.articles.ApiInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public ApiInteractor provideNewsInteractor() {
        return new ApiInteractor();
    }

    @Provides
    public DatabaseInteractor provideDatabaseInteractor() {
        return new DatabaseInteractor();
    }
}
