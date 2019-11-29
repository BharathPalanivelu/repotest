package com.google.firebase.abt;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.analytics.connector.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@KeepForSdk
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f6750a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6751b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f6752c = null;

    @KeepForSdk
    public b(Context context, a aVar, String str) {
        this.f6750a = aVar;
        this.f6751b = str;
    }

    @KeepForSdk
    public void a(List<Map<String, String>> list) throws a {
        String str;
        b();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> a2 : list) {
                arrayList.add(c.a(a2));
            }
            if (arrayList.isEmpty()) {
                a();
                return;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                hashSet.add(((c) obj).a());
            }
            List<a.C0117a> c2 = c();
            HashSet hashSet2 = new HashSet();
            for (a.C0117a aVar : c2) {
                hashSet2.add(aVar.f6771b);
            }
            ArrayList arrayList3 = new ArrayList();
            for (a.C0117a next : c2) {
                if (!hashSet.contains(next.f6771b)) {
                    arrayList3.add(next);
                }
            }
            a((Collection<a.C0117a>) arrayList3);
            ArrayList arrayList4 = new ArrayList();
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                c cVar = (c) obj2;
                if (!hashSet2.contains(cVar.a())) {
                    arrayList4.add(cVar);
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque(c());
            if (this.f6752c == null) {
                this.f6752c = Integer.valueOf(this.f6750a.a(this.f6751b));
            }
            int intValue = this.f6752c.intValue();
            ArrayList arrayList5 = arrayList4;
            int size3 = arrayList5.size();
            while (i < size3) {
                Object obj3 = arrayList5.get(i);
                i++;
                c cVar2 = (c) obj3;
                while (arrayDeque.size() >= intValue) {
                    a(((a.C0117a) arrayDeque.pollFirst()).f6771b);
                }
                a.C0117a aVar2 = new a.C0117a();
                aVar2.f6770a = this.f6751b;
                aVar2.m = cVar2.d();
                aVar2.f6771b = cVar2.a();
                aVar2.f6772c = cVar2.b();
                if (TextUtils.isEmpty(cVar2.c())) {
                    str = null;
                } else {
                    str = cVar2.c();
                }
                aVar2.f6773d = str;
                aVar2.f6774e = cVar2.e();
                aVar2.j = cVar2.f();
                this.f6750a.a(aVar2);
                arrayDeque.offer(aVar2);
            }
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }

    @KeepForSdk
    public void a() throws a {
        b();
        a((Collection<a.C0117a>) c());
    }

    private final void a(Collection<a.C0117a> collection) {
        for (a.C0117a aVar : collection) {
            a(aVar.f6771b);
        }
    }

    private final void b() throws a {
        if (this.f6750a == null) {
            throw new a("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    private final void a(String str) {
        this.f6750a.b(str, (String) null, (Bundle) null);
    }

    private final List<a.C0117a> c() {
        return this.f6750a.a(this.f6751b, "");
    }
}
