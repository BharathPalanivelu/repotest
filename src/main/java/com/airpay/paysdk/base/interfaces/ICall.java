package com.airpay.paysdk.base.interfaces;

import com.airpay.paysdk.core.bean.PayResult;

public interface ICall {
    void onResponse(PayResult payResult);
}
