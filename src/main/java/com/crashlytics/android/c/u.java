package com.crashlytics.android.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class u {

    /* renamed from: a  reason: collision with root package name */
    private static final IntentFilter f6592a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b  reason: collision with root package name */
    private static final IntentFilter f6593b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    /* renamed from: c  reason: collision with root package name */
    private static final IntentFilter f6594c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f6595d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f6596e;

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f6597f;

    /* renamed from: g  reason: collision with root package name */
    private final BroadcastReceiver f6598g;
    /* access modifiers changed from: private */
    public boolean h;

    public u(Context context) {
        this.f6596e = context;
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, f6592a);
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        this.h = intExtra == 2 || intExtra == 5;
        this.f6598g = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                boolean unused = u.this.h = true;
            }
        };
        this.f6597f = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                boolean unused = u.this.h = false;
            }
        };
        context.registerReceiver(this.f6598g, f6593b);
        context.registerReceiver(this.f6597f, f6594c);
        this.f6595d = new AtomicBoolean(true);
    }

    public boolean a() {
        return this.h;
    }

    public void b() {
        if (this.f6595d.getAndSet(false)) {
            this.f6596e.unregisterReceiver(this.f6598g);
            this.f6596e.unregisterReceiver(this.f6597f);
        }
    }
}
