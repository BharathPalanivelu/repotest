package com.beetalk.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieSyncManager;
import com.beetalk.sdk.b;
import com.beetalk.sdk.e.a;

public class BTLoginActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f5365a = (!BTLoginActivity.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private String f5366b;

    /* renamed from: c  reason: collision with root package name */
    private b f5367c;

    /* renamed from: d  reason: collision with root package name */
    private b.a f5368d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CookieSyncManager.createInstance(this);
        a.b("BTLoginActivity onCreate", new Object[0]);
        if (bundle != null) {
            this.f5366b = bundle.getString("calling_package");
            this.f5367c = (b) bundle.getSerializable("saved_auth_client");
            a.b("BTLoginActivity onCreate, get authClient from savedInstanceState", new Object[0]);
        } else {
            this.f5367c = new b();
            this.f5366b = getCallingPackage();
            this.f5368d = (b.a) getIntent().getSerializableExtra("request_extra");
            a.b("BTLoginActivity onCreate, savedInstanceState is null, create authClient", new Object[0]);
        }
        if (f5365a || this.f5367c != null) {
            this.f5367c.a((Activity) this);
            this.f5367c.a((b.C0095b) new b.C0095b() {
                public void a(b.c cVar) {
                    BTLoginActivity.this.a(cVar);
                }
            });
            this.f5367c.a(this.f5368d);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void a(b.c cVar) {
        this.f5368d = null;
        int i = 0;
        if (cVar != null && !b.c.a(cVar.resultCode)) {
            i = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("auth_result", cVar);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(i, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f5367c.a(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("calling_package", this.f5366b);
        bundle.putSerializable("saved_auth_client", this.f5367c);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        if (this.f5366b == null) {
            a.a("Error Calling Package must be set", new Object[0]);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }
}
