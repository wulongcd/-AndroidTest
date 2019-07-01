package com.wu.test.net.retrofit;

import android.text.TextUtils;

import com.wu.test.base.BaseView;

import java.net.SocketTimeoutException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

public abstract class CommonSubscriber extends ResourceSubscriber {
    private BaseView mBaseView;
    private boolean isHideLoading = false;

    public CommonSubscriber() {

    }

    public CommonSubscriber(BaseView mBaseView) {
        this.mBaseView = mBaseView;
    }

    public CommonSubscriber(BaseView mBaseView, boolean isHideLoading) {
        this.mBaseView = mBaseView;
        this.isHideLoading = isHideLoading;
    }

    @Override
    public void onComplete() {
        if (mBaseView != null && isHideLoading) {
            mBaseView.hideLoadingView();
        }
    }

    @Override
    public void onError(Throwable mThrowable) {
        if (mBaseView == null) {
            return;
        }
        if (isHideLoading) {
            mBaseView.hideLoadingView();
        }

        if (mThrowable instanceof ApiException) {
            if (!TextUtils.isEmpty(mThrowable.getMessage())) {
                mBaseView.showMsg(mThrowable.getMessage());
            }
        } else if (mThrowable instanceof HttpException) {
            mBaseView.showMsg("数据加载失败");
        } else if (mThrowable instanceof SocketTimeoutException) {
            mBaseView.showMsg("网络访问超时");
        } else {
            mThrowable.printStackTrace();
        }
    }

}
