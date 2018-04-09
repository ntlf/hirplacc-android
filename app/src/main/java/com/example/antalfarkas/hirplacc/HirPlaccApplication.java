package com.example.antalfarkas.hirplacc;

import android.app.Application;

import com.example.antalfarkas.hirplacc.ui.UIModule;

public class HirPlaccApplication extends Application {
    public static HirPlaccApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();
        injector = DaggerHirPlaccApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}