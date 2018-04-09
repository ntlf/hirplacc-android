package com.example.antalfarkas.hirplacc.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.antalfarkas.hirplacc.HirPlaccApplication;
import com.example.antalfarkas.hirplacc.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HirPlaccApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }
}
