package com.wu.test.ui.login;

import com.wu.test.base.CommonSubscriber;
import  com.wu.test.base.MvpPresenter;
import com.wu.test.entity.User;
import com.wu.test.net.retrofit.ApiService;
import com.wu.test.ui.contract.LoginContract;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends MvpPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private CompositeDisposable compositeDisposable;

    @Inject
    ApiService apiService;

    @Inject
    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getSms(String phone) {
        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(120)
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        view.setCountDownText(String.valueOf(Math.abs(aLong - 120)));
                    }

                    @Override
                    public void onError(Throwable t) {
                        view.setCountDownText("获取code");
                    }

                    @Override
                    public void onComplete() {
                        view.countDownComplete();
                    }
                });
        compositeDisposable.add(disposable);
//        apiService.
    }

    @Override
    public void login(String username, String pwd) {
        compositeDisposable.add(apiService.login(username, pwd).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CommonSubscriber<User>(view) {
                    @Override
                    public void onSuccess(User data) {

                    }
                }));
    }

    @Override
    public void detachView() {
        super.detachView();
        compositeDisposable.clear();
    }
}
