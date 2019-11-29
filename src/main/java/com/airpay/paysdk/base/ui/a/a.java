package com.airpay.paysdk.base.ui.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.d;
import com.airpay.paysdk.base.d.b;
import com.airpay.paysdk.base.interfaces.IPermissionCallback;
import com.airpay.paysdk.base.interfaces.IResultCallback;
import com.airpay.paysdk.base.ui.weidget.f;
import com.airpay.paysdk.c;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public abstract class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected com.airpay.paysdk.base.ui.weidget.a f3840a;

    /* renamed from: b  reason: collision with root package name */
    private f f3841b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<IResultCallback> f3842c;

    /* renamed from: d  reason: collision with root package name */
    private SparseArray<IPermissionCallback> f3843d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f3844e;

    /* renamed from: f  reason: collision with root package name */
    private View f3845f;

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract void b();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        h();
        b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        i();
    }

    /* access modifiers changed from: protected */
    public void a(String str, boolean z, f.a aVar) {
        if (this.f3841b == null) {
            this.f3841b = new f(this);
        }
        this.f3841b.a(str, z, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, f.a aVar) {
        a("", z, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(String str, boolean z) {
        a(str, z, (f.a) null);
    }

    public void a(boolean z) {
        a(z, (f.a) null);
    }

    public void c() {
        f fVar = this.f3841b;
        if (fVar != null) {
            fVar.a();
            this.f3841b = null;
        }
    }

    public void a(int i) {
        com.airpay.paysdk.base.b.a.a().a((Context) this, i);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.airpay.paysdk.base.b.a.a().b((Context) this, str);
        }
    }

    private void h() {
        if (a() != 0) {
            this.f3840a = new com.airpay.paysdk.base.ui.weidget.a(this);
            this.f3840a.setHomeAction(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.finish();
                    com.airpay.paysdk.base.ui.weidget.d.a((Activity) a.this);
                }
            });
            b(true);
            this.f3844e = new LinearLayout(this);
            this.f3844e.setOrientation(1);
            this.f3844e.addView(this.f3840a, new LinearLayout.LayoutParams(-1, -2));
            this.f3845f = LayoutInflater.from(this).inflate(a(), (ViewGroup) null);
            this.f3844e.addView(this.f3845f, new LinearLayout.LayoutParams(-1, -1));
            setContentView((View) this.f3844e);
            return;
        }
        setContentView(new View(this));
        b(false);
    }

    public View d() {
        return this.f3844e;
    }

    public View e() {
        return this.f3845f;
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (!getWindow().hasFeature(1)) {
            requestWindowFeature(1);
        }
    }

    private void i() {
        if (this.f3840a != null) {
            this.f3840a = null;
        }
        SparseArray<IResultCallback> sparseArray = this.f3842c;
        if (sparseArray != null) {
            sparseArray.clear();
            this.f3842c = null;
        }
        SparseArray<IPermissionCallback> sparseArray2 = this.f3843d;
        if (sparseArray2 != null) {
            sparseArray2.clear();
            this.f3843d = null;
        }
    }

    public void a(Intent intent, int i, IResultCallback iResultCallback) {
        if (intent != null) {
            if (this.f3842c == null) {
                this.f3842c = new SparseArray<>();
            }
            if (this.f3842c.get(i) == null) {
                this.f3842c.put(i, iResultCallback);
            }
            startActivityForResult(intent, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SparseArray<IResultCallback> sparseArray = this.f3842c;
        if (sparseArray != null) {
            IResultCallback iResultCallback = sparseArray.get(i);
            if (iResultCallback != null) {
                iResultCallback.run(i2, intent);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        SparseArray<IPermissionCallback> sparseArray = this.f3843d;
        if (sparseArray != null) {
            IPermissionCallback iPermissionCallback = sparseArray.get(i);
            if (iPermissionCallback != null) {
                iPermissionCallback.run(strArr, iArr);
            }
        }
    }

    public void b(boolean z) {
        com.airpay.paysdk.base.ui.weidget.a aVar = this.f3840a;
        if (aVar != null) {
            aVar.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitle(int i) {
        com.airpay.paysdk.base.ui.weidget.a aVar = this.f3840a;
        if (aVar != null) {
            aVar.setTitle(getString(i));
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        com.airpay.paysdk.base.ui.weidget.a aVar = this.f3840a;
        if (aVar != null) {
            aVar.setArrowTheme(6);
            this.f3840a.d();
            this.f3840a.setBackground(c.b.bg_color_blue);
            this.f3840a.setTitleFontColor(getResources().getColor(c.b.com_garena_beepay_text_white));
            if (b.a()) {
                b(getResources().getColor(c.b.status_bar_color_blue));
            }
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void b(int i) {
        Window window = getWindow();
        window.addFlags(RNCartPanelDataEntity.NULL_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(i);
    }
}
