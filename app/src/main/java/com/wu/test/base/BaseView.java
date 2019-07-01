package com.wu.test.base;

public interface BaseView<T> {

    /**
     * description: 显示字符串
     * author: wgl
     * time: 2019/6/24 11:36
     * @param msg 要显示的字符串
     */
    void showMsg(String msg);

    void hideLoadingView();

    void setPresenter(T presenter);

    boolean isActive();
}
