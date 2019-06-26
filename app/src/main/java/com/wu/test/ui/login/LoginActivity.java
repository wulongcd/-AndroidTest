package com.wu.test.ui.login;

import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wu.test.R;
import com.wu.test.base.MvpActivity;
import com.wu.test.ui.contract.LoginContract;
import com.wu.test.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends MvpActivity<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.et_phone)
    AppCompatEditText etPhone;
    @BindView(R.id.et_code)
    AppCompatEditText etCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.tv_protocol)
    TextView tvProtocol;

    @Override
    public void setCountDownText(String text) {
        tvGetCode.setText(text);
    }

    @Override
    public void countDownComplete() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.tv_get_code, R.id.btn_login, R.id.tv_protocol})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_code:
                String phone = etPhone.getText().toString().trim();
                presenter.getSms(phone);
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_protocol:
                break;
        }
    }

    private void login() {
        String phone = etPhone.getText().toString().trim();
        String pwd = etCode.getText().toString().trim();
        if (!validUserNameAndPwd(phone, pwd)) {
            return;
        }
        presenter.login(phone, pwd);
    }

    private boolean validUserNameAndPwd(String phone, String pwd) {
        if (validPhone(phone) && validPwd(pwd)) {
            return true;
        }
        return false;
    }

    private boolean validPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showShort(R.string.phone_is_null);
            return false;
        }
        if (phone.length() < 11) {
            ToastUtils.showShort(R.string.phone_is_valid);
            return false;
        }
        return true;
    }

    private boolean validPwd(String name) {
        if (TextUtils.isEmpty(name)) {
            ToastUtils.showShort(R.string.pwd_is_null);
            return false;
        }
        if (name.length() < 4) {
            ToastUtils.showShort(R.string.pwd_is_valid);
            return false;
        }
        return true;
    }
}
