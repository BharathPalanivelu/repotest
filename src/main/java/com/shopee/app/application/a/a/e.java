package com.shopee.app.application.a.a;

import android.app.Activity;
import com.garena.android.appkit.d.a;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class e implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f15825a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, WeakReference<Activity>> f15826b = new HashMap<>();

    public void a(ar arVar, Activity activity) {
    }

    public void b(ar arVar, Activity activity) {
    }

    public void c(Activity activity) {
    }

    public void d(Activity activity) {
    }

    public void a(Activity activity) {
        String valueOf = String.valueOf(activity.hashCode());
        this.f15825a.add(valueOf);
        this.f15826b.put(valueOf, new WeakReference(activity));
    }

    public void b(Activity activity) {
        String valueOf = String.valueOf(activity.hashCode());
        if (this.f15825a.size() > 2) {
            if (!(this.f15825a.indexOf(valueOf) == this.f15825a.size() - 1)) {
                ArrayList<String> arrayList = this.f15825a;
                Activity activity2 = (Activity) this.f15826b.get(arrayList.get((arrayList.size() - 1) - 2)).get();
                if (activity2 != null && (activity2 instanceof com.shopee.app.ui.a.e)) {
                    com.shopee.app.ui.a.e eVar = (com.shopee.app.ui.a.e) activity2;
                    a();
                    a.b("\n------------\nSTACK_VISIBLE\n------------\n" + eVar.j(), new Object[0]);
                    eVar.m();
                }
            }
        }
    }

    public void e(Activity activity) {
        String valueOf = String.valueOf(activity.hashCode());
        if (this.f15825a.size() > 2) {
            if (!(this.f15825a.indexOf(valueOf) == this.f15825a.size() - 1)) {
                ArrayList<String> arrayList = this.f15825a;
                Activity activity2 = (Activity) this.f15826b.get(arrayList.get((arrayList.size() - 1) - 2)).get();
                if (activity2 != null && (activity2 instanceof com.shopee.app.ui.a.e)) {
                    com.shopee.app.ui.a.e eVar = (com.shopee.app.ui.a.e) activity2;
                    a();
                    a.b("\n------------\nSTACK_GONE\n------------\n" + eVar.j(), new Object[0]);
                    eVar.n();
                }
            }
        }
    }

    public void f(Activity activity) {
        String valueOf = String.valueOf(activity.hashCode());
        this.f15825a.remove(valueOf);
        this.f15826b.remove(valueOf);
    }

    public void a() {
        String str = "\n------------\nSTACK\n------------\n";
        for (int size = this.f15825a.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) this.f15826b.get(this.f15825a.get(size)).get();
            if (activity != null && (activity instanceof com.shopee.app.ui.a.e)) {
                str = str + ((com.shopee.app.ui.a.e) activity).j() + "\n";
            }
        }
        a.b(str, new Object[0]);
    }
}
