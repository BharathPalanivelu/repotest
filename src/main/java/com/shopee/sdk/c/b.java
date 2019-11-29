package com.shopee.sdk.c;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<WeakReference<c>>> f30339a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f30340b;

    public b(ExecutorService executorService) {
        this.f30340b = executorService;
    }

    public void a(String str, c cVar) {
        List list = this.f30339a.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        if (a((List<WeakReference<c>>) list, cVar) == -1) {
            list.add(new WeakReference(cVar));
        }
        this.f30339a.put(str, list);
    }

    public void b(String str, c cVar) {
        List list = this.f30339a.get(str);
        if (list != null) {
            int a2 = a((List<WeakReference<c>>) list, cVar);
            if (a2 > -1) {
                list.remove(a2);
            }
            if (list.size() == 0) {
                this.f30339a.remove(str);
            }
        }
    }

    public void a(String str, final a aVar) {
        List<WeakReference> list = this.f30339a.get(str);
        if (list != null) {
            for (WeakReference weakReference : list) {
                final c cVar = (c) weakReference.get();
                if (cVar != null) {
                    this.f30340b.execute(new Runnable() {
                        public void run() {
                            try {
                                cVar.a(aVar);
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        }
    }

    private int a(List<WeakReference<c>> list, c cVar) {
        int i = 0;
        for (WeakReference<c> weakReference : list) {
            if (cVar.equals(weakReference.get())) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
