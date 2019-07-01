package com.wu.test.net.retrofit;

/**
  *
  * @Description: 自定义apiException
  * @Author:         wgl
  * CreateDate:   2019/07/01
  * Version:        1.0
 */
public class ApiException extends RuntimeException {
    private int code;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int mCode) {
        code = mCode;
    }
}
