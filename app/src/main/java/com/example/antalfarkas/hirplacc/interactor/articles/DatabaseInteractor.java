package com.example.antalfarkas.hirplacc.interactor.articles;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.database.ArticleDao;
import com.example.antalfarkas.hirplacc.model.Article;

import java.util.List;

import javax.inject.Inject;

public class DatabaseInteractor {
    @Inject
    ArticleDao articleDao;

    public DatabaseInteractor() {
        HirPlaccApplication.injector.inject(this);
    }

    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    public Article getArticle(String id) {
        return articleDao.getArticle(id);
    }

    public void deleteArticle(Article article) {
        articleDao.delete(article);
    }

    public void saveArticle(Article... articles) {
        articleDao.insertAll(articles);
    }

    public void deleteAll() {
        articleDao.deleteAll();
    }
}