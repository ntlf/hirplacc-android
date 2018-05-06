package com.example.antalfarkas.hirplacc.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    private Context context;

    public DatabaseModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public ArticleDao provideArticleDao() {
        return Room.databaseBuilder(this.context, ArticleDatabase.class, "articles-database").build().getDAO();
    }
}
