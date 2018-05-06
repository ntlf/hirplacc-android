package com.example.antalfarkas.hirplacc.ui.main;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.interactor.articles.DatabaseInteractor;
import com.example.antalfarkas.hirplacc.interactor.articles.ApiInteractor;
import com.example.antalfarkas.hirplacc.model.Article;
import com.example.antalfarkas.hirplacc.ui.Presenter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    ApiInteractor apiInteractor;

    @Inject
    DatabaseInteractor databaseInteractor;

    @Inject
    Executor executor;


    public void downloadNews() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Article> articleList = apiInteractor.getArticles();
                    saveArticles(articleList);
                    screen.showArticles(articleList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void saveArticles(final List<Article> articleList) {
        Article[] articles = new Article[articleList.size()];
        articles = articleList.toArray(articles);

        databaseInteractor.deleteAll();
        databaseInteractor.saveArticle(articles);
    }

    public void loadArticles() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Article> articleList = databaseInteractor.getAllArticles();
                screen.showArticles(articleList);
            }
        });
    }

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