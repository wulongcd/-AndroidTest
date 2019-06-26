/**
 * Author:         wgl
 * CreateDate:     2019/6/24 11:49
 * Description:   基础Rxpresenter
 * Version:        1.0
 */
package com.wu.test.base;

import java.lang.ref.WeakReference;

/**
 * Author:         wgl
 * CreateDate:     2019/6/24 11:49
 * Description:   基础Rxpresenter
 * Version:        1.0
 */
public class MvpPresenter<T extends BaseView> implements BasePresenter<T> {

    private WeakReference<T> weakReference;
    protected T mView;


    @Override
    public void detachView() {
        if(weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public T getmView() {
        return weakReference.get();
    }

    public boolean isViewAttached() {
        return  weakReference != null && weakReference.get() != null;
    }

}
