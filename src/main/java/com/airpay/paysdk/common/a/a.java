package com.airpay.paysdk.common.a;

import android.text.TextUtils;

public class a extends Throwable {
    private int mCode;
    private String mErrorMsg;

    public a(int i, Throwable th) {
        super(th);
        this.mCode = i;
        this.mErrorMsg = getMessage();
    }

    public a(int i, String str) {
        this.mCode = i;
        this.mErrorMsg = TextUtils.isEmpty(str) ? getMessage() : str;
    }

    public int a() {
        return this.mCode;
    }

    public String b() {
        return this.mErrorMsg;
    }
}
