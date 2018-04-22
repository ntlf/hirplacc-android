package com.example.antalfarkas.hirplacc.interactor;

import com.example.antalfarkas.hirplacc.interactor.news.DatabaseInteractor;
import com.example.antalfarkas.hirplacc.interactor.news.NewsInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public NewsInteractor provideNewsInteractor() {
        return new NewsInteractor();
    }

    @Provides
    public DatabaseInteractor provideDatabaseInteractor() {
        return new DatabaseInteractor();
    }
}
