package com.wu.test.ui.login;

import com.wu.test.RxJavaTestSchedulerRule;
import com.wu.test.net.ApiService;
import com.wu.test.ui.contract.LoginContract;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
//@Config(sdk = 23)
public class LoginPresenterTest {
    @Mock
    LoginContract.View view;
    @Mock
    ApiService apiService;

    @Rule
    public RxJavaTestSchedulerRule rule = new RxJavaTestSchedulerRule();

    LoginPresenter presenter;
    LoginPresenter mockPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockPresenter = new LoginPresenter(view);
        when(view.isActive()).thenReturn(true);
    }

    @Test
    public void testGetSms() {
        String phone = "123";
        mockPresenter.getSms(phone);
        rule.getTestScheduler().advanceTimeTo(120, TimeUnit.SECONDS);
        verify(view, times(120)).setCountDownText(anyString());
        verify(view).countDownComplete();
    }

    @Test
    public void testGetSms_Mock_Error() {

    }

    @Test
    public void testLogin_Mock_Error() {
//        when(apiService)
        String phone = "15196638744";
    }
}