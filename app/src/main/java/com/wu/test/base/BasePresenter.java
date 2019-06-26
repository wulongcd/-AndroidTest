package com.wu.test.base;

/**
 * Author:         wgl
 * CreateDate:     2019/6/24 11:40
 * Description:   Presenter基础接口
 * Version:        1.0
 */
public interface BasePresenter<T extends BaseView> {

//    /**
//     * description: attachView
//     * author: wgl
//     * time: 2019/6/24 11:42
//     * @param view
//     */
//    void attachView(T view);

    /**
     * description: attachView
     * author: wgl
     * time: 2019/6/24 11:42
     */
    void detachView();
}
