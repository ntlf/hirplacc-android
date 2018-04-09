package com.example.antalfarkas.hirplacc.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.R;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailScreen {

    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        HirPlaccApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailPresenter.detachScreen();
    }
}
