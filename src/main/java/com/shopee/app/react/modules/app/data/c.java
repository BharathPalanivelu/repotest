package com.shopee.app.react.modules.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f6978a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f6979b;

    /* renamed from: c  reason: collision with root package name */
    private b f6980c;

    private c(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f6978a = sharedPreferences;
        this.f6979b = aVar;
        this.f6980c = bVar;
    }

    public synchronized void a(String str) {
        this.f6978a.edit().putString("attributionData", str).apply();
    }

    public synchronized String a() {
        return this.f6978a.getString("attributionData", "");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f18744a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f18745b;

        /* renamed from: c  reason: collision with root package name */
        private b f18746c;

        public a(Context context) {
            this.f18744a = context.getSharedPreferences("AppsFlyer", 0);
        }

        public c a() {
            return new c(this.f18744a, this.f18746c, this.f18745b);
        }
    }
}
