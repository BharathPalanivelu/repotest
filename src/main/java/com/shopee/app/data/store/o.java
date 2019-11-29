package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class o extends n {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f17318a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f17319b;

    /* renamed from: c  reason: collision with root package name */
    private b f17320c;

    private o(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f17318a = sharedPreferences;
        this.f17319b = aVar;
        this.f17320c = bVar;
    }

    public synchronized void a(int i) {
        this.f17318a.edit().putInt("fromNewToOldLastTimestamp", i).apply();
    }

    public synchronized int b() {
        return this.f17318a.getInt("fromNewToOldLastTimestamp", 0);
    }

    public synchronized void a(boolean z) {
        this.f17318a.edit().putBoolean("fromNewToOldDone", z).apply();
    }

    public synchronized boolean a() {
        return this.f17318a.getBoolean("fromNewToOldDone", false);
    }

    public synchronized void b(int i) {
        this.f17318a.edit().putInt("fromOldToNewLastTimestamp", i).apply();
    }

    public synchronized int e() {
        return this.f17318a.getInt("fromOldToNewLastTimestamp", 0);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f17321a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f17322b;

        /* renamed from: c  reason: collision with root package name */
        private b f17323c;

        public a(Context context) {
            this.f17321a = context.getSharedPreferences("chat_load_status", 0);
        }

        public o a() {
            return new o(this.f17321a, this.f17323c, this.f17322b);
        }
    }
}
