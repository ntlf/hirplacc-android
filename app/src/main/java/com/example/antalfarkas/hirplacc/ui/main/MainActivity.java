package com.example.antalfarkas.hirplacc.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crashlytics.android.Crashlytics;
import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.R;
import com.example.antalfarkas.hirplacc.model.Article;
import com.example.antalfarkas.hirplacc.ui.detail.DetailActivity;
import com.example.antalfarkas.hirplacc.ui.main.adapter.ListAdapter;

import java.util.List;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements MainScreen, SwipeRefreshLayout.OnRefreshListener, ListAdapter.ClickListener {
    @Inject
    MainPresenter mainPresenter;

    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        HirPlaccApplication.injector.inject(this);

        mRecyclerView = findViewById(R.id.rvArticles);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ListAdapter();
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout = findViewById(R.id.swipeRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);

        mainPresenter.loadArticles();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void onRefresh() {
        mainPresenter.downloadNews();
    }

    @Override
    public void showArticles(final List<Article> articleList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.setDataset(articleList);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onClick(Article item) {
        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
        i.putExtra("id", item.getId());
        startActivity(i);
    }
}
