package com.shopee.arcatch.data.network_bean;

import com.litesuits.orm.db.assit.SQLBuilder;
import f.b;
import f.d;
import f.m;
import java.net.SocketTimeoutException;

public abstract class CommonCallback<T> implements d<CommonBean<T>> {
    private static final int TOTAL_RETRIES = 2;
    private b<CommonBean<T>> call;
    private int retryCount = 0;

    public abstract void onFail(int i, String str);

    public abstract void onSuccess(CommonBean<T> commonBean);

    private void onResponseFail(int i, String str, boolean z) {
        if (z) {
            int i2 = this.retryCount;
            this.retryCount = i2 + 1;
            if (i2 < 2 && this.call != null) {
                retry();
                return;
            }
        }
        onFail(i, str);
    }

    private void retry() {
        this.call.d().a(this);
    }

    public void setCall(b<CommonBean<T>> bVar) {
        this.call = bVar;
    }

    public void onResponse(b<CommonBean<T>> bVar, m<CommonBean<T>> mVar) {
        if (mVar == null) {
            onResponseFail(-1, "response is null", false);
            return;
        }
        int a2 = mVar.a();
        if (a2 == 200) {
            CommonBean e2 = mVar.e();
            if (e2 == null) {
                onResponseFail(-2, "response data is null", false);
                return;
            }
            int errCode = e2.getErrCode();
            String errMsg = e2.getErrMsg();
            if (errCode != 0) {
                onResponseFail(errCode, errMsg, false);
            } else {
                onSuccess(e2);
            }
        } else if (a2 == 400) {
            onResponseFail(-400, "request params error(response code 400)", false);
        } else if (a2 != 503) {
            onResponseFail(-100, "unknown error(response code " + a2 + SQLBuilder.PARENTHESES_RIGHT, false);
        } else {
            onResponseFail(-503, "server error for dependency unavailable(response code 503)", true);
        }
    }

    public void onFailure(b<CommonBean<T>> bVar, Throwable th) {
        if (th instanceof SocketTimeoutException) {
            onResponseFail(-2, th.getMessage(), true);
        } else {
            onResponseFail(-2, th.getMessage(), false);
        }
    }
}
