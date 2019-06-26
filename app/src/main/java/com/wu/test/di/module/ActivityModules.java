package com.wu.test.di.module;

import com.wu.test.ui.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModules {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract LoginActivity contributeMainActivity();
}
