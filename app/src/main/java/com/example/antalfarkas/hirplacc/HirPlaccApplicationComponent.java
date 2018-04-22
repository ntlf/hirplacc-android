package com.example.antalfarkas.hirplacc;

import com.example.antalfarkas.hirplacc.interactor.InteractorModule;
import com.example.antalfarkas.hirplacc.interactor.news.NewsInteractor;
import com.example.antalfarkas.hirplacc.network.NetworkModule;
import com.example.antalfarkas.hirplacc.ui.UIModule;
import com.example.antalfarkas.hirplacc.ui.detail.DetailActivity;
import com.example.antalfarkas.hirplacc.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class})
public interface HirPlaccApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);

    void inject(NewsInteractor artistsInteractor);
}