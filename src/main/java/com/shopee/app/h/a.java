package com.shopee.app.h;

import android.content.SharedPreferences;
import com.shopee.app.application.ar;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected SharedPreferences f17578a;

    /* access modifiers changed from: protected */
    public String b() {
        return "";
    }

    public void a() {
        if (this.f17578a == null) {
            this.f17578a = ar.a().getApplicationContext().getSharedPreferences(b(), 0);
        }
    }
}
