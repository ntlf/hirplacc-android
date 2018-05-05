package com.example.antalfarkas.hirplacc;

import com.example.antalfarkas.hirplacc.database.DatabaseModule;
import com.example.antalfarkas.hirplacc.interactor.InteractorModule;
import com.example.antalfarkas.hirplacc.interactor.articles.ApiInteractor;
import com.example.antalfarkas.hirplacc.interactor.articles.DatabaseInteractor;
import com.example.antalfarkas.hirplacc.network.NetworkModule;
import com.example.antalfarkas.hirplacc.ui.UIModule;
import com.example.antalfarkas.hirplacc.ui.detail.DetailActivity;
import com.example.antalfarkas.hirplacc.ui.detail.DetailPresenter;
import com.example.antalfarkas.hirplacc.ui.main.MainActivity;
import com.example.antalfarkas.hirplacc.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class, DatabaseModule.class})
public interface HirPlaccApplicationComponent {
    void inject(MainPresenter mainPresenter);
    void inject(DetailPresenter detailPresenter);

    void inject(ApiInteractor apiInteractor);
    void inject(DatabaseInteractor databaseInteractor);
}