package com.garena.pay.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import com.beetalk.sdk.a.e;
import com.beetalk.sdk.data.c;
import com.beetalk.sdk.e.a;
import com.garena.d.a;
import com.garena.pay.android.b;

public class GGPayActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f8130b = (!GGPayActivity.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f8131a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f8132c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f8133d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f8134e;

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        new e().a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.b("GGPayActivity onCreate() start...", new Object[0]);
        this.f8133d = new Handler(Looper.getMainLooper());
        this.f8131a = new LinearLayout(this);
        this.f8131a.setOrientation(1);
        this.f8131a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f8131a.setId(a.d.main_layout);
        this.f8131a.setMinimumHeight(getWindowManager().getDefaultDisplay().getHeight());
        this.f8131a.setBackgroundColor(0);
        setContentView(this.f8131a);
        if (bundle != null) {
            this.f8134e = (b) bundle.getSerializable("com.garena.pay.android.extras.pay_client");
            this.f8132c = (c) bundle.getSerializable("com.garena.pay.android.extras.pay_request");
        } else {
            this.f8134e = new b();
            this.f8132c = (c) getIntent().getSerializableExtra("com.garena.pay.android.extras.pay_request");
        }
        c cVar = this.f8132c;
        if (cVar != null) {
            cVar.a((Activity) this);
        }
        if (f8130b || this.f8134e != null) {
            this.f8134e.a((Activity) this);
            this.f8134e.a((b.a) new b.a() {
                public void a(c cVar) {
                    com.beetalk.sdk.e.a.b("Recd result after payment completion: %s", cVar.b());
                    GGPayActivity.this.a(cVar);
                }
            });
            com.beetalk.sdk.e.a.b("GGPayActivity onCreate() end...", new Object[0]);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f8134e.a(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("com.garena.pay.android.extras.pay_client", this.f8134e);
        bundle.putSerializable("com.garena.pay.android.extras.pay_request", this.f8132c);
    }

    /* access modifiers changed from: private */
    public void a(c cVar) {
        this.f8132c = null;
        int i = c.a(cVar.a()) ? -1 : 0;
        Intent intent = new Intent();
        intent.putExtra("com.garena.pay.android.extras.result", cVar);
        setResult(i, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.beetalk.sdk.e.a.b("GGPayActivity onPause()", new Object[0]);
        com.beetalk.sdk.a.c.a().b();
    }

    public void onBackPressed() {
        this.f8134e.a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f8133d.postDelayed(new Runnable() {
            public void run() {
                if (GGPayActivity.this.f8134e != null) {
                    GGPayActivity.this.f8134e.a(GGPayActivity.this.f8132c);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f8134e;
        if (bVar != null) {
            bVar.c();
        }
    }
}
