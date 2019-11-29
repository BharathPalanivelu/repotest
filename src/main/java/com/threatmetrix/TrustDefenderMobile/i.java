package com.threatmetrix.TrustDefenderMobile;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import com.threatmetrix.TrustDefenderMobile.aa;
import java.util.Map;
import org.apache.http.HttpEntity;

class i implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final String f32579f = "com.threatmetrix.TrustDefenderMobile.i";

    /* renamed from: a  reason: collision with root package name */
    private final a f32580a;

    /* renamed from: b  reason: collision with root package name */
    final ad f32581b;

    /* renamed from: c  reason: collision with root package name */
    final String f32582c;

    /* renamed from: d  reason: collision with root package name */
    final h f32583d;

    /* renamed from: e  reason: collision with root package name */
    private final aa f32584e;

    enum a {
        GET,
        GET_CONSUME,
        POST,
        POST_CONSUME
    }

    public i(AndroidHttpClient androidHttpClient, a aVar, String str, h hVar, Map<String, String> map, aa aaVar) {
        this.f32581b = new ad(androidHttpClient);
        this.f32581b.a(map);
        this.f32580a = aVar;
        this.f32582c = str;
        this.f32583d = hVar;
        this.f32584e = aaVar;
    }

    public void run() {
        long j;
        String str = f32579f;
        Log.d(str, "starting retrieval: " + this.f32582c);
        if (this.f32580a == a.GET || this.f32580a == a.GET_CONSUME) {
            ad adVar = this.f32581b;
            j = adVar.a(this.f32582c + "?" + this.f32583d.a());
        } else if (this.f32580a == a.POST || this.f32580a == a.POST_CONSUME) {
            j = this.f32581b.a(this.f32582c, (HttpEntity) this.f32583d.b());
        } else {
            j = -1;
        }
        if (j < 0) {
            String str2 = f32579f;
            Log.w(str2, "failed to retrieve from " + this.f32581b.b());
            aa aaVar = this.f32584e;
            if (aaVar != null) {
                aaVar.a(this.f32581b.f());
                return;
            }
            return;
        }
        String str3 = f32579f;
        Log.d(str3, "retrieved: " + this.f32581b.a());
        if (j != 200) {
            String str4 = f32579f;
            Log.w(str4, "error (" + j + ") status on request to " + this.f32581b.b());
        } else if (this.f32580a == a.GET_CONSUME || this.f32580a == a.POST_CONSUME) {
            Log.d(f32579f, "consuming content");
            this.f32581b.e();
        }
    }

    public aa.b a() {
        return this.f32581b.f();
    }

    public int b() {
        if (this.f32581b.d() != null) {
            return this.f32581b.d().getStatusLine().getStatusCode();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ad c() {
        return this.f32581b;
    }

    public void d() {
        this.f32581b.c();
    }
}
