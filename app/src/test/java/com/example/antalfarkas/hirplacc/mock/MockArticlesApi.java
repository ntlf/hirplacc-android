package com.example.antalfarkas.hirplacc.mock;

import com.example.antalfarkas.hirplacc.model.Article;
import com.example.antalfarkas.hirplacc.network.api.ArticlesApi;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MockArticlesApi implements ArticlesApi {
    @Override
    public Call<List<Article>> getArticles() {
        return new Call<List<Article>>() {
            @Override
            public Response<List<Article>> execute() throws IOException {
                return Response.success(MockData.articleList);
            }

            @Override
            public void enqueue(Callback<List<Article>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Article>> clone() {
                return null;
            }
        };
    }

    @Override
    public Call<Article> getArticleById(final String articleId) {
        return new Call<Article>() {
            @Override
            public Response<Article> execute() throws IOException {
                for (Article a : MockData.articleList) {
                    if (a.getId().equals(articleId)) {
                        return Response.success(a);
                    }
                }

                return null;
            }

            @Override
            public void enqueue(Callback<Article> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Article> clone() {
                return null;
            }
        };
    }
}