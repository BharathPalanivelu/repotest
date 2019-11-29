package com.shopee.live.livestreaming.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.a;
import androidx.fragment.app.FragmentActivity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shopee.live.livestreaming.a.h;
import com.shopee.live.livestreaming.util.t;
import com.shopee.sdk.modules.ui.navigator.a.interfaceB;

public abstract class VeryBaseLiveStreamingActivity extends FragmentActivity
        implements androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, com.shopee.sdk.modules.ui.navigator.a.interfaceA, interfaceB {

    /* renamed from: a  reason: collision with root package name */
    public Context f28744a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.b.a f28745b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.navigator.b f28746c;

    /* renamed from: d  reason: collision with root package name */
    private h f28747d;

    /* access modifiers changed from: protected */
    public boolean D_() {
        return false;
    }

    public void a(int i, String str, JsonObject oVar) {
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f28745b = com.shopee.sdk.b.a().f();
        this.f28746c = com.shopee.sdk.b.a().e();
        this.f28745b.a(this);
        setRequestedOrientation(1);
        getWindow().addFlags(128);
        this.f28744a = this;
        this.f28747d = new h(getApplication());
        this.f28747d.a((h.a) new h.a() {
            public void a() {
                VeryBaseLiveStreamingActivity.this.e();
            }

            public void b() {
                VeryBaseLiveStreamingActivity.this.f();
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        t.a().a(this, i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public JsonObject A_() {
        return com.shopee.sdk.modules.ui.navigator.ExtractIntent.a(getIntent());
    }

    public com.shopee.sdk.modules.ui.navigator.b C_() {
        return this.f28746c;
    }

    /* access modifiers changed from: protected */
    public <T> T a(Class<T> cls) {
        return com.shopee.sdk.f.a.f30357a.fromJson((JsonElement) A_(), cls);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f28745b.b(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f28745b.c(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f28745b.d(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f28745b.e(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f28745b.f(this);
        this.f28747d.a();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f28746c.a((Activity) this, i, i2, intent);
    }

    public String a() {
        return getClass().getSimpleName();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !D_()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public <T extends View> T a(int i) {
        return findViewById(i);
    }
}
