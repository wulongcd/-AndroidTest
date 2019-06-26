/**
 * Description: MainActivityModule
 * Author: Administrator
 * Date: 2019/6/19 11:19
 * Version: 1.0
 */
package com.wu.test.di.module;

import com.wu.test.ui.contract.LoginContract;
import com.wu.test.ui.login.LoginActivity;
import com.wu.test.ui.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Description: MainActivityModule
 * Author: wgl
 * Date: 2019/6/19 11:19
 * Version: 1.0
 */
@Module
public abstract class MainModule {

    @Provides
    public static String provideName() {
        return LoginActivity.class.getName();
    }

    @Provides
    public static LoginContract.View provideView(LoginActivity view) {
        return view;
    }

    @Binds
    abstract LoginContract.Presenter dishesPresenter(LoginPresenter presenter);

}