package com.wu.test.base;


import com.wu.test.entity.response.Response;
import com.wu.test.net.Constants;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created on 2018/9/24.
 */
public abstract class CommonSubscriber<T> extends ResourceSubscriber<Response<T>> {

    private BaseView mView;

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(Response<T> tResponse) {
        if (tResponse.getCode() == Constants.STATUS_SUCCESS_1
                || tResponse.getCode() == Constants.STATUS_SUCCESS_2
                || tResponse.getCode() == Constants.STATUS_SUCCESS_3) {
            onSuccess(tResponse.getData());
        } else if (tResponse.getCode() == Constants.STATUS_LOGIN_MUTI) {
//            EventBus.getDefault().post(new CommonBean(REFRESH_TOKEN));
        } else {
//            mView.showErrorMsg(tResponse.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (mView == null) {
            return;
        }
        if (e instanceof HttpException) {
//            mView.showErrorMsg("数据加载失败，请检查网络设置");
        } else {
//            mView.showErrorMsg("网络连接异常，请检查网络设置");
        }
//        if (isShowErrorState) {
//            mView.stateError();
//        }
    }

    public abstract void onSuccess(T data);
}
