package com.c.a.d;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.c.a.d.c;

class e implements c {

    /* renamed from: a  reason: collision with root package name */
    final c.a f6124a;

    /* renamed from: b  reason: collision with root package name */
    boolean f6125b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6126c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6127d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f6128e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.f6125b;
            e eVar = e.this;
            eVar.f6125b = eVar.a(context);
            if (z != e.this.f6125b) {
                e.this.f6124a.a(e.this.f6125b);
            }
        }
    };

    public void e() {
    }

    public e(Context context, c.a aVar) {
        this.f6126c = context.getApplicationContext();
        this.f6124a = aVar;
    }

    private void a() {
        if (!this.f6127d) {
            this.f6125b = a(this.f6126c);
            this.f6126c.registerReceiver(this.f6128e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f6127d = true;
        }
    }

    private void b() {
        if (this.f6127d) {
            this.f6126c.unregisterReceiver(this.f6128e);
            this.f6127d = false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void c() {
        a();
    }

    public void d() {
        b();
    }
}
