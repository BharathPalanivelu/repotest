package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class ac extends ab {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f17162a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f17163b;

    /* renamed from: c  reason: collision with root package name */
    private b f17164c;

    private ac(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f17162a = sharedPreferences;
        this.f17163b = aVar;
        this.f17164c = bVar;
    }

    public synchronized void a(String str) {
        this.f17162a.edit().putString("Data", str).apply();
    }

    public synchronized String a() {
        return this.f17162a.getString("Data", "");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f17165a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f17166b;

        /* renamed from: c  reason: collision with root package name */
        private b f17167c;

        public a(SharedPreferences sharedPreferences) {
            this.f17165a = sharedPreferences;
        }

        public ac a() {
            return new ac(this.f17165a, this.f17167c, this.f17166b);
        }
    }
}
