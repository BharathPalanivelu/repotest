package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class e implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f32568c = "e";

    /* renamed from: a  reason: collision with root package name */
    private String f32569a;

    /* renamed from: b  reason: collision with root package name */
    private InetAddress f32570b;

    public e(String str) {
        this.f32569a = str;
    }

    public void run() {
        try {
            Log.d(f32568c, "Starting DNS lookup");
            InetAddress byName = InetAddress.getByName(this.f32569a);
            Log.d(f32568c, "DNS lookup complete");
            a(byName);
        } catch (UnknownHostException unused) {
            Log.d(f32568c, "Failed DNS lookup");
        }
    }

    public synchronized void a(InetAddress inetAddress) {
        this.f32570b = inetAddress;
    }
}
