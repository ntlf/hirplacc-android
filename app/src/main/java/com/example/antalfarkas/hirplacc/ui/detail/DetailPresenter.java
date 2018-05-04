package com.example.antalfarkas.hirplacc.ui.detail;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.interactor.articles.DatabaseInteractor;
import com.example.antalfarkas.hirplacc.model.Article;
import com.example.antalfarkas.hirplacc.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class DetailPresenter extends Presenter<DetailScreen> {
    @Inject
    DatabaseInteractor databaseInteractor;

    @Inject
    Executor executor;

    public void loadArticle(final String id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Article article = databaseInteractor.getArticle(id);
                screen.showArticle(article);
            }
        });
    }

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