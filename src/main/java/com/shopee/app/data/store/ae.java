package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class ae extends ad {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f17168a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f17169b;

    /* renamed from: c  reason: collision with root package name */
    private b f17170c;

    private ae(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f17168a = sharedPreferences;
        this.f17169b = aVar;
        this.f17170c = bVar;
    }

    public synchronized void a(boolean z) {
        this.f17168a.edit().putBoolean("show_network_log", z).apply();
    }

    public synchronized boolean a() {
        return this.f17168a.getBoolean("show_network_log", false);
    }

    public synchronized void b(boolean z) {
        this.f17168a.edit().putBoolean("enable_network_interceptor", z).apply();
    }

    public synchronized boolean b() {
        return this.f17168a.getBoolean("enable_network_interceptor", false);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f17171a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f17172b;

        /* renamed from: c  reason: collision with root package name */
        private b f17173c;

        public a(Context context) {
            this.f17171a = context.getSharedPreferences("forbidden_zone_store", 0);
        }

        public ae a() {
            return new ae(this.f17171a, this.f17173c, this.f17172b);
        }
    }
}
