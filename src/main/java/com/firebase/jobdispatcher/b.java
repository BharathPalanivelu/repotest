package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.firebase.jobdispatcher.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class b implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7186a;

    public b(Context context) {
        this.f7186a = context;
    }

    private static int a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        int dataSize = obtain.dataSize();
        obtain.recycle();
        return dataSize;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    private static List<String> a(List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return c(str);
        }
        Collections.addAll(list, new String[]{str});
        return list;
    }

    private static List<String> a(boolean z, List<String> list, String str) {
        return z ? a(list, str) : list;
    }

    public List<String> a(r rVar) {
        List<String> a2 = a(a((List<String>) null, a(rVar.f())), a(rVar.c()));
        if (rVar.h() && rVar.f() == y.f7265a) {
            a2 = a(a2, "ImmediateTriggers can't be used with recurring jobs");
        }
        List<String> a3 = a(a2, c(rVar.b()));
        if (rVar.g() > 1) {
            a3 = a(a3, b(rVar.b()));
        }
        return a(a(a3, b(rVar.e())), a(rVar.i()));
    }

    public List<String> a(u uVar) {
        if (uVar == y.f7265a || (uVar instanceof u.b) || (uVar instanceof u.a)) {
            return null;
        }
        return c("Unknown trigger provided");
    }

    public List<String> a(x xVar) {
        int a2 = xVar.a();
        int b2 = xVar.b();
        int c2 = xVar.c();
        boolean z = false;
        List<String> a3 = a(300 > c2, a(c2 < b2, a((a2 == 1 || a2 == 2) ? false : true, (List<String>) null, "Unknown retry policy provided"), "Maximum backoff must be greater than or equal to initial backoff"), "Maximum backoff must be greater than 300s (5 minutes)");
        if (b2 < 30) {
            z = true;
        }
        return a(z, a3, "Initial backoff must be at least 30s");
    }

    private static List<String> b(Bundle bundle) {
        List<String> list = null;
        if (bundle != null) {
            for (String a2 : bundle.keySet()) {
                list = a(list, a(bundle, a2));
            }
        }
        return list;
    }

    private static List<String> c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int a2 = a(bundle);
        if (a2 <= 10240) {
            return null;
        }
        return c(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", new Object[]{Integer.valueOf(a2), 10240}));
    }

    private static String a(Bundle bundle, String str) {
        Object obj = bundle.get(str);
        Class<?> cls = null;
        if (obj == null || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) {
            return null;
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        if (obj != null) {
            cls = obj.getClass();
        }
        objArr[0] = cls;
        objArr[1] = str;
        return String.format(locale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", objArr);
    }

    /* access modifiers changed from: package-private */
    public List<String> a(String str) {
        if (str == null || str.isEmpty()) {
            return c("Service can't be empty");
        }
        Context context = this.f7186a;
        if (context == null) {
            return c("Context is null, can't query PackageManager");
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return c("PackageManager is null, can't validate service");
        }
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f7186a, str);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            Log.e("FJD.GooglePlayReceiver", "Couldn't find a registered service with the name " + str + ". Is it declared in the manifest with the right intent-filter? If not, the job won't be started.");
            return null;
        }
        for (ResolveInfo next : queryIntentServices) {
            if (next.serviceInfo != null && next.serviceInfo.enabled) {
                return null;
            }
        }
        return c(str + " is disabled.");
    }

    private static List<String> b(String str) {
        if (str == null) {
            return c("Tag can't be null");
        }
        if (str.length() > 100) {
            return c("Tag must be shorter than 100");
        }
        return null;
    }

    private static List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }
}
