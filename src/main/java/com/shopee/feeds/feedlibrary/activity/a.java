package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.c;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.sdk.modules.ui.a.a;
import com.shopee.sdk.modules.ui.navigator.a.b;

public abstract class a extends c implements com.shopee.sdk.modules.ui.navigator.a.a, b {

    /* renamed from: a  reason: collision with root package name */
    public Context f7086a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7087b = true;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.b.a f7088c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.navigator.b f7089d;

    public void a(int i, String str, o oVar) {
    }

    public void c() {
    }

    public void d() {
    }

    public abstract boolean e();

    public void f() {
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7088c = com.shopee.sdk.b.a().f();
        this.f7089d = com.shopee.sdk.b.a().e();
        this.f7088c.a(this);
        setRequestedOrientation(1);
        this.f7086a = this;
    }

    /* access modifiers changed from: protected */
    public o b() {
        return com.shopee.sdk.modules.ui.navigator.a.a(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f7088c.b(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f7088c.c(this);
        if (e()) {
            f();
        }
        this.f7087b = false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f7088c.d(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f7088c.e(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f7088c.f(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f7089d.a((Activity) this, i, i2, intent);
    }

    public String a() {
        return getClass().getSimpleName();
    }

    public void a(String str) {
        com.shopee.sdk.b.a().c().a(this, new a.C0472a().c(com.garena.android.appkit.tools.b.e(c.g.feeds_button_discard)).d(com.garena.android.appkit.tools.b.e(c.g.feeds_button_cancel)).b(str).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                if (num.intValue() == 1) {
                    a.this.d();
                    a.this.finish();
                }
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !g()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
}
