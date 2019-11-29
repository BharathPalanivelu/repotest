package com.shopee.react.sdk.bridge.protocol;

import android.text.TextUtils;
import com.google.a.o;
import com.shopee.navigator.a;

public class PopData {
    private int count;
    private String data;

    public int getCount() {
        return this.count;
    }

    public String getData() {
        return this.data;
    }

    public o getDataAsJson() {
        if (TextUtils.isEmpty(this.data)) {
            return new o();
        }
        return a.f30103b.a(this.data).m();
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setData(String str) {
        this.data = str;
    }
}
