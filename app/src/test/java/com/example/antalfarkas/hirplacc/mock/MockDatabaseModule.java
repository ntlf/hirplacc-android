package com.example.antalfarkas.hirplacc.mock;

import com.example.antalfarkas.hirplacc.database.ArticleDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockDatabaseModule {
    @Singleton
    @Provides
    public ArticleDao provideArticleDao() {
        return new MockArticleDao();
    }
}
