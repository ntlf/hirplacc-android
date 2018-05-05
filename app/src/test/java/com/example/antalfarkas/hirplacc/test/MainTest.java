package com.example.antalfarkas.hirplacc.test;

import com.example.antalfarkas.hirplacc.BuildConfig;
import com.example.antalfarkas.hirplacc.mock.MockData;
import com.example.antalfarkas.hirplacc.model.Article;
import com.example.antalfarkas.hirplacc.ui.main.MainPresenter;
import com.example.antalfarkas.hirplacc.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowLooper;

import java.util.List;

import static com.example.antalfarkas.hirplacc.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setup() {
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testArticlesCall() {
        mainPresenter.loadArticles();

        verify(mainScreen).showArticles(Mockito.<Article>anyList());
    }

    @Test
    public void testReturnsAll() {
        mainPresenter.loadArticles();

        ArgumentCaptor<List<Article>> articlesCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).showArticles(articlesCaptor.capture());

        assertTrue(articlesCaptor.getValue().equals(MockData.articleList));
    }

    @Test
    public void testDownloadCall() {
        mainPresenter.downloadNews();

        verify(mainScreen).showArticles(Mockito.<Article>anyList());
    }

    @Test
    public void testDownloadAll() {
        mainPresenter.downloadNews();

        ArgumentCaptor<List<Article>> articlesCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).showArticles(articlesCaptor.capture());

        assertTrue(articlesCaptor.getValue().equals(MockData.articleList));
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}