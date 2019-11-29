package com.shopee.arcatch.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.a;
import com.google.a.o;
import com.shopee.sdk.modules.ui.navigator.a.b;
import java.util.ArrayList;

public abstract class a extends Activity implements a.C0029a, com.shopee.sdk.modules.ui.navigator.a.a, b {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f26675c = {"android.permission.CAMERA"};

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.b.a f26676a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.sdk.modules.ui.navigator.b f26677b;

    public void a(int i, String str, o oVar) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f26676a = com.shopee.sdk.b.a().f();
        this.f26677b = com.shopee.sdk.b.a().e();
        com.shopee.sdk.modules.ui.b.a aVar = this.f26676a;
        if (aVar != null) {
            aVar.a(this);
        }
        getWindow().setFlags(128, 128);
        a(false);
        com.shopee.arcatch.b.c.b.a((Activity) this);
    }

    private boolean a(String str) {
        if (androidx.core.content.b.b((Context) this, str) == 0) {
            com.garena.android.appkit.d.a.b("Permission Granted :" + str, new Object[0]);
            return true;
        }
        com.garena.android.appkit.d.a.b("Permission not Granted :" + str, new Object[0]);
        return false;
    }

    private boolean a(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (String str : f26675c) {
            if (!a(str)) {
                arrayList.add(str);
            }
        }
        boolean isEmpty = arrayList.isEmpty();
        if (isEmpty || z) {
            return isEmpty;
        }
        androidx.core.app.a.a(this, (String[]) arrayList.toArray(new String[0]), 1);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        com.shopee.sdk.modules.ui.b.a aVar = this.f26676a;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.shopee.sdk.modules.ui.b.a aVar = this.f26676a;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.shopee.sdk.modules.ui.b.a aVar = this.f26676a;
        if (aVar != null) {
            aVar.d(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        com.shopee.sdk.modules.ui.b.a aVar = this.f26676a;
        if (aVar != null) {
            aVar.e(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.shopee.sdk.modules.ui.b.a aVar = this.f26676a;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f26677b.a((Activity) this, i, i2, intent);
    }

    public String a() {
        return getClass().getSimpleName();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!a(true)) {
            finish();
        }
    }
}
