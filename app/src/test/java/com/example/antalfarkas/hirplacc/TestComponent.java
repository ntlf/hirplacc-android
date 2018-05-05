package com.example.antalfarkas.hirplacc;

import com.example.antalfarkas.hirplacc.interactor.InteractorModule;
import com.example.antalfarkas.hirplacc.mock.MockDatabaseModule;
import com.example.antalfarkas.hirplacc.mock.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, MockDatabaseModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends HirPlaccApplicationComponent {
}