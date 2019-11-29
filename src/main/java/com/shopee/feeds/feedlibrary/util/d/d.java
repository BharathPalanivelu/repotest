package com.shopee.feeds.feedlibrary.util.d;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import com.garena.android.appkit.d.a;
import io.b.i.b;
import java.util.HashMap;
import java.util.Map;

public class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, b<a>> f28304a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private boolean f28305b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public void a(String[] strArr) {
        requestPermissions(strArr, 42);
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
            }
            a(strArr, iArr, zArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            e("onRequestPermissionsResult  " + strArr[i]);
            b bVar = this.f28304a.get(strArr[i]);
            boolean z = true;
            if (bVar == null) {
                a.a("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.f28304a.remove(strArr[i]);
            if (iArr[i] != 0) {
                z = false;
            }
            bVar.a(new a(strArr[i], z, zArr[i]));
            bVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public boolean a(String str) {
        return getActivity().checkSelfPermission(str) == 0;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public boolean b(String str) {
        return getActivity().getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
    }

    public b<a> c(String str) {
        return this.f28304a.get(str);
    }

    public boolean d(String str) {
        return this.f28304a.containsKey(str);
    }

    public b<a> a(String str, b<a> bVar) {
        return this.f28304a.put(str, bVar);
    }

    /* access modifiers changed from: package-private */
    public void e(String str) {
        if (this.f28305b) {
            a.b("RxPermissions", str);
        }
    }
}
