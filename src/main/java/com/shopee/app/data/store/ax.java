package com.shopee.app.data.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.garena.android.appkit.b;

public final class ax extends aw {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f17203a;

    /* renamed from: b  reason: collision with root package name */
    private com.garena.android.appkit.a f17204b;

    /* renamed from: c  reason: collision with root package name */
    private b f17205c;

    private ax(SharedPreferences sharedPreferences, b bVar, com.garena.android.appkit.a aVar) {
        this.f17203a = sharedPreferences;
        this.f17204b = aVar;
        this.f17205c = bVar;
    }

    public synchronized void a(boolean z) {
        this.f17203a.edit().putBoolean("Tracked", z).apply();
    }

    public synchronized boolean a() {
        return this.f17203a.getBoolean("Tracked", false);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f17206a;

        /* renamed from: b  reason: collision with root package name */
        private com.garena.android.appkit.a f17207b;

        /* renamed from: c  reason: collision with root package name */
        private b f17208c;

        public a(Context context) {
            this.f17206a = context.getSharedPreferences("PlayServiceCheck", 0);
        }

        public ax a() {
            return new ax(this.f17206a, this.f17208c, this.f17207b);
        }
    }
}
