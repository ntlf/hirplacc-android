package com.example.antalfarkas.hirplacc.interactor.articles;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.network.api.ArticlesApi;
import com.example.antalfarkas.hirplacc.model.Article;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class ApiInteractor {
    @Inject
    ArticlesApi articlesApi;

    public ApiInteractor() {
        HirPlaccApplication.injector.inject(this);
    }

    public List<Article> getArticles() throws IOException {
        return this.articlesApi.getArticles().execute().body();
    }
}
