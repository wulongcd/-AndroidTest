package com.wu.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wu.test.utils.ToastUtils;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    /**
     * description:返回布局资源id
     * @return int 布局资源id
     * author: wgl
     * time: 2019/6/24 17:25
     */
    public abstract int getLayoutId();

    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }
}
