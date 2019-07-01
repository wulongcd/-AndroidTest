package com.wu.test.net.retrofit;

public interface Constants {

    int STATUS_SUCCESS_1 = 200;
    int STATUS_SUCCESS_2 = 201;
    int STATUS_SUCCESS_3 = 204;
    int STATUS_SUCCESS_4 = 203;//状态错误，主要用于假订单数据的处理
    int STATUS_LOGIN_MUTI = 401;//token过期，除登录接口外需要刷新token
}
