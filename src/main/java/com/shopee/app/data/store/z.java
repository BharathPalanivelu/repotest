package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class z extends y {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f17336a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f17337b;

    /* renamed from: c  reason: collision with root package name */
    private b f17338c;

    private z(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f17336a = sharedPreferences;
        this.f17337b = aVar;
        this.f17338c = bVar;
    }

    public synchronized void a(long j) {
        this.f17336a.edit().putLong("last_device_info_HF_ts", j).apply();
    }

    public synchronized long a() {
        return this.f17336a.getLong("last_device_info_HF_ts", 0);
    }

    public synchronized void b(long j) {
        this.f17336a.edit().putLong("last_device_info_MF_ts", j).apply();
    }

    public synchronized long b() {
        return this.f17336a.getLong("last_device_info_MF_ts", 0);
    }

    public synchronized void c(long j) {
        this.f17336a.edit().putLong("last_device_info_LF_ts", j).apply();
    }

    public synchronized long c() {
        return this.f17336a.getLong("last_device_info_LF_ts", 0);
    }

    public synchronized void d(long j) {
        this.f17336a.edit().putLong("last_installed_apps_ts", j).apply();
    }

    public synchronized long d() {
        return this.f17336a.getLong("last_installed_apps_ts", 0);
    }

    public synchronized void a(String str) {
        this.f17336a.edit().putString("last_device_info_MF_json", str).apply();
    }

    public synchronized String e() {
        return this.f17336a.getString("last_device_info_MF_json", "");
    }

    public synchronized void b(String str) {
        this.f17336a.edit().putString("last_device_info_LF_json", str).apply();
    }

    public synchronized String f() {
        return this.f17336a.getString("last_device_info_LF_json", "");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f17339a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f17340b;

        /* renamed from: c  reason: collision with root package name */
        private b f17341c;

        public a(Context context) {
            this.f17339a = context.getSharedPreferences("data_point_store", 0);
        }

        public z a() {
            return new z(this.f17339a, this.f17341c, this.f17340b);
        }
    }
}
