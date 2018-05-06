package com.example.antalfarkas.hirplacc.mock;

import com.example.antalfarkas.hirplacc.model.Article;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<Article> articleList = new ArrayList<Article>() {
        {
            add(new Article("one", "description", "imageUrl", "title", "sourceDomain", "text", "url"));
            add(new Article("two", "description", "imageUrl", "title", "sourceDomain", "text", "url"));
            add(new Article("three", "description", "imageUrl", "title", "sourceDomain", "text", "url"));
            add(new Article("four", "description", "imageUrl", "title", "sourceDomain", "text", "url"));
            add(new Article("five", "description", "imageUrl", "title", "sourceDomain", "text", "url"));
        }
    };
}
