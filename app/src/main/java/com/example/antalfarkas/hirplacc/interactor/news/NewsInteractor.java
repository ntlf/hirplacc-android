package com.example.antalfarkas.hirplacc.interactor.news;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.network.api.ArticlesApi;
import com.example.antalfarkas.hirplacc.model.Article;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class NewsInteractor {
    @Inject
    ArticlesApi articlesApi;

    public NewsInteractor() {
        HirPlaccApplication.injector.inject(this);
    }

    public List<Article> getArticles() throws IOException {
        return this.articlesApi.getArticles().execute().body();
    }
}
