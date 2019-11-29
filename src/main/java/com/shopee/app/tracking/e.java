package com.shopee.app.tracking;

import android.content.Context;
import android.os.Bundle;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.google.a.q;
import com.google.a.r;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class e implements h {

    /* renamed from: a  reason: collision with root package name */
    private FirebaseAnalytics f19166a;

    /* renamed from: b  reason: collision with root package name */
    private final q f19167b = new q();

    public static e a(Context context) {
        return new e(FirebaseAnalytics.getInstance(context));
    }

    public e(FirebaseAnalytics firebaseAnalytics) {
        this.f19166a = firebaseAnalytics;
    }

    public void a(String str, Map<String, Object> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
        }
        this.f19166a.a(str, bundle);
    }

    public void a(String str, o oVar) {
        Bundle bundle = new Bundle();
        a(bundle, oVar);
        this.f19166a.a(str, bundle);
    }

    private Bundle a(Bundle bundle, o oVar) {
        for (String next : oVar.q()) {
            l c2 = oVar.c(next);
            if (c2.j()) {
                Bundle bundle2 = new Bundle();
                a(bundle2, c2.m());
                bundle.putBundle(next, bundle2);
            } else if (c2.i()) {
                bundle.putParcelableArrayList(next, a(c2.n()));
            } else if (c2.k()) {
                a(bundle, next, c2.o());
            }
        }
        return bundle;
    }

    private ArrayList<Bundle> a(i iVar) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Iterator<l> it = iVar.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            a(bundle, it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private void a(Bundle bundle, l lVar) {
        if (lVar.j()) {
            a(bundle, lVar.m());
        }
    }

    private void a(Bundle bundle, String str, r rVar) {
        if (rVar.r()) {
            bundle.putString(str, rVar.c());
        } else if (rVar.a()) {
            bundle.putBoolean(str, rVar.h());
        } else if (rVar.q()) {
            bundle.putLong(str, rVar.b().longValue());
        }
    }
}
