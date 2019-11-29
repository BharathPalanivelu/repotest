package com.shopee.app.network.http.data;

import com.google.a.a.c;

public class BaseResponse {
    @c(a = "error")
    public Integer errorCode = -1;
    @c(a = "error_msg")
    public String errorMsg;

    public boolean isSuccess() {
        Integer num = this.errorCode;
        return num == null || num.intValue() == 0;
    }
}
