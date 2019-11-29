package com.shopee.app.network.http.data.kredit;

import com.google.a.a.c;
import com.shopee.app.network.http.data.BaseResponse;

public class CreditStatusResponse extends BaseResponse {
    @c(a = "data")
    public CreditData data;
    @c(a = "error_code")
    public int detailErrorCode;
}
