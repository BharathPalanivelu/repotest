package io.a.a.a.a.b;

import android.os.SystemClock;
import android.util.Log;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private final String f33109a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33110b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33111c;

    /* renamed from: d  reason: collision with root package name */
    private long f33112d;

    /* renamed from: e  reason: collision with root package name */
    private long f33113e;

    public u(String str, String str2) {
        this.f33109a = str;
        this.f33110b = str2;
        this.f33111c = !Log.isLoggable(str2, 2);
    }

    public synchronized void a() {
        if (!this.f33111c) {
            this.f33112d = SystemClock.elapsedRealtime();
            this.f33113e = 0;
        }
    }

    public synchronized void b() {
        if (!this.f33111c) {
            if (this.f33113e == 0) {
                this.f33113e = SystemClock.elapsedRealtime() - this.f33112d;
                c();
            }
        }
    }

    private void c() {
        String str = this.f33110b;
        Log.v(str, this.f33109a + ": " + this.f33113e + "ms");
    }
}
