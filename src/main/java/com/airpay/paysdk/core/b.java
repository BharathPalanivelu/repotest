package com.airpay.paysdk.core;

import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.airpay.paysdk.core.bean.Param;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Param f4100a;

    private b(a aVar) {
        if (!TextUtils.isEmpty(aVar.f4101a)) {
            this.f4100a = new Param(aVar.f4101a, aVar.f4102b);
            return;
        }
        throw new AndroidRuntimeException("the language can't be null. the language value ref @com.airpay.paysdk.base.constants.Constants.Language.");
    }

    public Param a() {
        return this.f4100a;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f4101a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4102b;

        public a a(String str) {
            this.f4101a = str;
            return this;
        }

        public a b(String str) {
            this.f4102b = str;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
