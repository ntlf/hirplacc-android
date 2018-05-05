package com.example.antalfarkas.hirplacc;

import com.example.antalfarkas.hirplacc.database.DatabaseModule;
import com.example.antalfarkas.hirplacc.mock.MockDatabaseModule;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {
    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        HirPlaccApplication application = (HirPlaccApplication) RuntimeEnvironment.application;
        HirPlaccApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
    }
}
