package com.example.antalfarkas.hirplacc.ui.main;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.interactor.news.NewsInteractor;
import com.example.antalfarkas.hirplacc.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    NewsInteractor newsInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        HirPlaccApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}