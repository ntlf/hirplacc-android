package com.example.antalfarkas.hirplacc.network.api;

import com.example.antalfarkas.hirplacc.network.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.antalfarkas.hirplacc.network.model.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArticlesApi {
  
  /**
   * Get articles
   * Returns a bunch of articles
   * @return Call<List<Article>>
   */
  
  @GET("articles")
  Call<List<Article>> getArticles();
    

  
  /**
   * Find article by ID
   * Returns a single article
   * @param articleId ID of article to return
   * @return Call<Article>
   */
  
  @GET("articles/{articleId}")
  Call<Article> getArticleById(
          @Path("articleId") String articleId
  );

  
}
