package com.wu.test.base;

import android.app.Activity;

import javax.inject.Inject;

public abstract class MvpActivity<T extends  BasePresenter> extends BaseActivity implements BaseView<T> {

    private boolean active;
    @Inject
    protected T presenter;

    @Override
    public void showMsg(String msg) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        active = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        active = false;
    }

    @Override
    public void setPresenter(T presenter) {

    }

    @Override
    public boolean isActive() {
        return active;
    }
}
