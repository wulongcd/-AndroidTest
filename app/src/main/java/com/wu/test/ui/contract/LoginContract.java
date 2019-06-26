package com.wu.test.ui.contract;

import com.wu.test.base.BasePresenter;
import com.wu.test.base.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void setCountDownText(String text);
        void countDownComplete();
        void loginSuccess();
    }

    interface Presenter extends BasePresenter {
        void getSms(String phone);
        void login(String username, String pwd);
    }

}
