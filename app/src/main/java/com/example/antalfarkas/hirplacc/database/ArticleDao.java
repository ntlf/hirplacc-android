package com.example.antalfarkas.hirplacc.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.antalfarkas.hirplacc.model.Article;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM Article")
    public List<Article> getAllArticles();

    @Query("SELECT * FROM Article WHERE id = :id")
    public Article getArticle(String id);

    @Insert
    public void insertAll(Article... articles);

    @Delete
    public void delete(Article article);
}