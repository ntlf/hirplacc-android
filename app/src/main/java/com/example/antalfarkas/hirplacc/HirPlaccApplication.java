package com.example.antalfarkas.hirplacc;

import android.app.Application;

import com.example.antalfarkas.hirplacc.database.DatabaseModule;
import com.example.antalfarkas.hirplacc.ui.UIModule;
import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class HirPlaccApplication extends Application {
    public static HirPlaccApplicationComponent injector;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate(){
        super.onCreate();
        sAnalytics = GoogleAnalytics.getInstance(this);
        sAnalytics.setLocalDispatchPeriod(15);
        injector = DaggerHirPlaccApplicationComponent.builder().uIModule(new UIModule(this)).databaseModule(new DatabaseModule(this)).build();
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
}