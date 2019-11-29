package com.shopee.feeds.feedlibrary.util.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.text.TextUtils;
import io.b.d.g;
import io.b.i.b;
import io.b.j;
import io.b.m;
import io.b.n;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f28297a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public d f28298b;

    public c(Activity activity) {
        this.f28298b = a(activity);
    }

    private d a(Activity activity) {
        d dVar;
        d dVar2;
        try {
            dVar = b(activity);
            if (!(dVar == null)) {
                return dVar;
            }
            try {
                dVar2 = new d();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return dVar;
            }
            try {
                FragmentManager fragmentManager = activity.getFragmentManager();
                fragmentManager.beginTransaction().add(dVar2, "RxPermissions").commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
                return dVar2;
            } catch (Exception e3) {
                e = e3;
                dVar = dVar2;
                e.printStackTrace();
                return dVar;
            }
        } catch (Exception e4) {
            e = e4;
            dVar = null;
            e.printStackTrace();
            return dVar;
        }
    }

    private d b(Activity activity) {
        return (d) activity.getFragmentManager().findFragmentByTag("RxPermissions");
    }

    public <T> n<T, Boolean> a(final String... strArr) {
        return new n<T, Boolean>() {
            public m<Boolean> a(j<T> jVar) {
                return c.this.a((j<?>) jVar, strArr).a(strArr.length).a(new g<List<a>, m<Boolean>>() {
                    /* renamed from: a */
                    public m<Boolean> apply(List<a> list) throws Exception {
                        if (list.isEmpty()) {
                            return j.c();
                        }
                        for (a aVar : list) {
                            if (!aVar.f28292b) {
                                return j.b(false);
                            }
                        }
                        return j.b(true);
                    }
                });
            }
        };
    }

    public j<Boolean> b(String... strArr) {
        return j.b(f28297a).a(a(strArr));
    }

    /* access modifiers changed from: private */
    public j<a> a(j<?> jVar, final String... strArr) {
        if (strArr != null && strArr.length != 0) {
            return a(jVar, d(strArr)).a(new g<Object, j<a>>() {
                /* renamed from: a */
                public j<a> apply(Object obj) throws Exception {
                    return c.this.e(strArr);
                }
            });
        }
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    private j<?> d(String... strArr) {
        for (String d2 : strArr) {
            if (!this.f28298b.d(d2)) {
                return j.c();
            }
        }
        return j.b(f28297a);
    }

    private j<?> a(j<?> jVar, j<?> jVar2) {
        if (jVar == null) {
            return j.b(f28297a);
        }
        return j.a(jVar, jVar2);
    }

    /* access modifiers changed from: private */
    @TargetApi(23)
    public j<a> e(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.f28298b.e("Requesting permission " + str);
            if (a(str)) {
                arrayList.add(j.b(new a(str, true, false)));
            } else if (b(str)) {
                arrayList.add(j.b(new a(str, false, false)));
            } else {
                b<a> c2 = this.f28298b.c(str);
                if (c2 == null) {
                    arrayList2.add(str);
                    c2 = b.j();
                    this.f28298b.a(str, c2);
                }
                arrayList.add(c2);
            }
        }
        if (!arrayList2.isEmpty()) {
            c((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return j.a(j.a(arrayList));
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public void c(String[] strArr) {
        d dVar = this.f28298b;
        dVar.e("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.f28298b.a(strArr);
    }

    public boolean a(String str) {
        return !a() || this.f28298b.a(str);
    }

    public boolean b(String str) {
        return a() && this.f28298b.b(str);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
