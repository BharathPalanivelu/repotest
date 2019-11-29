package com.shopee.livequiz.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.a.l;
import com.google.a.o;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;
import com.shopee.sdk.modules.ui.navigator.a.b;

public abstract class a extends Activity implements com.shopee.sdk.modules.ui.navigator.a.a, b {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.b.a f29671a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.navigator.b f29672b;

    public void a(int i, String str, o oVar) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29671a = com.shopee.sdk.b.a().f();
        this.f29672b = com.shopee.sdk.b.a().e();
        this.f29671a.a(this);
        int i = Build.VERSION.SDK_INT;
        getWindow().setFlags(128, 128);
        f.a();
    }

    /* access modifiers changed from: protected */
    public o b() {
        return com.shopee.sdk.modules.ui.navigator.a.a(getIntent());
    }

    public com.shopee.sdk.modules.ui.navigator.b c() {
        return this.f29672b;
    }

    /* access modifiers changed from: protected */
    public <T> T a(Class<T> cls) {
        return new com.google.a.f().a((l) b(), cls);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f29671a.b(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f29671a.c(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f29671a.d(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f29671a.e(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f29671a.f(this);
        new e() {
            public void a() throws Exception {
                f.b();
            }
        }.b().run();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f29672b.a((Activity) this, i, i2, intent);
    }

    public String a() {
        return getClass().getSimpleName();
    }
}
