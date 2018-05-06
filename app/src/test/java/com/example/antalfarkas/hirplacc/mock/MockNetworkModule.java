package com.example.antalfarkas.hirplacc.mock;

import com.example.antalfarkas.hirplacc.network.api.ArticlesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockNetworkModule {
    @Provides
    @Singleton
    public ArticlesApi provideArticlesApi() {
        return new MockArticlesApi();
    }
}

