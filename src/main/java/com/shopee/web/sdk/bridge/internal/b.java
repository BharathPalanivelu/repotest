package com.shopee.web.sdk.bridge.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

public abstract class b<Request, Response> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<WebView> f30477a;

    /* renamed from: b  reason: collision with root package name */
    private Context f30478b;

    /* renamed from: c  reason: collision with root package name */
    private Class<Request> f30479c;

    /* renamed from: d  reason: collision with root package name */
    private Class<Response> f30480d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30481e;

    /* renamed from: f  reason: collision with root package name */
    private d<Response> f30482f;

    /* renamed from: g  reason: collision with root package name */
    private c f30483g;

    public abstract String a();

    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    public void a(Activity activity, int i, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(Request request);

    public void b() {
    }

    public b(Context context, Class<Request> cls, Class<Response> cls2) {
        this.f30478b = context;
        this.f30479c = cls;
        this.f30480d = cls2;
    }

    public void a(WebView webView, c cVar) {
        this.f30477a = new WeakReference<>(webView);
        this.f30483g = cVar;
    }

    public void c() {
        this.f30481e = true;
    }

    public void d() {
        this.f30481e = false;
    }

    public void a(String str, Request request) {
        if (this.f30481e) {
            c cVar = this.f30483g;
            if (cVar != null) {
                this.f30482f = new d<>(str, cVar);
                a(request);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(Response response) {
        if (e() != null) {
            d<Response> dVar = this.f30482f;
            if (dVar != null) {
                dVar.a(response);
                this.f30482f = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public WebView e() {
        return (WebView) this.f30477a.get();
    }

    /* access modifiers changed from: protected */
    public Context f() {
        return this.f30478b;
    }

    /* access modifiers changed from: protected */
    public c g() {
        return this.f30483g;
    }

    public Class h() {
        return this.f30479c;
    }
}
