package com.example.antalfarkas.hirplacc.network;

import com.example.antalfarkas.hirplacc.network.api.ArticlesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {
    @Singleton
    @Provides
    public ArticlesApi provideArticlesApi() {
        return new ApiClient().createService(ArticlesApi.class);
    }
}