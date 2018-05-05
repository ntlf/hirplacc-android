package com.example.antalfarkas.hirplacc.mock;

import com.example.antalfarkas.hirplacc.database.ArticleDao;
import com.example.antalfarkas.hirplacc.model.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockArticleDao implements ArticleDao {
    List<Article> articleList;

    MockArticleDao() {
        articleList = new ArrayList<>(MockData.articleList);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleList;
    }

    @Override
    public Article getArticle(String id) {
        for (Article a : articleList) {
            if(a.getId().equals(id)) {
                return a;
            }
        }

        return null;
    }

    @Override
    public void insertAll(Article... articles) {
        articleList.addAll(Arrays.asList(articles));
    }

    @Override
    public void delete(Article article) {
        articleList.remove(article);

    }

    @Override
    public void deleteAll() {
        articleList.removeAll(articleList);
    }
}
