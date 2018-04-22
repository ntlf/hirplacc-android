package com.example.antalfarkas.hirplacc.network.api;


import retrofit2.Call;
import retrofit2.http.*;

import com.example.antalfarkas.hirplacc.model.Article;

import java.util.List;

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
