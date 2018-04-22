package com.example.antalfarkas.hirplacc.interactor.news;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.database.ArticleDatabase;
import com.example.antalfarkas.hirplacc.model.Article;

import java.util.List;

import javax.inject.Inject;

public class DatabaseInteractor {
    @Inject
    ArticleDatabase articleDatabase;

    public DatabaseInteractor() {
        HirPlaccApplication.injector.inject(this);
    }

    public List<Article> getAllArticles() {
        return articleDatabase.getDAO().getAllArticles();
    }

    public Article getArticle(String id) {
        return articleDatabase.getDAO().getArticle(id);
    }

    public void deleteArticle(Article article) {
        articleDatabase.getDAO().delete(article);
    }

    public void saveArticle(Article... articles) {
        articleDatabase.getDAO().insertAll(articles);
    }

    public void deleteAll() {
        articleDatabase.getDAO().deleteAll();
    }
}