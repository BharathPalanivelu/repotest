package com.shopee.app.d.c.g;

import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.shopee.app.d.c.a;
import com.shopee.app.util.n;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f17037c;

    /* renamed from: d  reason: collision with root package name */
    private String f17038d;

    /* access modifiers changed from: protected */
    public String d() {
        return "HttpGetInteractor";
    }

    public d(n nVar) {
        super(nVar);
        this.f17037c = nVar;
    }

    public void a(String str) {
        this.f17038d = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        try {
            this.f17037c.a("HTTP_RESPONSE", new com.garena.android.appkit.b.a(FirebasePerfHttpClient.execute(new DefaultHttpClient(), new HttpGet(this.f17038d))));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
