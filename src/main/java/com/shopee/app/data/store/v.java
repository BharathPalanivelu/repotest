package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f6950a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f6951b;

    /* renamed from: c  reason: collision with root package name */
    private b f6952c;

    private v(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f6950a = sharedPreferences;
        this.f6951b = aVar;
        this.f6952c = bVar;
    }

    public synchronized void a(String str) {
        this.f6950a.edit().putString("lastUserPW", str).apply();
    }

    public synchronized String b() {
        return this.f6950a.getString("lastUserPW", "");
    }

    public synchronized void b(String str) {
        this.f6950a.edit().putString("lastUserFBToken", str).apply();
    }

    public synchronized String c() {
        return this.f6950a.getString("lastUserFBToken", "");
    }

    public synchronized void c(String str) {
        this.f6950a.edit().putString("lastUserBeetalkToken", str).apply();
    }

    public synchronized String d() {
        return this.f6950a.getString("lastUserBeetalkToken", "");
    }

    public synchronized void a(int i) {
        this.f6950a.edit().putInt("lastUserId", i).apply();
    }

    public synchronized int e() {
        return this.f6950a.getInt("lastUserId", 0);
    }

    public synchronized void a(boolean z) {
        this.f6950a.edit().putBoolean("notificationSoundOn", z).apply();
    }

    public synchronized boolean f() {
        return this.f6950a.getBoolean("notificationSoundOn", true);
    }

    public synchronized void d(String str) {
        this.f6950a.edit().putString("notificationSoundId", str).apply();
    }

    public synchronized String g() {
        return this.f6950a.getString("notificationSoundId", "SOUND_DEFAULT");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f17329a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f17330b;

        /* renamed from: c  reason: collision with root package name */
        private b f17331c;

        public a(Context context) {
            this.f17329a = context.getSharedPreferences("crossUserStatusStore", 0);
        }

        public v a() {
            return new v(this.f17329a, this.f17331c, this.f17330b);
        }
    }
}
