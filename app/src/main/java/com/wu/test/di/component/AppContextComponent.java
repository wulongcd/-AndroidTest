/**
 * Description: ApplicationCompanent
 * Author: wgl
 * Date: 2019/6/19 11:24
 * Version: 1.0
 */
package com.wu.test.di.component;

import com.wu.test.base.AppContext;
import com.wu.test.di.module.ActivityModules;
import com.wu.test.net.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Description: ApplicationCompanent
 * Author: wgl
 * Date: 2019/6/19 11:24
 * Version: 1.0
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityModules.class, ApiModule.class, AndroidSupportInjectionModule.class })
public interface AppContextComponent extends AndroidInjector<AppContext> {
    @Override
    void inject(AppContext application);
}