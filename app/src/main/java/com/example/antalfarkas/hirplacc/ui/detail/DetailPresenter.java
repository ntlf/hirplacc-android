package com.example.antalfarkas.hirplacc.ui.detail;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.interactor.news.NewsInteractor;
import com.example.antalfarkas.hirplacc.ui.Presenter;

import javax.inject.Inject;

public class DetailPresenter extends Presenter<DetailScreen> {
    @Inject
    NewsInteractor newsInteractor;

    @Override
    public void attachScreen(DetailScreen screen){
        super.attachScreen(screen);
        HirPlaccApplication.injector.inject(this);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }
}