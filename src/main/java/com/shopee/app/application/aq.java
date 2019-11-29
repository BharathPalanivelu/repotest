package com.shopee.app.application;

import android.content.Context;
import com.garena.f.d;
import com.shopee.app.network.e;
import okhttp3.OkHttpClient;

public class aq implements ao {

    /* renamed from: a  reason: collision with root package name */
    private ap f6918a;

    public void a(ar arVar) {
        this.f6918a = new ap();
    }

    public OkHttpClient a(boolean z, boolean z2, Context context) {
        return this.f6918a.a(context).build();
    }

    public OkHttpClient a(boolean z, boolean z2, boolean z3) {
        return this.f6918a.a(z3).build();
    }

    public d a(boolean z, e eVar) {
        return this.f6918a.a(eVar).a();
    }
}
