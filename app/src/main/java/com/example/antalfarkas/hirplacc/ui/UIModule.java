package com.example.antalfarkas.hirplacc.ui;

import javax.inject.Singleton;
import android.content.Context;

import com.example.antalfarkas.hirplacc.ui.detail.DetailPresenter;
import com.example.antalfarkas.hirplacc.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }


    @Provides
    @Singleton
    public DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }
}
