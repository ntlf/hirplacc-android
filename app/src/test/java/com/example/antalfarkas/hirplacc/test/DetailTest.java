package com.example.antalfarkas.hirplacc.test;


import com.example.antalfarkas.hirplacc.BuildConfig;
import com.example.antalfarkas.hirplacc.mock.MockData;
import com.example.antalfarkas.hirplacc.model.Article;
import com.example.antalfarkas.hirplacc.ui.detail.DetailPresenter;
import com.example.antalfarkas.hirplacc.ui.detail.DetailScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.antalfarkas.hirplacc.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DetailTest {
    private DetailPresenter detailPresenter;
    private DetailScreen detailScreen;

    @Before
    public void setup() {
        setTestInjector();
        detailScreen = mock(DetailScreen.class);
        detailPresenter = new DetailPresenter();
        detailPresenter.attachScreen(detailScreen);
    }

    @Test
    public void testArticleCall() {
        Article loadArticle = MockData.articleList.get(0);
        detailPresenter.loadArticle(loadArticle.getId());

        verify(detailScreen).showArticle(Mockito.any(Article.class));
    }

    @Test
    public void testMatchId() {
        Article loadArticle = MockData.articleList.get(0);
        detailPresenter.loadArticle(loadArticle.getId());

        ArgumentCaptor<Article> articleCaptor = ArgumentCaptor.forClass(Article.class);
        verify(detailScreen).showArticle(articleCaptor.capture());

        assertTrue(articleCaptor.getValue().getId().equals(loadArticle.getId()));
    }

    @After
    public void tearDown() {
        detailPresenter.detachScreen();
    }

}