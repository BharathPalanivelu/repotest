package com.shopee.react.sdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.a.o;
import com.shopee.navigator.b.a;
import com.shopee.react.sdk.activity.a.b;
import com.shopee.react.sdk.bridge.modules.base.d;
import java.util.HashMap;

public class ReactActivity extends Activity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity, a<b>, a, com.shopee.react.sdk.activity.a.a {

    /* renamed from: a  reason: collision with root package name */
    private ReactRootView f30146a;

    /* renamed from: b  reason: collision with root package name */
    private ReactInstanceManager f30147b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, d> f30148c;

    /* renamed from: d  reason: collision with root package name */
    private d f30149d;

    /* renamed from: e  reason: collision with root package name */
    private b f30150e;

    /* renamed from: f  reason: collision with root package name */
    private b f30151f;

    /* renamed from: g  reason: collision with root package name */
    private b f30152g;
    private boolean h = false;

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f30148c = new HashMap<>();
        this.f30147b = com.shopee.react.sdk.b.a().b();
        this.f30149d = new d(this, this.f30147b);
        this.f30150e = new b(this, "viewWillAppear");
        this.f30151f = new b(this, "viewWillReappear");
        this.f30152g = new b(this, "viewDidDisappear");
        setContentView(this.f30149d);
        e();
    }

    private void e() {
        b d2 = d();
        Bundle bundle = new Bundle();
        bundle.putString("propsEvent", "");
        bundle.putString("propsString", d2.b());
        this.f30146a = new c(this);
        this.f30146a.startReactApplication(this.f30147b, d2.a(), bundle);
        this.f30149d.addView(this.f30146a);
        this.f30149d.a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ReactInstanceManager reactInstanceManager = this.f30147b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostResume(this);
            a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f30147b != null) {
            a(false);
            this.f30147b.onHostPause(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ReactRootView reactRootView = this.f30146a;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
            this.f30146a = null;
        }
        this.f30150e.a();
        this.f30151f.a();
        this.f30152g.a();
        ReactInstanceManager reactInstanceManager = this.f30147b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostDestroy(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ReactInstanceManager reactInstanceManager = this.f30147b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onActivityResult(this, i, i2, intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            ReactInstanceManager reactInstanceManager = this.f30147b;
            if (reactInstanceManager != null) {
                reactInstanceManager.showDevOptionsDialog();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public void onBackPressed() {
        ReactInstanceManager reactInstanceManager = this.f30147b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onBackPressed();
        } else {
            invokeDefaultOnBackPressed();
        }
    }

    public void onNewIntent(Intent intent) {
        ReactInstanceManager reactInstanceManager = this.f30147b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    public void a(String str, d dVar) {
        this.f30148c.put(str, dVar);
    }

    public d b(String str) {
        return this.f30148c.get(str);
    }

    public ReactContext b() {
        return this.f30147b.getCurrentReactContext();
    }

    public int getReactTag() {
        return this.f30146a.getRootViewTag();
    }

    public View c() {
        return this.f30146a;
    }

    public String a() {
        return d().a();
    }

    public void a(int i, String str, o oVar) {
        this.f30151f.a(oVar.toString());
    }

    public b d() {
        return (b) com.shopee.navigator.d.a(getIntent(), b.class);
    }

    private void a(boolean z) {
        if (c() == null) {
            return;
        }
        if (!z) {
            c().post(this.f30152g);
        } else if (!this.h) {
            c().post(this.f30150e);
            this.h = true;
        } else {
            c().post(this.f30151f);
        }
    }
}
