package com.example.antalfarkas.hirplacc.interactor.news;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;

public class NewsInteractor {

    public NewsInteractor() {
        HirPlaccApplication.injector.inject(this);
    }
}
